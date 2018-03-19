package com.example.phoenixairways;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Home extends Fragment implements OnClickListener {

	Button bt1, bt2, bt3, bt4, iv2, iv3;
	ImageView iv1, iv4, fb, linkedin, gmail, gplus, insta, pin;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_home, container, false);
		bt1 = (Button) v.findViewById(R.id.btn1);
		bt2 = (Button) v.findViewById(R.id.btn2);
		bt3 = (Button) v.findViewById(R.id.btn3);
		bt4 = (Button) v.findViewById(R.id.btn4);
		iv2 = (Button) v.findViewById(R.id.ivb2);
		iv3 = (Button) v.findViewById(R.id.ivb3);

		iv1 = (ImageView) v.findViewById(R.id.iv1);
		iv4 = (ImageView) v.findViewById(R.id.iv4);
		fb = (ImageView) v.findViewById(R.id.fb);
		linkedin = (ImageView) v.findViewById(R.id.link);
		gmail = (ImageView) v.findViewById(R.id.gmail);
		gplus = (ImageView) v.findViewById(R.id.googleplus);
		insta = (ImageView) v.findViewById(R.id.insta);
		pin = (ImageView) v.findViewById(R.id.pint);

		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);
		iv2.setOnClickListener(this);
		iv3.setOnClickListener(this);
		iv1.setOnClickListener(this);
		iv4.setOnClickListener(this);
		fb.setOnClickListener(this);
		linkedin.setOnClickListener(this);
		gmail.setOnClickListener(this);
		gplus.setOnClickListener(this);
		insta.setOnClickListener(this);
		pin.setOnClickListener(this);

		return v;

	}

	@Override
	public void onClick(View v) {
		final Dialog openDialog = new Dialog(getActivity());
		switch (v.getId()) {

		case R.id.btn1:
			openDialog.setContentView(R.layout.igia);
			openDialog.setTitle("IGIA");
			openDialog.show();
			Button cls = (Button) openDialog.findViewById(R.id.closebtn);
			cls.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
					openDialog.dismiss();
					
				}
			});
			break;
		case R.id.btn2:
			openDialog.setContentView(R.layout.csia);
			openDialog.setTitle("CSIA");
			openDialog.show();
			Button cls2 = (Button) openDialog.findViewById(R.id.closebtn);
			cls2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
					openDialog.dismiss();
				}
			});
			break;
		case R.id.btn3:
			openDialog.setContentView(R.layout.nsia);
			openDialog.setTitle("NSIA");
			openDialog.show();
			Button cls3 = (Button) openDialog.findViewById(R.id.closebtn);
			cls3.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
					openDialog.dismiss();
				}
			});
			break;
		case R.id.btn4:
			openDialog.setContentView(R.layout.cia);
			openDialog.setTitle("CIA");
			openDialog.show();
			Button cls4 = (Button) openDialog.findViewById(R.id.closebtn);
			cls4.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
					openDialog.dismiss();
				}
			});
			break;
		case R.id.ivb2:

			break;
		case R.id.ivb3:

			break;
		case R.id.iv1:

			break;
		case R.id.iv4:

			break;
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
