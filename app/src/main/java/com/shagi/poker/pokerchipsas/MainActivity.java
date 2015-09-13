package com.shagi.poker.pokerchipsas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toServerActivity(View view){
        intent=new Intent(this,ServerActivity.class);
        startActivity(intent);
    }

    public void toClientActivity(View view){
        intent=new Intent(this,ClientActivity.class);
        startActivity(intent);
    }

    public void log4btn(View view){
        Log.d("TEST","ТУТ КНОПКА");
    }
}
