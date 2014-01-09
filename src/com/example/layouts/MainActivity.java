package com.example.layouts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ppjtest.R;

public class MainActivity extends Activity {

	private static final String TAG = "myLogs"; // tag for log

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(TAG, "onCreate");
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case R.id.itemSubShowLongToast:
			Toast.makeText(this, "Long Toast", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.itemShowShortToast:
			Toast.makeText(this, "Short Toast", Toast.LENGTH_SHORT).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	// another way of menu onClick listener ? which is better ?
	public void onLogOutClick(MenuItem item) {
		Log.d(TAG, "itemId :: " + item.getItemId());
	}

	public void LinearOnClick(View view) {
		Toast.makeText(this, "Please wait...", Toast.LENGTH_SHORT).show();
		Intent myIntent = new Intent(view.getContext(), LinearActivity.class);
		startActivity(myIntent);
		Log.d(TAG, "LinearOnClick");
	}

	public void TableOnClick(View view) {
		Intent myIntent = new Intent(view.getContext(), TableActivity.class);
		startActivity(myIntent);
		Log.d(TAG, "TableOnClick");
	}

	// ?? Is it OK to use 1 listener for few buttons ?
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

	// ?? or it's better to use separate listeners for each button?
	// public void RelativeOnClick(View view) {
	// Intent myIntent = new Intent(view.getContext(), RelativeActivity.class);
	// startActivity(myIntent);
	// }
	//
	// public void AbsoluteOnClick(View view) {
	// Intent myIntent = new Intent(view.getContext(), AbsoluteActivity.class);
	// startActivity(myIntent);
	// }

}
