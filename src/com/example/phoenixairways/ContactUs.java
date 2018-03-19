package com.example.phoenixairways;

import android.app.Fragment;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ContactUs extends Fragment implements OnClickListener {

	EditText cname,cemail,cmsg;
	Button csubmit;
	SQLiteDatabase db;
	Cursor c;
	String ccname,ccemail,ccmsg;
	Intent i;
	String username;
	ImageView fb, linkedin, gmail, gplus, insta, pin;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
	View v=inflater.inflate(R.layout.activity_contact_us,container,false);
	cname=(EditText)v.findViewById(R.id.contName);
	cemail=(EditText)v.findViewById(R.id.contEmail);
	cmsg=(EditText)v.findViewById(R.id.contMsg);
	csubmit=(Button)v.findViewById(R.id.contSubmitBtn);
	
	fb = (ImageView) v.findViewById(R.id.fb);
	linkedin = (ImageView) v.findViewById(R.id.link);
	gmail = (ImageView) v.findViewById(R.id.gmail);
	gplus = (ImageView) v.findViewById(R.id.googleplus);
	insta = (ImageView) v.findViewById(R.id.insta);
	pin = (ImageView) v.findViewById(R.id.pint);

	fb.setOnClickListener(this);
	linkedin.setOnClickListener(this);
	gmail.setOnClickListener(this);
	gplus.setOnClickListener(this);
	insta.setOnClickListener(this);
	pin.setOnClickListener(this);
	//============================================================
	i = getActivity().getIntent();
	username= i.getStringExtra("KeyName");
	db = getActivity().openOrCreateDatabase("PA",Context.MODE_PRIVATE, null);
	c = db.query("REGISTERDATA", null, null, null, null, null, null);
	if (c.moveToFirst()) {
		while (c.isAfterLast() == false) {
			if (username.equalsIgnoreCase(c.getString(1))) {
				cname.setText(c.getString(1));
				cemail.setText(c.getString(2));
			} else {
				if (c.isLast() == true) {
				}
			}
			c.moveToNext();
		}
	}
	c.close();
	//======================================================================

	csubmit.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		
			if(cname.length()<=0){
				cname.setError("This field is required");
			} else if(cemail.length()<=0){
				cemail.setError("This field is required");
			} else if(cmsg.length()<=0){
				cmsg.setError("This field is required");
			} else {
				new ContactTask(getActivity()).execute();
				
			}
			
		}
	});

	
	return v;
	}
//========================================================================	
	private void addNotification() {
	      NotificationCompat.Builder builder =
	         new NotificationCompat.Builder(getActivity())
	         .setSmallIcon(R.drawable.notify)
	         .setContentTitle("Contact Us")
	         .setContentText(ccname+", your querry has submitted successfully.");

	      Intent notificationIntent = new Intent(getActivity(),ContactUs.class);
	      PendingIntent contentIntent = PendingIntent.getActivity(getActivity(), 0, notificationIntent,
	         PendingIntent.FLAG_UPDATE_CURRENT);
	      builder.setContentIntent(contentIntent);

	      // Add as notification
	      NotificationManager manager = (NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
	      manager.notify(0, builder.build());
	   }
	
	//===============================================================================
	class ContactTask extends AsyncTask<Void, Void, Void> {
		private Context context;
		private	ProgressDialog pd;
			public ContactTask(Context context) {
			this.context=context;
			}

		@Override
			protected void onPreExecute() {
				super.onPreExecute();

		pd=ProgressDialog.show(context,"Sending Query","Please Wait...");
			}
			
			@Override
			protected Void doInBackground(Void... param) {
				ccname=cname.getText().toString();
				ccemail=cemail.getText().toString();
				ccmsg=cmsg.getText().toString();
				db=getActivity().openOrCreateDatabase("PA",Context.MODE_PRIVATE,null);
				db.execSQL("create table IF NOT EXISTS CONTACTUS(id INTEGER PRIMARY KEY AUTOINCREMENT,name text,email text,msg text);");
				db.execSQL("insert into CONTACTUS(name,email,msg) values('"+ccname+"','"+ccemail+"','"+ccmsg+"');");
				db.close();
				return null;
			}


			@Override
			protected void onPostExecute(Void result) {
				pd.dismiss();
				addNotification();
				Toast.makeText(context,"Query Submited", Toast.LENGTH_SHORT).show();
				cname.setText("");
				cemail.setText("");
				cmsg.setText("");
				super.onPostExecute(result);
			}
			
}

	@Override
	public void onClick(View vv) {
switch(vv.getId()) {
		
		case R.id.fb:
			Intent i = new Intent(Intent.ACTION_VIEW);
			i.setData(Uri.parse("https://www.facebook.com/"));
			startActivity(i);
						break;
					case R.id.link:
						Intent i2 = new Intent(Intent.ACTION_VIEW);
						i2.setData(Uri.parse("https://in.linkedin.com/"));
						startActivity(i2);
						break;
					case R.id.gmail:
						Intent i3 = new Intent(Intent.ACTION_VIEW);
						i3.setData(Uri.parse("http://www.gmail.com/"));
						startActivity(i3);
						break;
					case R.id.googleplus:
						Intent i4 = new Intent(Intent.ACTION_VIEW);
						i4.setData(Uri.parse("https://plus.google.com/discover"));
						startActivity(i4);
						break;
					case R.id.insta:
						Intent i5 = new Intent(Intent.ACTION_VIEW);
						i5.setData(Uri.parse("https://www.instagram.com/?hl=en"));
						startActivity(i5);
						break;
					case R.id.pint:
						Intent i6 = new Intent(Intent.ACTION_VIEW);
						i6.setData(Uri.parse("https://in.pinterest.com/"));
						startActivity(i6);
						break;
		}

		
	}
	
	
}
