package com.lht.demo.drawingdemo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lht on 2017/5/23.
 */

public class RectDrawer extends ShapeDrawer{

    private float firstX;
    private float firstY;
    private float currentX;
    private float currentY;


    public RectDrawer(View view) {
        super(view);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawShape(canvas,firstX,firstY,currentX,currentY);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstX = x;
                firstY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                currentX = x;
                currentY = y;
                getView().invalidate();
                break;
            case MotionEvent.ACTION_UP:
                //将最终的矩形绘制在缓冲区
                Canvas canvas = BitmapBuffer.getInstance().getCanvas();
                drawShape(canvas, firstX, firstY, currentX, currentY);
                getView().invalidate();
                //保存到撤销站中
                BitmapBuffer.getInstance().pushBitmap();
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public void logic() {

    }

    /**
     * 画当前的形状
     */
    protected void drawShape(Canvas canvas, float firstX, float firstY, float currentX, float currentY) {
        Paint paint = AttributesTool.getInstance().getPaint();

        //判断手指方向
        if (firstX < currentX && firstY < currentY) {
            //右下
            canvas.drawRect(firstX, firstY, currentX, currentY, paint);
        } else if (firstX > currentX && firstY > currentY) {
            //左上
            canvas.drawRect(currentX, currentY, firstX, firstY, paint);
        } else if (firstX > currentX && firstY < currentY) {
            //左下
            canvas.drawRect(currentX, firstY, firstX, currentY, paint);
        } else if (firstX < currentX && firstY > currentY) {
            //右上
            canvas.drawRect(firstX, currentY, currentX, firstY, paint);
        }
    }

}
