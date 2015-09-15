package com.shagi.poker.pokerchipsas;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class GameActivityDemo extends Activity implements View.OnTouchListener {
    ImageView img;
    float x;
    float y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.game_activity_demo);
        img=(ImageView) findViewById(R.id.imageView);
        img.setOnTouchListener(this);

    }

    public void logger(View view){
        Log.d("TEST","Button "+view);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                if (y > 0.98 * x +75) {
                    Log.d("TEST", x+" __FOLD__ "+y);
                    img.setImageResource(R.drawable.fold_all);
                } else
                if(y > -0.98 * (x-1200)){
                    Log.d("TEST", x+" __CHECK__ "+y);
                    img.setImageResource(R.drawable.check_all);
                } else if(y>300){
                    Log.d("TEST", x+" __RISE\\CALL__ "+y);
                    img.setImageResource(R.drawable.rise_call_all);
                } else {
                    Log.d("TEST", x+" __NOTHING__ "+y);
                }
                break;
            case MotionEvent.ACTION_MOVE: // движение
                break;
            case MotionEvent.ACTION_UP: // отпускание
                /*
                if(y>300) {
                    Log.d("TEST"," __Changed to Call__ ");
                    img.setBackgroundResource(R.drawable.call_np_all);
                }else {
                    img.setBackgroundResource(R.drawable.all);
                }
                */
            case MotionEvent.ACTION_CANCEL:
                img.setImageResource(R.drawable.all);
                break;
        }


        return true;
    }
}
