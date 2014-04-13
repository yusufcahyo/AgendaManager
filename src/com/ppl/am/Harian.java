package com.ppl.am;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Harian extends Activity {

	private ListView listView;
	private ListView listView2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_harian);
		listView = (ListView) findViewById(R.id.jam);
		listView2 = (ListView) findViewById(R.id.nama);
		// Defined Array values to show in ListView
		String[] listJam = new String[]{"00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30","04:00","04:30","05:00","05:30","06:00","06:30",
				"07:00","07:30","08:00","08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30",
				"14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30","20:00","20:30",
				"21:00","21:30","22:00","22:30","23:00","23:30"};
//		for(int i =0;i<listJam.length;i++){
////			listJam[i] = i/2+":"+(i%2*30);
//			listJam[i] = "lala"+i;
//		}

		// Define a new Adapter
		// First parameter - Context
		// Second parameter - Layout for the row
		// Third parameter - ID of the TextView to which the data is written
		// Forth - the Array of data

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, listJam);

		// Assign adapter to ListView
		listView.setAdapter(adapter);

		// ListView Item Click Listener
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				// ListView Clicked item index
				int itemPosition = position;

				// ListView Clicked item value
				String itemValue = (String) listView
						.getItemAtPosition(position);

				// Show Alert
				Toast.makeText(
						getApplicationContext(),
						"Position :" + itemPosition + "  ListItem : "
								+ itemValue, Toast.LENGTH_LONG).show();

			}

		});
//		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
//				android.R.layout.simple_list_item_1, android.R.id.text1, listJam);

		// Assign adapter to ListView
//		listView2.setAdapter(adapter2);
//
//		// ListView Item Click Listener
//		listView2.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//
//				// ListView Clicked item index
//				int itemPosition = position;
//
//				// ListView Clicked item value
//				String itemValue = (String) listView
//						.getItemAtPosition(position);
//
//				// Show Alert
//				Toast.makeText(
//						getApplicationContext(),
//						"Position :" + itemPosition + "  ListItem : "
//								+ itemValue, Toast.LENGTH_LONG).show();
//
//			}
//
//		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.harian, menu);
		return true;
	}

}
