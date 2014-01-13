package com.example.layouts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ppjtest.R;

public class LinearActivity extends Activity implements
		SeekBar.OnSeekBarChangeListener {

	SeekBar sbWeight;
	Button btnLeft, btnRight;
	TextView tvAction;

	LinearLayout.LayoutParams lParamsBtnLeft;
	LinearLayout.LayoutParams lParamsBtnRight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear);

		tvAction = (TextView) findViewById(R.id.tvAction);
		sbWeight = (SeekBar) findViewById(R.id.sbWeight);
		sbWeight.setOnSeekBarChangeListener(this);

		btnLeft = (Button) findViewById(R.id.btnLeftWeight);
		btnRight = (Button) findViewById(R.id.btnRightWeight);

		lParamsBtnLeft = (LinearLayout.LayoutParams) btnLeft.getLayoutParams();
		lParamsBtnRight = (LinearLayout.LayoutParams) btnRight
				.getLayoutParams();

		//get & set Action from intent
		Intent intent = getIntent();
		String action = intent.getAction();

		String format = "intent Action = " + action;
		tvAction.setText(format);

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