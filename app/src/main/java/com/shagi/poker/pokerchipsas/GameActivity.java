package com.shagi.poker.pokerchipsas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GameActivity extends Activity{
    final String ATTRIBUTE_NAME_NAME="name";
    final String ATTRIBUTE_NAME_BALANCE="balance";
    final String ATTRIBUTE_NAME_MOVE="move";

    ListView lvSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        String[] names={"Name1","Player2","Test3"};
        String[] balance={"1000","2000","1500"};
        String[] move={"fold 1000","rise 150","call"};

        ArrayList<Map<String,Object>> data=new ArrayList<>(names.length);
        Map<String,Object> m;
        for (int i = 0; i < 9; i++) {
            m=new HashMap<>();
            m.put(ATTRIBUTE_NAME_NAME,names[i%3]);
            m.put(ATTRIBUTE_NAME_BALANCE,balance[i%3]);
            m.put(ATTRIBUTE_NAME_MOVE,move[i%3]);
            data.add(m);
        }

        String[] from={ATTRIBUTE_NAME_NAME,ATTRIBUTE_NAME_BALANCE,ATTRIBUTE_NAME_MOVE};
        int[] to={R.id.playerNameTxt,R.id.balance_txtv,R.id.move_txt};

        SimpleAdapter simpleAdapter=new SimpleAdapter(this, data,R.layout.player_item,from,to);

        lvSimple=(ListView) findViewById(R.id.lvSimple);
        lvSimple.setAdapter(simpleAdapter);

    }
}
