package com.example.phoenixairways;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

public class UploadProduct extends Activity {
	EditText arunway, aflightname, aflightno, afrom, ato, adate, aaTime,
			adTime, aduration, bPrice, ePrice;
	Spinner abSeat, aeSeat;
	Button submit;
	DatePickerDialog.OnDateSetListener date;
	Calendar myCalendar;
	// =========================
	SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_upload_product);
		arunway = (EditText) findViewById(R.id.arn);
		aflightname = (EditText) findViewById(R.id.afn);
		aflightno = (EditText) findViewById(R.id.afno);
		afrom = (EditText) findViewById(R.id.afrom);
		ato = (EditText) findViewById(R.id.ato);
		adate = (EditText) findViewById(R.id.adate);
		aaTime = (EditText) findViewById(R.id.aat);
		adTime = (EditText) findViewById(R.id.adt);
		aduration = (EditText) findViewById(R.id.adu);
		bPrice = (EditText) findViewById(R.id.abp);
		ePrice = (EditText) findViewById(R.id.aep);

		abSeat = (Spinner) findViewById(R.id.absspinner);
		aeSeat = (Spinner) findViewById(R.id.aesspinner);
		submit = (Button) findViewById(R.id.Psbtn);
		
		//=====================================================
		myCalendar = Calendar.getInstance();
		date = new DatePickerDialog.OnDateSetListener() {

		    @Override
		    public void onDateSet(DatePicker view, int year, int monthOfYear,
		            int dayOfMonth) {
		        
		        myCalendar.set(Calendar.YEAR, year);
		        myCalendar.set(Calendar.MONTH, monthOfYear);
		        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		        updateLabel();
		    }

		};

		adate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				new DatePickerDialog(UploadProduct.this, date, myCalendar
	                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
	                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
				
			}
		});
		
//========================================================================
		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {

			}
		});

	}
	
	private void updateLabel() {
	    String myFormat = "MM/dd/yy"; //In which you need put here
	    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

	    adate.setText(sdf.format(myCalendar.getTime()));
	    }
}
