package com.example.phoenixairways;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText email, pass;
	Button login;
	TextView aclink;
	SQLiteDatabase db;
	Cursor cc;
	String logmail, logpass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		email = (EditText) findViewById(R.id.useremail);
		pass = (EditText) findViewById(R.id.userpassword);
		login = (Button) findViewById(R.id.login);
		aclink = (TextView) findViewById(R.id.accountlink);

		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (email.length() <= 0) {
					email.setError("this field is required");
				} else if (pass.length() <= 0) {
					pass.setError("this field is required");
				} else {
					new Ltask(MainActivity.this).execute();
				}

			}
		});

		aclink.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(MainActivity.this, Register.class);
				startActivity(i);

			}
		});
	}

	class Ltask extends AsyncTask<Void, Void, Void> {
		Context context;
		ProgressDialog pd;

		Ltask(Context context) {
			this.context = context;
		}

		@Override
		protected void onPreExecute() {
			pd = ProgressDialog.show(context, "Login", "Please Wait...");
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			logmail = email.getText().toString();
			logpass = pass.getText().toString();
			db = openOrCreateDatabase("PA", Context.MODE_PRIVATE, null);
			cc = db.query("REGISTERDATA", null, null, null, null, null, null);
			if (cc.moveToFirst()) {
				while (cc.isAfterLast() == false) {
					if (logmail.equalsIgnoreCase(cc.getString(2))
							&& (logpass.equals(cc.getString(4)))) {
						Intent i = new Intent(MainActivity.this,HomePage.class);
						i.putExtra("KeyName", cc.getString(1));
						startActivity(i);
					} else if(logmail.equalsIgnoreCase("pa@gmail.com") 
						&& (logpass.equals("pa@321"))) {
						
						Intent i = new Intent(MainActivity.this,Admin.class);
						startActivity(i);
					}
					
					else {
						if (cc.isLast() == true) {
							publishProgress();
						}
					}
					cc.moveToNext();
				}

			}
			cc.close();
			db.close();
			return null;
		}

		@Override
		protected void onProgressUpdate(Void... values) {
			Toast.makeText(context, "Invalid Login", Toast.LENGTH_SHORT).show();
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(Void result) {
			pd.dismiss();
			super.onPostExecute(result);
		}

	}
}
