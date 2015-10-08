package com.shagi.poker.pokerchipsas.BluetoothServer;

import java.io.Serializable;

/**
 * Created by Shagi on 20.09.2015.
 */
public class Move implements Serializable {
    public String move;
    public boolean isLost;
    public int currentChips;
    public int bet;

    Move(String move, int currentChips,int bet, boolean isLost){
        this.move=move;
        this.currentChips=currentChips;
        this.isLost=isLost;
        this.bet=bet;
    }
}
