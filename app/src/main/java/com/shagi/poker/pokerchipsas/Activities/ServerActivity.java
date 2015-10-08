package com.shagi.poker.pokerchipsas.Activities;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.shagi.poker.pokerchipsas.InetService.ClientService;
import com.shagi.poker.pokerchipsas.R;

public class ServerActivity extends Activity{
    public final String TAG="GoodWork";

    public static final String UUID="cdd723e0-605a-11e5-a837-0800200c9a66";

    private String[] memberCount = { "2", "3", "4", "5","6","7","8","9"};
    private String[] server_mode = {"solo", "bluetooth server", "wi-fi"};
    private Spinner members_spinner;
    private Spinner spinner;
    private int count;

    private ClientService clientService;
    private boolean mBound;

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className, IBinder binder) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            clientService = ((ClientService.MyBinder)binder).getService();
            Log.d(TAG,"Сервис получен в активити");
            clientService.startConnection("192.168.1.35", 8080);
            Log.d(TAG,"Сервис подключился");
            waiterForAll();//запускаю ожидание, надо придумать метод передачи ip
            mBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            Log.d(TAG,"Сервис отключился");
            mBound = false;
        }
    };
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
        bindService(new Intent(this, ClientService.class), mConnection, BIND_AUTO_CREATE);
    }

    public void waiterForAll(){
        final Activity activity=this;
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG,"Начинаю ожидание");

                while (!clientService.isAllConnected());

                Log.d(TAG,"Все игроки подключены, переходим на GameActivity");
                Intent intent=new Intent(activity,GameActivityDemo.class);
                Log.d("TEST", "opa");
                intent.putExtra("count", members_spinner.getSelectedItem().toString());
                Log.d("TEST", members_spinner.getSelectedItem().toString());
                startActivity(intent);
            }
        }).start();
    }

}
