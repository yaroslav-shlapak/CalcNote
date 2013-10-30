package com.evercalc.calculator1;

import com.calc.ever.main.R;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class CalcButtonsAdapter extends BaseAdapter {
	private Context mContext;

	// Declare button click listener variable
	private OnClickListener mOnButtonClick;

	public CalcButtonsAdapter(Context c) {
		mContext = c;
	}

	// Method to set button click listener variable
	public void setOnButtonClickListener(OnClickListener listener) {
		mOnButtonClick = listener;
	}

	public int getCount() {
		return mButtons.length;
	}

	public Object getItem(int position) {
		return mButtons[position];
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ButtonView for each item referenced by the Adapter
	// create a new ButtonView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		Button btn;
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes

			btn = new Button(mContext);
			CalcButtons keypadButton = mButtons[position];

			if (keypadButton != CalcButtons.DUMMY)
				btn.setOnClickListener(mOnButtonClick);

			// Set CalculatorButton enumeration as tag of the button so that we
			// will use this information from our main view to identify what to
			// do
			btn.setTag(keypadButton);
		} else {
			btn = (Button) convertView;
		}

		btn.setText(mButtons[position].getText());
		return btn;
	}

	// Create and populate keypad buttons array with CalculatorButton values
	private CalcButtons[] mButtons = { CalcButtons.MC, CalcButtons.MR,
			CalcButtons.MS, CalcButtons.M_ADD, CalcButtons.M_REMOVE,
			CalcButtons.BACKSPACE, CalcButtons.CE, CalcButtons.C,
			CalcButtons.SIGN, CalcButtons.SQRT, CalcButtons.SEVEN,
			CalcButtons.EIGHT, CalcButtons.NINE, CalcButtons.DIV,
			CalcButtons.PERCENT, CalcButtons.FOUR, CalcButtons.FIVE,
			CalcButtons.SIX, CalcButtons.MULTIPLY, CalcButtons.RECIPROC,
			CalcButtons.ONE, CalcButtons.TWO, CalcButtons.THREE,
			CalcButtons.MINUS, CalcButtons.DECIMAL_SEP, CalcButtons.DUMMY,
			CalcButtons.ZERO, CalcButtons.DUMMY, CalcButtons.PLUS,
			CalcButtons.CALCULATE };
}
