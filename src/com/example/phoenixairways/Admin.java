package com.example.phoenixairways;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Admin extends Activity {

	ListView adminLv;
	String aname[] = {"Dashboard", "Users", "Products", "Upload Product",
			"Contacts", "Booked User" };
	int aimg[] = { R.drawable.d, R.drawable.u, R.drawable.p, R.drawable.u,
			R.drawable.c, R.drawable.b };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);
		adminLv = (ListView) findViewById(R.id.adminList);
		AdminAdapter aad = new AdminAdapter(Admin.this, aname, aimg);
		adminLv.setAdapter(aad);
	//====================================================================
	adminLv.setOnItemClickListener(new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int po,
				long arg3) {
			
			if(po==0){
				
			}else if(po==1){
				
			}else if(po==2){
				
			}else if(po==3){
				
				Intent i = new Intent(Admin.this,UploadProduct.class);
				startActivity(i);
				
			}else if(po==4){
				
			}else if(po==5){
				
			}
			
			
		}
	});
	
	}
	
	
	//=====================================================================
	class AdminAdapter extends ArrayAdapter<String> {
		Context context;
		String[] aname;
		int aimg[];

		public AdminAdapter(Context context, String[] aname, int[] aimg) {
			super(context, R.layout.custadminlist, R.id.AdmincustText,aname);
			this.context = context;
			this.aname = aname;
			this.aimg = aimg;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			View vv= inflater.inflate(R.layout.custadminlist,parent,false);
				TextView pn = (TextView) vv.findViewById(R.id.AdmincustText);
				ImageView pimg = (ImageView) vv.findViewById(R.id.AdmincustImg);
				pn.setText(aname[position]);
				pimg.setImageResource(aimg[position]);
			
			return vv;
		}

	}

}
