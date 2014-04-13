package com.ppl.am;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ActionBar {
	public boolean actionBarHandler(MenuItem item, Context c) {
		View v = new View(c);
		Intent myIntent;
		switch (item.getItemId()) {
		// action with ID action_refresh was selected
		case R.id.action_bulanan:
			myIntent = new Intent(v.getContext(), Splash.class);
			v.getContext().startActivity(myIntent);
			break;
		// action with ID action_settings was selected
		case R.id.action_list_task:
			Toast.makeText(c, "List Task selected", Toast.LENGTH_SHORT)
					.show();
			break;
		case R.id.action_kontak:
			myIntent = new Intent(v.getContext(), Kontak.class);
			v.getContext().startActivity(myIntent);
			break;
		default:
			break;
		}

		return true;

	}
}
