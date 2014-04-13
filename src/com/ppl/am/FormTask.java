package com.ppl.am;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.Button;
import android.widget.NumberPicker;

public class FormTask extends Activity {

	private Button save;
	private Button cancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form_task);
		save = (Button) findViewById(R.id.save);
		cancel = (Button) findViewById(R.id.cancel);
		save.setBackgroundColor(Color.GREEN);
		save.setTextColor(Color.WHITE);
		cancel.setBackgroundColor(Color.RED);
		cancel.setTextColor(Color.WHITE);
		NumberPicker np = (NumberPicker) findViewById(R.id.estiamte);
		String[] nums = new String[20];
		for (int i = 0; i < nums.length; i++) {
			if (i == 0)
				nums[i] = "0";
			else if (i % 4 != 0)
				nums[i] = i * 15 + " menit";
			else
				nums[i] = i / 4 + " jam";
		}
		np.setMinValue(1);
		np.setMaxValue(20);
		np.setWrapSelectorWheel(false);
		np.setDisplayedValues(nums);
		np.setValue(1);
		NumberPicker np2 = (NumberPicker) findViewById(R.id.priority);
		np2.setMinValue(0);
		np2.setMaxValue(2);
		np2.setWrapSelectorWheel(true);
		np2.setDisplayedValues(new String[]{"Penting","Normal","Kurang"});
		np2.setValue(0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.form_task, menu);
		return true;
	}

}
