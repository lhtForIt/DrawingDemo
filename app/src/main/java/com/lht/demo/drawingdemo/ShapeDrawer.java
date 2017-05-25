package com.lht.demo.drawingdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lht on 2017/5/23.
 */

public abstract class ShapeDrawer {

    private View view;

    public ShapeDrawer(View view) {
        super();
        this.view = view;
    }

    public View getView() {
        return view;
    }

    /**
     * 用于绘图
     * @param canvas
     *         用于展示结果的画布
     */
    public void draw(Canvas canvas) {
        //画历史结果
        Bitmap bitmap = BitmapBuffer.getInstance().getBitmap();
        canvas.drawBitmap(bitmap, 0, 0, null);
    }

    public abstract boolean onTouchEvent(MotionEvent event);

    public abstract void logic();










}
