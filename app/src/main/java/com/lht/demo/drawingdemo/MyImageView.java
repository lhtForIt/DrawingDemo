package com.lht.demo.drawingdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lht on 2017/5/25.
 */

public class MyImageView extends View{

    private ShapeDrawer shapeDrawer;//图形绘制器

    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //默认画线条
        shapeDrawer = new RectDrawer(this);
    }

    public void setShapeDrawer(ShapeDrawer shapeDrawer) {
        this.shapeDrawer = shapeDrawer;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        SystemParams.areaWidth = this.getMeasuredWidth();
        SystemParams.areaHeight = this.getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (SystemParams.isRedo) {
            //撤销
            canvas.drawBitmap(BitmapBuffer.getInstance().getBitmap(), 0, 0, null);
            SystemParams.isRedo = false;
        } else {
            shapeDrawer.draw(canvas);
        }
        //逻辑
        shapeDrawer.logic();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return shapeDrawer.onTouchEvent(event);
    }


}
