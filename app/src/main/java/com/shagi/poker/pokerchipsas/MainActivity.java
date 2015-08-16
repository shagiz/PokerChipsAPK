package com.shagi.poker.pokerchipsas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


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
}
