package com.softtanck.xfermodestudy.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.softtanck.xfermodestudy.R;

/**
 * @author : Tanck
 * @Description : TODO
 * @date 9/16/2015
 */
public class MyView extends ImageView {
    private Bitmap mBitmap;
    private Bitmap mOut;
    private Paint mPaint;
    private int width;
    private int height;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @SuppressLint("NewApi")
    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.test);
        mOut = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
    }

    private Bitmap getInBitmap(Bitmap mOut) {
        Canvas canvas = new Canvas(mOut);
        Rect rect = new Rect(0, 0, width, height);
        canvas.drawRect(rect, mPaint);
//        canvas.drawCircle(width / 2, height / 2, 50, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        return mOut;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        width = getWidth();
        height = getHeight();
    }

    @SuppressLint("NewApi")
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(getInBitmap(mOut), 0, 0, null);
    }
}
