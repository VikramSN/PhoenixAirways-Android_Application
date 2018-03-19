package com.example.phoenixairways;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
	EditText name,email,contact,pass,repass;
	Button signup;
	String uname,uemail,ucontact,upass,urepass;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		name=(EditText)findViewById(R.id.name);
		email=(EditText)findViewById(R.id.email);
		contact=(EditText)findViewById(R.id.contact);
		pass=(EditText)findViewById(R.id.pass);
		repass=(EditText)findViewById(R.id.repass);
		signup=(Button)findViewById(R.id.regbtn);

		signup.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			if(name.length()<=0) {
				name.setError("this field is required");
			}
			else if(email.length()<=0) {
				email.setError("this field is required");
			}
			else if(contact.length()<=0) {
				contact.setError("this field is required");
			}
			else if(pass.length()<=0) {
				pass.setError("this field is required");
			}
			else if(repass.length()<=0) {
				repass.setError("this field is required");
			}
//			else if(!repass.equals(pass)) {
//				repass.setError("password not matched");
//			}
			else {
				
			new RgTask(Register.this).execute();
			}
				
			}
		});
	}

	private void addNotification() {
	      NotificationCompat.Builder builder =
	         new NotificationCompat.Builder(Register.this)
	         .setSmallIcon(R.drawable.notify)
	         .setContentTitle("Contact Us")
	         .setContentText("Dear "+uname+", Thank you for Registration.\n Your Password is "+upass);

	      Intent notificationIntent = new Intent(Register.this,ContactUs.class);
	      PendingIntent contentIntent = PendingIntent.getActivity(Register.this, 0, notificationIntent,
	         PendingIntent.FLAG_UPDATE_CURRENT);
	      builder.setContentIntent(contentIntent);

	      // Add as notification
	      NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
	      manager.notify(0, builder.build());
	   }
	
	class RgTask extends AsyncTask<Void,Void,Void> {
		private Context context;
		private ProgressDialog pb;
		
		RgTask(Context context){
			this.context=context;
		}
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pb=ProgressDialog.show(context,"Registration","Please Wait...");
		}
		
		@Override
		protected Void doInBackground(Void... arg0) {
			uname=name.getText().toString();
			uemail=email.getText().toString();
			ucontact=contact.getText().toString();
			upass=pass.getText().toString();
			urepass=repass.getText().toString();
			db=openOrCreateDatabase("PA",Context.MODE_PRIVATE,null);
			db.execSQL("create table IF NOT EXISTS REGISTERDATA(id INTEGER PRIMARY KEY AUTOINCREMENT,name text,email text,contact text,password text,repassword text);");
			db.execSQL("insert into REGISTERDATA (name,email,contact,password,repassword) values('"+uname+"','"+uemail+"','"+ucontact+"','"+upass+"','"+urepass+"');");
			db.close();
			return null;
			
		}
		
		
		@Override
		protected void onPostExecute(Void result) {
			pb.dismiss();
			addNotification();
			Intent i = new Intent(Register.this,MainActivity.class);
			i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			super.onPostExecute(result);
		}
		
	}
}
