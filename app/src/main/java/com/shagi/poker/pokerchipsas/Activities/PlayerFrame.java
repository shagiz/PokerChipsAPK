package com.shagi.poker.pokerchipsas.Activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shagi.poker.pokerchipsas.R;

/**
 * Created by Shagi on 18.09.2015.
 */
public class PlayerFrame extends RelativeLayout {
    private Player parentPlayer;
    private TextView player_name;
    private TextView player_move;
    private TextView player_bank;
    private String programName = "";

    public PlayerFrame(Context context) {
        super(context);
        initComponent();
    }

    private void initComponent() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.player_layout, this);
        player_name = (TextView) findViewById(R.id.player_name);
        player_move = (TextView) findViewById(R.id.player_move);
        player_bank = (TextView) findViewById(R.id.player_bank);
        updateFields();
    }

    private void updateFields() {
    }



    public void setPlayerName(String name) {
        programName = name;
        player_name.setText(programName);
    }

    public void setPlayerMove(String name) {
        player_move.setText(name);
    }

    public void setPlayerBank(String name) {
        player_bank.setText(name);
    }


    public Player getParentPlayer() {
        return parentPlayer;
    }

    public void setParentPlayer(Player parentPlayer) {
        this.parentPlayer = parentPlayer;
        updateFieldsByParent();
    }

    private void updateFieldsByParent() {
        setPlayerName(parentPlayer.getName());
        setPlayerMove(parentPlayer.getMove());
        setPlayerBank("" + parentPlayer.getBank());
    }

    //Пригодится для дизайна
    /*
    public void setChannelLogo(int resourceId) {
    }

    public void setChannelLogo(Bitmap image) {
    }
    */
}
