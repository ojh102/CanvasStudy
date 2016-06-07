package com.ojh.www.canvasstudy;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {

    Paint mPaint;

    private final static int COUNT = 30;
    private final static float WIDTH = 300;
    float[] mPoints;

    public CustomView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint = new Paint();
        initLineAndPoint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
//        drawLineAndPoint(canvas);
//        drawRoundRect(canvas);
//        drawOval(canvas);
        drawPath(canvas);

    }

    private void initLineAndPoint() {
        int linecount = COUNT+1;
        mPoints = new float[linecount * 2 * 2];
        float delta = WIDTH / COUNT;
        int index = 0;
        for(int i = 0; i <= COUNT; i++) {
            mPoints[index++] = 0;
            mPoints[index++] = i * delta;
            mPoints[index++] = WIDTH - i *delta;
            mPoints[index++] = 0;
        }
    }

    private void drawLineAndPoint(Canvas canvas) {
        canvas.save();

        canvas.translate(100, 100);

        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(2);
        canvas.drawLines(mPoints, mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
        canvas.drawPoints(mPoints, mPaint);

        canvas.restore();
    }

    private void drawRect(Canvas canvas) {
        mPaint.setColor(Color.BLUE);

        Rect rect = new Rect(100, 100, 300, 300);
        canvas.drawRect(rect, mPaint);
    }

    private void drawRoundRect(Canvas canvas) {
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        int rx = 30, ry = 15;

        RectF rect = new RectF(100, 100, 300, 300);
        canvas.drawRoundRect(rect, rx, ry, mPaint);
    }

    private void drawCircle(Canvas canvas) {
        mPaint.setColor(Color.BLUE);
        mPaint.setAntiAlias(true);
        canvas.drawCircle(200, 200, 100, mPaint);
    }

    private void drawOval(Canvas canvas) {
        mPaint.setColor(Color.BLUE);
        RectF rect = new RectF(100, 100, 400, 300);
        canvas.drawOval(rect, mPaint);
    }

    private void drawArc(Canvas canvas) {
        mPaint.setColor(Color.BLUE);
        RectF rect = new RectF(100, 100, 400, 300);
        canvas.drawArc(rect, 45, 90, true, mPaint);
    }

    Path mPath;

    private void initPath() {
        mPath = new Path();
        mPath.moveTo(100, 100);;
        mPath.lineTo(50, 50);
        mPath.lineTo(150, 50);
        mPath.lineTo(200, 100);
        mPath.lineTo(150, 150);
        mPath.lineTo(50, 150);
    }

    private void drawPath(Canvas canvas) {
        initPath();
        mPaint.setColor(Color.BLUE);
        canvas.drawPath(mPath, mPaint);
    }
}
