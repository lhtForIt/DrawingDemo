package com.lht.demo.drawingdemo;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by lht on 2017/5/23.
 */

public class AttributesTool {

    private int color;
    private int borderWidth;
    private boolean fill;
    private static AttributesTool self;
    private static Paint paint;

    /**
     * 定义为单例，防止多次创建浪费资源
     */
    private AttributesTool() {
        reset();
    }

    /**
     * 向外部提供对象
     * @return
     */
    public static AttributesTool getInstance() {
        if (self == null) {
            synchronized (AttributesTool.class) {
                if (null == self) {
                    self = new AttributesTool();
                }
            }
        }
        return self;
    }

    /**
     * 将当前绘图属性转换成Paint对象
     * @return
     */
    public Paint getPaint() {
        if (paint == null) {
            paint = new Paint();
        }
        paint.setAntiAlias(true);
        paint.setColor(this.color);
        paint.setStrokeWidth(borderWidth);
        paint.setStyle(this.fill ? Paint.Style.FILL : Paint.Style.STROKE);
        paint.setTextSize(30);
        return paint;
    }

    public void reset() {
        this.color = Color.BLACK;
        this.borderWidth = 1;
        this.fill = false;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }
}
