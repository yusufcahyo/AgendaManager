package com.ppl.am;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.Button;

public class FormKontak extends Activity {

	private Button save;
	private Button cancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form_kontak);
		save = (Button) findViewById(R.id.save);
		cancel = (Button) findViewById(R.id.cancel);
		save.setBackgroundColor(Color.GREEN);
		save.setTextColor(Color.WHITE);
		cancel.setBackgroundColor(Color.RED);
		cancel.setTextColor(Color.WHITE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.form_kontak, menu);
		return true;
	}

}
