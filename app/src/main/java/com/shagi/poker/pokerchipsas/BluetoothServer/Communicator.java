package com.shagi.poker.pokerchipsas.BluetoothServer;


interface Communicator {
    void startCommunication();
    void write(String message);
    void stopCommunication();
}
