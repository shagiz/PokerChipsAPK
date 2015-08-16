package com.shagi.poker.pokerchipsas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ServerActivity extends Activity{
    String[] memberCount = { "2", "3", "4", "5","6","7","8","9"};
    String[] server_mode = {"solo", "bluetooth server", "wi-fi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.server_activity);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, memberCount);

        Spinner spinner=(Spinner) findViewById(R.id.mebers_spinner);
        spinner.setAdapter(adapter);

        adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, server_mode);
        spinner=(Spinner) findViewById(R.id.server_mode);
        spinner.setAdapter(adapter);

    }

    public void toGame(View view){
        Intent intent=new Intent(this,GameActivity.class);
        startActivity(intent);
    }

}
