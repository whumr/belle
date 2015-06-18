package com.belle.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class TestView extends View {

	Paint paint;
	Rect rect;
	Canvas canvas;
	
	public TestView(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint = new Paint();
		rect = new Rect(100, 100, 200, 200);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		this.canvas = canvas;
		paint.setColor(Color.BLUE);
		paint.setStrokeWidth(10);
		paint.setAlpha(10);
		canvas.drawRect(rect, paint);
	}
	
	public void setRect(Rect rect) {
		this.rect = rect;
		this.invalidate();
	}

}
