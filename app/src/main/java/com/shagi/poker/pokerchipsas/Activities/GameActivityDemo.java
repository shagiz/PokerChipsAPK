package com.shagi.poker.pokerchipsas.Activities;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.shagi.poker.pokerchipsas.InetService.ClientService;
import com.shagi.poker.pokerchipsas.R;

import java.util.ArrayList;


public class GameActivityDemo extends Activity implements View.OnTouchListener {
    public final String TAG="GoodWork";

    private ImageView img;
    private ArrayList<PlayerFrame> frameArrayList;

    private ClientService clientService;
    private boolean mBound;

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className, IBinder binder) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            clientService = ((ClientService.MyBinder)binder).getService();
            Log.d(TAG,"Сервис получен в активити Game");

            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity_demo);

        preSettings();
        bindService(new Intent(this,ClientService.class),mConnection,BIND_AUTO_CREATE);
        loadPlayers();

        img=(ImageView) findViewById(R.id.imageView);
        img.setOnTouchListener(this);

    }



    public void loadPlayers(){
        LinearLayout framesContainer = (LinearLayout) findViewById(R.id.frames_container);
        frameArrayList=new ArrayList<>();
        for (int i = 1; i <=Integer.parseInt(getIntent().getStringExtra("count")); i++) {
            PlayerFrame frame = new PlayerFrame(getApplicationContext());
            Log.d("TEST","FRAME + "+i);
            frameArrayList.add(frame);
            frame.setPlayerName("NAME "+i);
            frame.setPlayerMove("MOVE "+i);
            frame.setPlayerBank("BANK "+i);
            framesContainer.addView(frame);
        }

    }
    public void preSettings(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                if (y > 0.98 * x +75) {
                    Log.d("TEST", x +" __FOLD__ "+ y);
                    img.setImageResource(R.drawable.fold_all);
                    clientService.test(frameArrayList);
                } else
                if(y > -0.98 * (x -1200)){
                    Log.d("TEST", x +" __CHECK__ "+ y);
                    img.setImageResource(R.drawable.check_all);
                    clientService.test2(frameArrayList);
                } else if(y >300){
                    Log.d("TEST", x +" __RISE\\CALL__ "+ y);
                    img.setImageResource(R.drawable.rise_call_all);
                } else {
                    Log.d("TEST", x +" __NOTHING__ "+ y);
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
