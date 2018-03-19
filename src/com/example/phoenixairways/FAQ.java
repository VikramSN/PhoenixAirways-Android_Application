package com.example.phoenixairways;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

public class FAQ extends Fragment implements OnClickListener {
	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	ImageView fb, linkedin, gmail, gplus, insta, pin;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
View v=inflater.inflate(R.layout.activity_faq,container,false);
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
expListView = (ExpandableListView)v.findViewById(R.id.xlistFaq);

// preparing list data
prepareListData();

listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader,
		listDataChild);

// setting list adapter
expListView.setAdapter(listAdapter);

	return v;
}
	
	private void prepareListData() {
		listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();

		// Adding child data
		listDataHeader.add("Q.1 :- How can i cancel my tickets ?");
		listDataHeader
				.add("Q.2 :- What documents do I need to carry to check-in for my flight?");
		listDataHeader
				.add("Q.3 :-What are the cancellation charges applicable on cancelling a train ticket?");

		listDataHeader
				.add("Q.4 :-How can I change the date of my flight booking?");
		listDataHeader
				.add("Q.5 :- I have booked my tickets online. How can I get another copy of my E-Ticket?");
		listDataHeader
				.add("Q.6 :- Online Cancellation & Refund"
						+ "How do I get a refund for tickets that I have directly cancelled with airlines?");
		listDataHeader
				.add("Q.7 :-How do I become a registered member of MakeMyTrip?");

		listDataHeader
				.add("Q.8 :- How do I check if my flight is on time or not?");

		listDataHeader
				.add("Q.9 :-I am unable to cancel my domestic air travel tickets online. What do I do?");

		// Adding child data
		List<String> q1 = new ArrayList<String>();
		q1.add("1.To cancel your tickets, simply follow the steps below:"
				+ "* Log onto www.makemytrip.com"
				+ "* Click on the Customer Support link"
				+ "* Click on Cancel Bookings button under the Flights section"
				+ "* Enter the MakeMyTrip Booking ID corresponding to your booking and the Contact Number that you gave at the time of the booking."
				+ "* You can choose to cancel your entire booking or cancel any specific passengers or sectors in your booking after you log in."
				+ "* Please review the cancellation penalty and refund amount before you confirm to cancel the booking."
				+ "* The refund amount would reflect in the same account that was used to make the payment at the time of the booking."

				+ "You can also cancel your ticket(s) by logging into your account using your email id and password under the My Bookings section on the Custoemr Support page."

				+ "** We now also support cancellation of select international flights online.");

		List<String> q2 = new ArrayList<String>();
		q2.add("It is mandatory to carry a government issued photo identification (ID) proof along with the E-Ticket copy. The same is verified by the airport security as well as the airline at the check in counter. On presenting your photo ID proof and E-Ticket copy, your boarding pass will be issued. For international flights, your passport is the only valid photo ID proof that will be accepted."
				+ "In case of an infant travelling, it is mandatory to carry the birth certificate of the infant along with the ticket. "
				+ "It is not mandatory to carry the credit/debit card that was used to make the payment at the time of the booking, if you have booked through MakeMyTrip. (we do not pass on your account details to the airline).");

		List<String> q3 = new ArrayList<String>();
		q3.add("Cancellation penalty varies by the quota you have booked your ticket in, time before departure of the train, PNR status, class of travel and distance for which reservation is done. You can find indicative information below to help you calculate your cancellation penalties. For more detailed information,"
				+ "If a confirmed ticket is cancelled more than 24 hrs before the scheduled departure of the train, flat cancellation charges shall be deducted @ Rs.70/- for AC First Class/Executive Class, Rs.60/- for AC 2 Tier/AC 3 Tier/First Class/AC Chair car, Rs.40/- for Sleeper Class and Rs.20/- for Second Class. Cancellation charges are per passenger."
				+ "If a confirmed ticket is cancelled within 24 hrs and up to 4 hours before the scheduled departure of the train, cancellation charges shall be 25% of the fare subject to the minimum flat rate mentioned in the above clause."
				+ "Less than 4 hours before the schedule departure of the train upto chart preparation of the train, 50% of the fare paid subject to the minimum cancellation charges. Note the Chart preparation time is the time for the chart preparation from the Train Originating Station or from the Previous chart Preparation station."
				+ "For Taktal quota tickets, a flat refund of 25% of total fare charged on ticket, excluding Tatkal Charges is granted on cancellation of confirmed Tatkal tickets, which are cancelled up to 24 hrs before the schedule departure of train. No refund on confirmed Tatkal tickets is granted when cancelled within 24 hrs of the schedule departure of train. For contingent cancellation and waitlisted Tatkal ticket cancellations, charges will be deducted as per existing Railway rules.");

		List<String> q4 = new ArrayList<String>();
		q4.add("Date Change may be permissible on your booking on payment of Airline Date Change Fee, MakeMyTrip Service Charges plus any fare difference that may exist between your original fare and the fare of the flight that you want to change to. The date change fees and MakeMyTrip Service Charges are printed on your E-Ticket. In several cases, the date change fees and the cancellation fees levied by the airline is the same and you could also cancel the ticket online and make a fresh booking at the same cost as that of doing a date change. Please note that date change may not be permitted on certain tickets. "
				+ "You would need to get in touch with our Customer Care helpline to do any change of flights in your booking. "
				+ "If you want to change your flight to a flight that is operated by another airline, you will need to cancel your existing booking and make a fresh booking. Please visit our Customer Support section to cancel your booking online. Our online cancellation service lets you cancel a part of your booking by selecting the passengers and sectors you wish to cancel or cancel your complete booking in quick time.");

		List<String> q5 = new ArrayList<String>();
		q5.add("To view and take a printout of your E-Ticket, simply follow the steps below:"

				+ "* Log onto www.makemytrip.com"
				+ "* Click on the Customer Support link"
				+ "* Click on “Print E-Tickets” button under your product type (Domestic Flights, International Flights, Rail)"
				+ "* Enter the MakeMyTrip Booking ID corresponding to your booking and the Contact Number given at the time of making the Booking.");

		List<String> q6 = new ArrayList<String>();
		q6.add("If you have cancelled the booking directly with the airline, you would need to inform MakeMyTrip of the same."
				+ "Please log on to( https://support.makemytrip.com/customersupports.aspx )to inform us of the cancellation,"
				+ "under Special Claims."

				+ "You can also submit request for Special Claims against (NO SHOW) un-utilized ticket, and flight not operational cases."

				+ "On receiving your confirmation, Make My Trip will validate the refund amount with the airline and then process the refund to your account."
				+ "Please note that MakeMyTrip shall charge Rs. 250 per sector per passenger as a cancellation service fee over and above "
				+ "the individual airline cancellation fee.");

		List<String> q7 = new ArrayList<String>();
		q7.add("Becoming a registered member of PheonixAirways is easy and free of cost. To register, click on the Register with Us,Register & login on the PheonixAirways Website/Application");

		List<String> q8 = new ArrayList<String>();
		q8.add("You can check the status for any flight departing within 24 hours by clicking on the"
				+ "Flight Status link.");

		List<String> q9 = new ArrayList<String>();
		q9.add("You will not be able to use the online flight cancellation facility if:"
				+ "Your flight departure time is within the next 3 hours"
				+ "For all such cancellations, kindly call us."
				+ "Please note, if your flight departure time is within the next 3 hours, you will need to call the relevant airline to cancel your booking. Kindly click on Airline Contact Information for more details.");

		listDataChild.put(listDataHeader.get(0), q1); // Header, Child data
		listDataChild.put(listDataHeader.get(1), q2);
		listDataChild.put(listDataHeader.get(2), q3);
		listDataChild.put(listDataHeader.get(3), q4);
		listDataChild.put(listDataHeader.get(4), q5);
		listDataChild.put(listDataHeader.get(5), q6);
		listDataChild.put(listDataHeader.get(6), q7);
		listDataChild.put(listDataHeader.get(7), q8);
		listDataChild.put(listDataHeader.get(8), q9);
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