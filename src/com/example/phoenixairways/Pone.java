package com.example.phoenixairways;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class Pone extends Activity {

	LinearLayout proLayout, AI, JA;
	ImageView proImage;
	TextView runway, flightname, flightno, date, aTime, dTime, duration, bSeat,
			eSeat, bPrice, ePrice, pTotalPrice;
	EditText pname, pemail, pcontact;
	Spinner noPS, pSC;
	Button proSubmit;
	
	//=======================================================================
	String name,email,contact,nop,seat,runname,fname,fno,fdate,at,dt,du,bpri,epri,totalprice;
	//========================================================================
	String peseat[] ={"P1:S1","P2:S2","P3:S3","P4:S4","P5:S5","P6:S6","P7:S7","P8:S8","P9:S9","P10:S10"};
	String psc [] ={"Business Class","Economic Class","Business Class with Food","Economic Class with Food"};
	//===============================================================================
	int csprice;
	int nosprice;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pone);
		// ================================================
		AI = (LinearLayout) findViewById(R.id.aiLayout);
		JA = (LinearLayout) findViewById(R.id.jaLayout);
		proLayout = (LinearLayout) findViewById(R.id.pdetails);
		// ================================================
		proImage = (ImageView) findViewById(R.id.pimage);
		// =====================================================
		runway = (TextView) findViewById(R.id.prn);
		flightname = (TextView) findViewById(R.id.pfn);
		flightno = (TextView) findViewById(R.id.pfno);
		date = (TextView) findViewById(R.id.pd);
		aTime = (TextView) findViewById(R.id.pat);
		dTime = (TextView) findViewById(R.id.pdt);
		duration = (TextView) findViewById(R.id.pdu);
		bSeat = (TextView) findViewById(R.id.pbs);
		eSeat = (TextView) findViewById(R.id.pes);
		bPrice = (TextView) findViewById(R.id.pbp);
		ePrice = (TextView) findViewById(R.id.pep);
		pTotalPrice = (TextView) findViewById(R.id.Ptp);
		// =============================================
		pname = (EditText) findViewById(R.id.Ppn);
		pemail = (EditText) findViewById(R.id.Ppe);
		pcontact = (EditText) findViewById(R.id.Ppc);
		// ==============================================
		noPS = (Spinner) findViewById(R.id.Ppnsspinner);
		pSC = (Spinner) findViewById(R.id.Pscspinner);
		proSubmit = (Button) findViewById(R.id.pro_sub_btn);
//==============================================================
		ArrayAdapter<String> aps=new ArrayAdapter<String>(Pone.this,android.R.layout.simple_spinner_item,peseat);
		noPS.setAdapter(aps);
		
		noPS.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int po,
					long arg3) {
				if(po==0){
					nosprice=1;
				}else if(po==1){
					nosprice=2;
				}else if(po==2){
					nosprice=3;
				}else if(po==3){
					nosprice=4;
				}else if(po==4){
					nosprice=5;
				}else if(po==5){
					nosprice=6;
				}else if(po==6){
					nosprice=7;
				}else if(po==7){
					nosprice=8;
				}else if(po==8){
					nosprice=9;
				}else if(po==9){
					nosprice=10;
				}
				
			}
		});
		
//=========================================================================		
		ArrayAdapter<String> apsc=new ArrayAdapter<String>(Pone.this,android.R.layout.simple_spinner_item,psc);
		pSC.setAdapter(apsc);
		
		pSC.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int po,
					long arg3) {
				if(po==0){
					csprice=12499;
				}else if(po==1){
					csprice=12499+1000;
				}else if(po==2){
					csprice=10399;
				}else if(po==3){
					csprice=10399+1000;
				}
				
			}
		});
		
		//=======================================================================
		AI.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
			proLayout.setVisibility(View.VISIBLE);
			proImage.setImageResource(R.drawable.aero);
			runway.setText("IGAI");
			flightname.setText("AirLine");
			flightno.setText("F123");
			date.setText("6 march,2018");
			aTime.setText("9:00 AM");
			dTime.setText("1:00 PM");
			duration.setText("4 hrs.");
			bSeat.setText("10");
			eSeat.setText("10");
			bPrice.setText("12,499");
			ePrice.setText("10,399");
//			pTotalPrice.setText("F123");
				
			}
		});
		
		//=======================================================================
		JA.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				proLayout.setVisibility(View.VISIBLE);
				proImage.setImageResource(R.drawable.aero);
				runway.setText("IGAI");
				flightname.setText("JetAirways");
				flightno.setText("F456");
				date.setText("12 april,2018");
				aTime.setText("3:00 PM");
				dTime.setText("8:00 PM");
				duration.setText("5 hrs.");
				bSeat.setText("10");
				eSeat.setText("10");
				bPrice.setText("19,499");
				ePrice.setText("22,399");
//				pTotalPrice.setText("F123");
				
			}
		});
	}
	
//	class proTask extends AsyncTask<Void,Void,Void> {
//	
//			private Context context;
//			private	ProgressDialog pd;
//				public proTask(Context context) {
//				this.context=context;
//				}
//
//			@Override
//				protected void onPreExecute() {
//					super.onPreExecute();
//
//			pd=ProgressDialog.show(context,"Booking...","Please Wait...");
//				}
//				
//				@Override
//				protected Void doInBackground(Void... param) {
//					ccname=cname.getText().toString();
//					ccemail=cemail.getText().toString();
//					ccmsg=cmsg.getText().toString();
//					db=getActivity().openOrCreateDatabase("PA",Context.MODE_PRIVATE,null);
//					db.execSQL("create table IF NOT EXISTS CONTACTUS(id INTEGER PRIMARY KEY AUTOINCREMENT,name text,email text,msg text);");
//					db.execSQL("insert into CONTACTUS(name,email,msg) values('"+ccname+"','"+ccemail+"','"+ccmsg+"');");
//					db.close();
//					return null;
//				}
//
//
//				@Override
//				protected void onPostExecute(Void result) {
//					pd.dismiss();
//					addNotification();
//					Toast.makeText(context,"Query Submited", Toast.LENGTH_SHORT).show();
//					cname.setText("");
//					cemail.setText("");
//					cmsg.setText("");
//					super.onPostExecute(result);
//				}
//				
//	}

	}

