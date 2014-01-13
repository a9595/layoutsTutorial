package com.example.layouts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ppjtest.R;

public class LinearActivity extends Activity implements
		SeekBar.OnSeekBarChangeListener {

	SeekBar sbWeight;
	Button btnLeft, btnRight, btnSubmit;
	TextView tvAction;
	EditText etName;

	LinearLayout.LayoutParams lParamsBtnLeft;
	LinearLayout.LayoutParams lParamsBtnRight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear);

		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		etName = (EditText) findViewById(R.id.etName);
		tvAction = (TextView) findViewById(R.id.tvAction);
		sbWeight = (SeekBar) findViewById(R.id.sbWeight);
		sbWeight.setOnSeekBarChangeListener(this);

		btnLeft = (Button) findViewById(R.id.btnLeftWeight);
		btnRight = (Button) findViewById(R.id.btnRightWeight);

		lParamsBtnLeft = (LinearLayout.LayoutParams) btnLeft.getLayoutParams();
		lParamsBtnRight = (LinearLayout.LayoutParams) btnRight
				.getLayoutParams();

		// get & set Action from intent
		Intent intent = getIntent();
		String action = intent.getAction();
		String extra = intent.getStringExtra("Extra");
		String format = "intent Action = " + action + "\n extra = " + extra;
		tvAction.setText(format);
		
		etName.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence s, int start,
					int before, int count) {
				if(etName.getText().length()>0)
					btnSubmit.setEnabled(true);
				else 
					btnSubmit.setEnabled(false);
			}

			@Override
			public void afterTextChanged(Editable arg0) {

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}
		});

	}

	public void SubmitOnClick(View view) {
		if (etName.getText().length() <= 0) {
			Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show();
			
			return;
		}

		Intent returnIntent = new Intent();
		returnIntent.putExtra("result", etName.getText().toString());
		setResult(RESULT_OK, returnIntent);
		finish();
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		int leftValue = progress;
		int rightValue = sbWeight.getMax() - progress;
		// set weight
		lParamsBtnLeft.weight = leftValue;
		lParamsBtnRight.weight = rightValue;
		// set text of btns to values
		btnLeft.setText(String.valueOf(leftValue));
		btnRight.setText(String.valueOf(rightValue));

	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
	}

}