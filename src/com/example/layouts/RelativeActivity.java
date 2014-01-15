package com.example.layouts;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ppjtest.R;

public class RelativeActivity extends Activity {

	ListView lvColors;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.relative);

		
		createListView();
	}

	void createListView() {
		String[] myColors = { "Red", "Green", "Blue" };

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.relative, myColors);
		
		lvColors = (ListView) findViewById(R.id.listViewColors);
		lvColors.setAdapter(adapter);

	}

}