package com.example.phoenixairways;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Products extends Fragment {
	GridView gv;
	static String product_name[] = { "IGAI", "CSIA", "NSIA", "CIA","VIA","SIA"};
	static int product_image[] = { R.drawable.pone, R.drawable.ptwo, R.drawable.pthree,R.drawable.pfour,R.drawable.pfive,R.drawable.psix};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View x = inflater.inflate(R.layout.activity_products, container, false);
		gv = (GridView) x.findViewById(R.id.gridPro);
		MyAdapter adapter = new MyAdapter(getActivity(), product_name,product_image);
		gv.setAdapter(adapter);
		
		
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> dftr, View biu, int pos,
					long lng) {
				
				if(pos==0){
					
					Intent i = new Intent(getActivity(),Pone.class);
					startActivity(i);
				}
				else if(pos==1){
					
					Intent i = new Intent(getActivity(),ErrorPage.class);
					startActivity(i);
				}else if(pos==2){
					
					Intent i = new Intent(getActivity(),ErrorPage.class);
					startActivity(i);
				}else if(pos==3){
					
					Intent i = new Intent(getActivity(),ErrorPage.class);
					startActivity(i);
				}else if(pos==4){
					
					Intent i = new Intent(getActivity(),ErrorPage.class);
					startActivity(i);
				}else if(pos==5){
					
					Intent i = new Intent(getActivity(),ErrorPage.class);
					startActivity(i);
				}
				
			Toast.makeText(getActivity(), "You clicked : "+product_name[pos],Toast.LENGTH_SHORT).show();
				
			}
		});
		
		return x;
	}

	class MyAdapter extends BaseAdapter {
		Context context;
		String product_name[];
		int product_image[];

		public MyAdapter(Context context, String[] product_name,
				int[] product_image) {
			this.context = context;
			this.product_name = product_name;
			this.product_image = product_image;
		}
		
		@Override
		public int getCount() {
			
			return product_name.length;
		}

		@Override
		public Object getItem(int po) {
			return po;
		}

		@Override
		public long getItemId(int po) {
			return po;
		}


		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			View vv;
			if(convertView==null){
			
			vv= inflater.inflate(R.layout.custprolist,null);
			TextView pn = (TextView) vv.findViewById(R.id.gridText);
			ImageView pimg = (ImageView) vv.findViewById(R.id.gridImage);
			pn.setText(product_name[position]);
			pimg.setImageResource(product_image[position]);
			}else {
				vv=convertView;
			}
			
			return vv;
		}

	}

}
