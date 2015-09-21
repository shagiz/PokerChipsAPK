package com.shagi.poker.pokerchipsas.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.shagi.poker.pokerchipsas.R;

public class ServerActivity extends Activity{

    public static final String UUID="cdd723e0-605a-11e5-a837-0800200c9a66";

    private String[] memberCount = { "2", "3", "4", "5","6","7","8","9"};
    private String[] server_mode = {"solo", "bluetooth server", "wi-fi"};
    private Spinner members_spinner;
    private Spinner spinner;
    private int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.server_activity);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, memberCount);

        members_spinner=(Spinner) findViewById(R.id.mebers_spinner);
        members_spinner.setAdapter(adapter);

        adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, server_mode);
        spinner=(Spinner) findViewById(R.id.server_mode);
        spinner.setAdapter(adapter);

    }

    public void toGame(View view){
        Intent intent=new Intent(this,GameActivityDemo.class);
        Log.d("TEST", "opa");
        intent.putExtra("count", members_spinner.getSelectedItem().toString());
        Log.d("TEST", members_spinner.getSelectedItem().toString());
        startActivity(intent);
    }

}
