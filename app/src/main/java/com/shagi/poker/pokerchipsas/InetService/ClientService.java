package com.shagi.poker.pokerchipsas.InetService;

/**
 * Created by Shagi on 07.10.2015.
 */

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.shagi.poker.pokerchipsas.Activities.Player;
import com.shagi.poker.pokerchipsas.Activities.PlayerFrame;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


public class ClientService extends Service {

    private MyBinder binder = new MyBinder();
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private boolean allConnected=false;

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


    public void startConnection(final String addr,final int port){
        Log.d("GoodWork", "1");

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("GoodWork", "2");
                try {
                    socket=new Socket("192.168.1.35",8080);
                    Log.d("GoodWork", "3");
                    out=new ObjectOutputStream(socket.getOutputStream());
                    in=new ObjectInputStream(socket.getInputStream());
                    Log.d("GoodWork", "Сокеты подключены");
                    waitForAll();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private void waitForAll() throws IOException{
                try {
                    in.readObject();
                    allConnected=true;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public boolean isAllConnected() {
        return allConnected;
    }

    public void test(ArrayList list){
        PlayerFrame frame=(PlayerFrame) list.get(1);
        frame.setPlayerMove("FOLD");
        frame.setPlayerName("OMOMOMOMO");
        frame.setPlayerBank("34242");
    }

    public void test2(ArrayList list){
        PlayerFrame frame=(PlayerFrame) list.get(1);
        frame.setPlayerMove("CHECK");
        frame.setPlayerName("ROBIT");
        frame.setPlayerBank("1256987");
    }

    public class MyBinder extends Binder {
        public ClientService getService(){
            return ClientService.this;
        }
    }

}
