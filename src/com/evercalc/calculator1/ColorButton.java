package com.evercalc.calculator1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

class ColorButton extends Button
  implements View.OnClickListener
{
  int CLICK_FEEDBACK_COLOR;
  long mAnimStart;
  Paint mFeedbackPaint;
  View.OnClickListener mListener;
  float mTextX;
  float mTextY;

  public ColorButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    CalcNote localCalculator = (CalcNote)paramContext;
    init(localCalculator);
    setOnClickListener(this);
  }

  private void drawMagicFlame(int paramInt, Canvas paramCanvas)
  {
    int i = 255 - paramInt * 255 / 350;
    int j = this.CLICK_FEEDBACK_COLOR | i << 24;
    this.mFeedbackPaint.setColor(j);
    paramCanvas.drawRect(1.0F, 1.0F, -1 + getWidth(), -1 + getHeight(), this.mFeedbackPaint);
  }

  private void init(CalcNote paramCalculator)
  {
    Resources localResources = getResources();
    this.CLICK_FEEDBACK_COLOR = localResources.getColor(2131099648);
    this.mFeedbackPaint = new Paint();
    this.mFeedbackPaint.setStyle(Paint.Style.STROKE);
    this.mFeedbackPaint.setStrokeWidth(2.0F);
    getPaint().setColor(localResources.getColor(2131099649));
    this.mAnimStart = -1L;
  }

  private void measureText()
  {
    TextPaint localTextPaint = getPaint();
    this.mTextX = ((getWidth() - localTextPaint.measureText(getText().toString())) / 2.0F);
    this.mTextY = ((getHeight() - localTextPaint.ascent() - localTextPaint.descent()) / 2.0F);
  }

  public void animateClickFeedback()
  {
    this.mAnimStart = System.currentTimeMillis();
    invalidate();
  }

  public void onClick(View paramView)
  {
    this.mListener.onClick(this);
  }

  public void onDraw(Canvas paramCanvas)
  {
    int i;
    if (this.mAnimStart != -1L)
    {
      i = (int)(System.currentTimeMillis() - this.mAnimStart);
      if (i >= 350)
        this.mAnimStart = -1L;
    }
//    while (true)
//    {
//      CharSequence localCharSequence = getText();
//      paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), this.mTextX, this.mTextY, getPaint());
//      return;
//      drawMagicFlame(i, paramCanvas);
//      postInvalidateDelayed(10L);
//      continue;
//      if (isPressed())
//        drawMagicFlame(0, paramCanvas);
//    }
  }

  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    measureText();
  }

  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    measureText();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
      return bool;
    case 1:
      if (isPressed())
      {
        animateClickFeedback();
        return bool;
      }
      invalidate();
      return bool;
    case 0:
    case 3:
    }
    this.mAnimStart = -1L;
    invalidate();
    return bool;
  }
}

/* Location:           D:\soft\programming\android_decompiler\dex2jar-0.0.9.15\Calculator-dex2jar.jar
 * Qualified Name:     com.android.calculator2.ColorButton
 * JD-Core Version:    0.6.2
 */