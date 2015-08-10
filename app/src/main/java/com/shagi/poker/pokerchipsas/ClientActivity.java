package com.shagi.poker.pokerchipsas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Shagi on 10.08.2015.
 */
public class ClientActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toGame(View view){
        Intent intent=new Intent(this,GameActivity.class);
        startActivity(intent);
    }
}

