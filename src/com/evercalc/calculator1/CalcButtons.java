package com.evercalc.calculator1;


public enum CalcButtons {
	MC("MC",CalcButtonsType.MEMORYBUFFER)
	, MR("MR",CalcButtonsType.MEMORYBUFFER)
	, MS("MS",CalcButtonsType.MEMORYBUFFER)
	, M_ADD("M+",CalcButtonsType.MEMORYBUFFER)
	, M_REMOVE("M-",CalcButtonsType.MEMORYBUFFER)
	, BACKSPACE("<-",CalcButtonsType.CLEAR)
	, CE("CE",CalcButtonsType.CLEAR)
	, C("C",CalcButtonsType.CLEAR)
	, ZERO("0",CalcButtonsType.NUMBER)
	, ONE("1",CalcButtonsType.NUMBER)
	, TWO("2",CalcButtonsType.NUMBER)
	, THREE("3",CalcButtonsType.NUMBER)
	, FOUR("4",CalcButtonsType.NUMBER)
	, FIVE("5",CalcButtonsType.NUMBER)
	, SIX("6",CalcButtonsType.NUMBER)
	, SEVEN("7",CalcButtonsType.NUMBER)
	, EIGHT("8",CalcButtonsType.NUMBER)
	, NINE("9",CalcButtonsType.NUMBER)
	, PLUS(" + ",CalcButtonsType.OPERATOR)
	, MINUS(" - ",CalcButtonsType.OPERATOR)
	, MULTIPLY(" * ",CalcButtonsType.OPERATOR)
	, DIV(" / ",CalcButtonsType.OPERATOR)
	, RECIPROC("1/x",CalcButtonsType.OTHER)
	, DECIMAL_SEP(",",CalcButtonsType.OTHER)
	, SIGN("±",CalcButtonsType.OTHER)
	, SQRT("SQRT",CalcButtonsType.OTHER)
	, PERCENT("%",CalcButtonsType.OTHER)
	, CALCULATE("=",CalcButtonsType.RESULT)
	, DUMMY("",CalcButtonsType.DUMMY);

	 CharSequence mText; // Display Text
	 CalcButtonsType mCategory;
		
	 CalcButtons(CharSequence text,CalcButtonsType category) {
	    mText = text;
	    mCategory = category;
	  }

	  public CharSequence getText() {
	    return mText;
	  }
}
