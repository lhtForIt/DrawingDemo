package com.lht.demo.drawingdemo;

import android.graphics.Bitmap;

import java.util.Stack;

/**
 * Created by lht on 2017/5/23.
 */

public class BitmapHistory {

    private static Stack<Bitmap> stack;
    private static BitmapHistory self;

    private BitmapHistory() {
        if (stack == null) {
            stack = new Stack<Bitmap>();
        }
    }


    public static BitmapHistory getInstance() {
        if (self == null) {
            synchronized (BitmapHistory.class) {
                if (self == null) {
                    self = new BitmapHistory();
                }
            }
        }
        return self;
    }

    /**
     * 将当前的历史结果压栈
     * @param bitmap
     */
    public void pushBitmap(Bitmap bitmap) {
        int count = stack.size();
        if (count > 5) {
            Bitmap bmp = stack.remove(0);
            if (!bmp.isRecycled()) {
                bmp.recycle();
                System.gc();
                bmp = null;
            }
        }
        stack.push(bitmap);
    }


    /**
     * 撤销
     * @return
     */
    public Bitmap reDo() {
        Bitmap bmp = stack.pop();//将顶部元素删除
        //回收位图资源
        if (bmp != null && !bmp.isRecycled()) {
            bmp.recycle();
            System.gc();
            bmp = null;
        }
        if (stack.empty()) {
            return null;
        }

        //返回撤销后的位图对象
        return stack.peek();
    }


    /**
     * @return true表示能撤销，false表示不能撤销
     */
    public boolean isReDo() {
        return !stack.empty();
    }


















}
