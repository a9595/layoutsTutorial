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
	
	//?? Is it OK to use 1 listener for few buttons ? 
	public void RelativeAndAbsoluteOnClick(View view) {
		Intent myIntent = null;
		switch (view.getId()) {
		case R.id.btnRelative:
			myIntent = new Intent(view.getContext(), RelativeActivity.class);
			break;
		case R.id.btnAbsolute:
			myIntent = new Intent(view.getContext(), AbsoluteActivity.class);
			break;
		}

		if (myIntent != null)
			startActivity(myIntent);
	}

	//?? or it's better to use separate listeners for each button? 
//	public void RelativeOnClick(View view) {
//		Intent myIntent = new Intent(view.getContext(), RelativeActivity.class);
//		startActivity(myIntent);
//	}
//
//	public void AbsoluteOnClick(View view) {
//		Intent myIntent = new Intent(view.getContext(), AbsoluteActivity.class);
//		startActivity(myIntent);
//	}

	

}
