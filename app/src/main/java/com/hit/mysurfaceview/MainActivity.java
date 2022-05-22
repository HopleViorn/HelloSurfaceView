package com.hit.mysurfaceview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    private MySurfaceView mySurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySurfaceView = new MySurfaceView(this);
        getScreenHW();
        setContentView(mySurfaceView);
    }

    public void getScreenHW() {
        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mySurfaceView.screenWidth=displayMetrics.widthPixels;
        mySurfaceView.screenHeight=displayMetrics.heightPixels;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            mySurfaceView.x = event.getX();
            mySurfaceView.y = event.getY();
        }
        return  true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            this.finish();
        }
        return true;
    }
}