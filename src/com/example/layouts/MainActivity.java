package com.example.layouts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ppjtest.R;

public class MainActivity extends Activity {

	final int MENU_COLOR_RED = 1;
	final int MENU_COLOR_GREEN = 2;
	final int MENU_COLOR_BLUE = 3;
	private static final String TAG = "myLogs"; // tag for log
	TextView tvContextMenu, tvIntentResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.d(TAG, "onCreate");
		tvContextMenu = (TextView) findViewById(R.id.tvContextMenu);
		tvIntentResult = (TextView) findViewById(R.id.tvIntentResult);
		registerForContextMenu(tvContextMenu); // set context menu for btnLinear
	}

	// OnCLick listeners
	public void LinearOnClick(View view) {
		Toast.makeText(this, "Please wait...", Toast.LENGTH_SHORT).show();
		Intent myIntent = new Intent("com.layoutTutorial.showLinear");
		myIntent.putExtra("Extra", "my Extra");
		startActivityForResult(myIntent, 1);
		Log.d(TAG, "LinearOnClick");
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == 1) {

			if (resultCode == RESULT_OK) {
				String result = data.getStringExtra("result");
				tvIntentResult.setText(result);
			}
			if (resultCode == RESULT_CANCELED) {				
				tvIntentResult.setText("You have no result :( ");
			}
		}
	}// onActivityResult

	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_COLOR_RED:
			tvContextMenu.setTextColor(Color.RED);
			tvContextMenu.setText("Text color = red");
			break;
		case MENU_COLOR_GREEN:
			tvContextMenu.setTextColor(Color.GREEN);
			tvContextMenu.setText("Text color = green");
			break;
		case MENU_COLOR_BLUE:
			tvContextMenu.setTextColor(Color.BLUE);
			tvContextMenu.setText("Text color = blue");
			break;
		case R.id.itemSubShowLongToast:
			// ?? how can I avoid the code duplication ??
			Toast.makeText(this, "Long Toast", Toast.LENGTH_SHORT).show();
		case R.id.itemShowShortToast:
			Toast.makeText(this, "Short Toast", Toast.LENGTH_SHORT).show();
		}
		return super.onContextItemSelected(item);
	}

	// context menu
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		switch (v.getId()) {
		case R.id.tvContextMenu:
			menu.add(0, MENU_COLOR_RED, 0, "Red");
			menu.add(0, MENU_COLOR_GREEN, 0, "Green");
			menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
			getMenuInflater().inflate(R.menu.main, menu); // + add XML menu
			break;
		}
	}

	// menu
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

	public void TableOnClick(View view) {
		Intent myIntent = new Intent(view.getContext(), TableActivity.class);
		startActivity(myIntent);
		Log.d(TAG, "TableOnClick");
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
