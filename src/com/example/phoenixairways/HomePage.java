package com.example.phoenixairways;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends Activity {

	private static final int SELECT_PICTURE = 100;
    private static final String TAG = "HomePage";
	
	private DrawerLayout dl;
	private ListView lv;
	private String pages[];
	private ArrayAdapter<String> adapter;
	//private Typeface tf;
	private ActionBarDrawerToggle dlis;
	FragmentManager fm = getFragmentManager();


	ImageView ppic, pedit, plogout;
	TextView pname;
	Cursor cc;
	SQLiteDatabase db;
	Intent i;
	String username;
	Dialog openDialog;
	EditText uname,uemail,ucontact,upass,upic;
	Button update;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		dl = (DrawerLayout) findViewById(R.id.drawerLayout);
		lv = (ListView) findViewById(R.id.drawerList);
		ppic = (ImageView) findViewById(R.id.profilepic);
		pedit = (ImageView) findViewById(R.id.Profileedited);
		plogout = (ImageView) findViewById(R.id.logout);
		pname = (TextView) findViewById(R.id.profilename);
		//=================================================================
		plogout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HomePage.this);
			      alertDialogBuilder.setMessage("Do you want to LogOut ?");
			      alertDialogBuilder.setPositiveButton("Yes", 
			         new DialogInterface.OnClickListener() {
			         @Override
			         public void onClick(DialogInterface arg0, int arg1) {
			        	 Intent i = new Intent(HomePage.this,MainActivity.class);
							i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
							startActivity(i);        
			         }
			      });

			      alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
			         public void onClick(DialogInterface dialog, int which) {
			        dialog.dismiss();
			         }
			      });

			      AlertDialog alertDialog = alertDialogBuilder.create();
			      alertDialog.show();
				
				
			}
		});
		
		// ===========================================================================
		i = getIntent();
		username= i.getStringExtra("KeyName");
		pname.setText(username);
		// ==========================================================================

		pedit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				openDialog = new Dialog(HomePage.this);
				openDialog.setContentView(R.layout.profileedit);
				openDialog.setTitle("Update Profile");
				openDialog.show();
				uname = (EditText) openDialog
						.findViewById(R.id.updateName);
				uemail = (EditText) openDialog
						.findViewById(R.id.updateEmail);
				ucontact = (EditText) openDialog
						.findViewById(R.id.updateContact);
				upass = (EditText) openDialog
						.findViewById(R.id.updatePassword);
				upic = (EditText) openDialog
						.findViewById(R.id.choosePic);
				update = (Button) openDialog
						.findViewById(R.id.submitbtn);
				
				// ====================================================================
				i = getIntent();
				username= i.getStringExtra("KeyName");
				db = openOrCreateDatabase("PA", Context.MODE_PRIVATE, null);
				cc = db.query("REGISTERDATA", null, null, null, null, null, null);
				if (cc.moveToFirst()) {
					while (cc.isAfterLast() == false) {
						if (username.equalsIgnoreCase(cc.getString(1))) {
							uname.setText(cc.getString(1));
							uemail.setText(cc.getString(2));
							ucontact.setText(cc.getString(3));
							upass.setText(cc.getString(4));

						} else {
							//
							if (cc.isLast() == true) {
							}
						}
						cc.moveToNext();

					}
				}
				cc.close();
				// =============================================================================

				update.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {

						new UpdateTask(HomePage.this).execute();
						//finish();
						Intent i = new Intent(HomePage.this,HomePage.class);
						i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(i);
					}
				});
				
				//=================================================================
				upic.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View arg0) {
					
						Intent intent = new Intent();
				        intent.setType("image/*");
				        intent.setAction(Intent.ACTION_GET_CONTENT);
				        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
					}
				});
			}
		});

		// ==============================================================================

		dlis = new ActionBarDrawerToggle(this, dl, R.drawable.ic_drawer,
				R.string.drawer_open, R.string.drawer_close);
		dl.setDrawerListener(dlis);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		//tf = Typeface.createFromAsset(getAssets(), "fs.ttf");
		pages = getResources().getStringArray(R.array.page);
		adapter = new ArrayAdapter<String>(HomePage.this,
				android.R.layout.simple_list_item_1, pages) {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view = super.getView(position, convertView, parent);
				TextView tv = (TextView) view.findViewById(android.R.id.text1);
				tv.setTextColor(Color.BLACK);
				//tv.setTypeface(tf, Typeface.BOLD);
				return view;
			}
		};
		lv.setAdapter(adapter);	
		// ==================================================================================

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adp, View v, int po, long l) {
				if (po == 0) {
					Home h = new Home();
					FragmentTransaction ft = fm.beginTransaction();
					ft.add(R.id.mainContent, h);
					dl.closeDrawers();
					ft.commit();
					Toast.makeText(getApplicationContext(), pages[po],
							Toast.LENGTH_SHORT).show();
					
				}else if(po==1){
					FragmentTransaction ft = fm.beginTransaction();
					Products p = new Products();
					ft.replace(R.id.mainContent,p);
					dl.closeDrawers();
					ft.commit();
					Toast.makeText(getApplicationContext(), pages[po],
							Toast.LENGTH_SHORT).show();
				
				}
				else if(po==2){
					FragmentTransaction ft = fm.beginTransaction();
					FAQ f = new FAQ();
					ft.replace(R.id.mainContent, f);
					dl.closeDrawers();
					ft.commit();
					Toast.makeText(getApplicationContext(), pages[po],
							Toast.LENGTH_SHORT).show();
				
				}else if(po==3){
					FragmentTransaction ft = fm.beginTransaction();
					ContactUs cu = new ContactUs();
					ft.replace(R.id.mainContent, cu);
					dl.closeDrawers();
					ft.commit();
					Toast.makeText(getApplicationContext(), pages[po],
							Toast.LENGTH_SHORT).show();
				}

				
			}

		});

	}
	//========================================================================
	
	private void addNotification() {
	      NotificationCompat.Builder builder =
	         new NotificationCompat.Builder(this)
	         .setSmallIcon(R.drawable.notify)
	         .setContentTitle("Profile Update")
	         .setContentText(uname+", your Profile has updated successfully.");

	      Intent notificationIntent = new Intent(this,ContactUs.class);
	      PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
	         PendingIntent.FLAG_UPDATE_CURRENT);
	      builder.setContentIntent(contentIntent);

	      // Add as notification
	      NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
	      manager.notify(0, builder.build());
	   }
	
	//======================================================================
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // Get the path from the Uri
                    String path = getPathFromURI(selectedImageUri);
                    Log.i(TAG, "Image Path : " + path);
                    upic.setText(path);
                    // Set the image in ImageView
                    ppic.setImageURI(selectedImageUri);
                }
            }
        }
		super.onActivityResult(requestCode, resultCode, data);
	}
	//====part of above=========
	public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }
 
	
//======================================================================================
	class UpdateTask extends AsyncTask<Void, Void, Void> {
		private Context context;
		private	ProgressDialog pd;
			public UpdateTask(Context context) {
			this.context=context;
			}

		@Override
			protected void onPreExecute() {
				super.onPreExecute();

		pd=ProgressDialog.show(context,"Update","Please Wait...");
			}
			
			@Override
			protected Void doInBackground(Void... param) {
				i = getIntent();
				username= i.getStringExtra("KeyName");
				String name = uname.getText().toString(), email = uemail
						.getText().toString(), contact = ucontact.getText()
						.toString(), pass = upass.getText().toString();
				String query="UPDATE REGISTERDATA SET name='"+name+"',email='"+email+"',contact='"+contact+"',password='"+pass+"' WHERE name='"+username+"' ";
				db.execSQL(query);
				openDialog.dismiss();
				
				return null;
			}


			@Override
			protected void onPostExecute(Void result) {
				pd.dismiss();
				addNotification();
				Toast.makeText(context,"Successfully Update", Toast.LENGTH_SHORT).show();
				super.onPostExecute(result);
			}
			
}
}
