package com.shagi.poker.pokerchipsas.severmode;


interface Communicator {
    void startCommunication();
    void write(String message);
    void stopCommunication();
}
