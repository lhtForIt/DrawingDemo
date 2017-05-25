package com.lht.demo.drawingdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private MyImageView draw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        draw = (MyImageView) findViewById(R.id.iv);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        ShapeDrawer shapeDrawer = null;
        AttributesTool at = AttributesTool.getInstance();

        switch (item.getItemId()) {

        }

        return true;

    }
}
