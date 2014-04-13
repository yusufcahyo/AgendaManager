package com.ppl.am;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class Splash extends Activity {
	CalendarView cv;
	// EditText et;

	LinearLayout layoutOfPopup;
	PopupWindow popupMessage;
	Button show, eventButton, taskButton;

	public void init() {
		show = new Button(this);
		eventButton = new Button(this);
		taskButton = new Button(this);
		layoutOfPopup = new LinearLayout(this);
		layoutOfPopup.setBackgroundColor(0xFFFFFF);

		show.setText("show agenda this day");
		eventButton.setText("add event");
		taskButton.setText("add task");

		layoutOfPopup.setOrientation(1);
		layoutOfPopup.addView(show);
		layoutOfPopup.addView(eventButton);
		layoutOfPopup.addView(taskButton);
	}

	public void popupInit() {
		
		eventButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent myIntent = new Intent(v.getContext(), FormEvent.class);
				v.getContext().startActivity(myIntent);
				popupMessage.dismiss();
			}
		});
		taskButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent myIntent = new Intent(v.getContext(), FormTask.class);
				v.getContext().startActivity(myIntent);
				popupMessage.dismiss();

			}
		});
		popupMessage = new PopupWindow(layoutOfPopup, LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT);
		popupMessage.setContentView(layoutOfPopup);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		init();
		popupInit();
		RelativeLayout rl = (RelativeLayout) findViewById(R.id.relativeLayout1);
		rl.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				popupMessage.dismiss();

			}
		});
		cv = (CalendarView) findViewById(R.id.calendarView1);
		// et = (EditText) findViewById(R.id.editText1);
		// cv.setOnLongClickListener(longClick());
		cv.setOnDateChangeListener(cvListener());

	}

	// private OnLongClickListener longClick() {
	// // TODO Auto-generated method stub
	// return new OnLongClickListener() {
	// String[] bulan
	// ={"January","February","March","April","May","June","July","August","September","October","November","December"};
	// @Override
	// public boolean onLongClick(View v) {
	// // TODO Auto-generated method stub
	// return false;
	// }
	// };
	// }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		menu.getItem(0).setEnabled(false);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		finish();
		return new ActionBar().actionBarHandler(item, this);
	}
	private void gotoHarian(){
		Intent myIntent = new Intent(this, Harian.class);
		this.startActivity(myIntent);
	}
	private OnDateChangeListener cvListener() {
		return new OnDateChangeListener() {
			String[] bulan = { "January", "February", "March", "April", "May",
					"June", "July", "August", "September", "October",
					"November", "December" };

			@Override
			public void onSelectedDayChange(CalendarView view, int year,
					int month, int dayOfMonth) {
				
//				show.setText("show agenda on " + dayOfMonth + " "
//						+ bulan[month] + " " + year);
				gotoHarian();
//				popupMessage.showAsDropDown(cv, 0, 100);
				// et.setText("tanggal:" + dayOfMonth);

			}
		};
	}

}
