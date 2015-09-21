package com.shagi.poker.pokerchipsas.Activities;

/**
 * Created by Shagi on 18.09.2015.
 */
public class Player {
    private String name;
    private String move;
    private int bank;

    public Player(String name, String move, int bank) {
        this.name = name;
        this.move = move;
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }
}
