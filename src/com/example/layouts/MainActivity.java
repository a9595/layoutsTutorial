package com.example.layouts;

import com.example.ppjtest.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void LinearOnClick(View view) {
		Intent myIntent = new Intent(view.getContext(), LinearActivity.class);
		startActivity(myIntent);
	}

	public void TableOnClick(View view) {
		Intent myIntent = new Intent(view.getContext(), TableActivity.class);
		startActivity(myIntent);
	}
	
	public void RelativeOnClick(View view) {
		Intent myIntent = new Intent(view.getContext(), RelativeActivity.class);
		startActivity(myIntent);
	}
	

}
