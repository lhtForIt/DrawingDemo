package com.lht.demo.drawingdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by lht on 2017/5/23.
 */

public class BitmapBuffer {
    private Bitmap bitmap;
    private Canvas canvas;
    private static BitmapBuffer self;

    public BitmapBuffer(int width,int height) {
        init(width,height);
    }

    private void init(int width, int height) {
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas();
        canvas.setBitmap(bitmap);
    }


    public static BitmapBuffer getInstance() {
        if (null == self) {
            synchronized (BitmapBuffer.class) {
                if (null == self) {
                    self = new BitmapBuffer(SystemParams.areaWidth,SystemParams.areaHeight);
                }
            }
        }
        return self;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void pushBitmap() {
        BitmapHistory.getInstance().pushBitmap(bitmap.copy(Bitmap.Config.ARGB_8888, false));
    }

    public void redo() {
        BitmapHistory his = BitmapHistory.getInstance();
        if (his.isReDo()) {
            Bitmap bmp = his.reDo();
            if (bmp != null) {
                bitmap = bmp.copy(Bitmap.Config.ARGB_8888, true);
                //必须重新关联画布
                canvas.setBitmap(bitmap);
                //回收
                if (bmp != null && !bmp.isRecycled()) {
                    bmp.recycle();
                    System.gc();
                    bmp = null;
                }
            }
        }
    }
}
