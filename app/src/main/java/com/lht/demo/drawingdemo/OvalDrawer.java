package com.lht.demo.drawingdemo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by lht on 2017/5/25.
 */

public class OvalDrawer extends RectDrawer{


    public OvalDrawer(View view) {
        super(view);
    }

    @Override
    protected void drawShape(Canvas canvas, float firstX, float firstY, float currentX, float currentY) {
        Paint paint = AttributesTool.getInstance().getPaint();
        if (firstX < currentX && firstY < currentY) {
            //右下
            canvas.drawOval(new RectF(firstX, firstY, currentX, currentY), paint);
        } else if (firstX > currentX && firstY < currentY) {
            //左下
            canvas.drawOval(new RectF(currentX,firstY,firstX,currentY),paint);
        } else if (firstX > currentX && firstY > currentY) {
            //左上
            canvas.drawOval(new RectF(currentX, currentY, firstX, firstY), paint);
        } else if (firstX < currentX && firstY > currentY) {
            //右上
            canvas.drawOval(new RectF(firstX, currentY, currentY, firstY), paint);
        }
    }
}
