package com.shagi.poker.pokerchipsas.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shagi.poker.pokerchipsas.R;

/**
 * Created by Shagi on 10.08.2015.
 */
public class ClientActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_activity);
    }

    public void toGame(View view){
        Intent intent=new Intent(this,GameActivity.class);
        startActivity(intent);
    }
}

