package com.shagi.poker.pokerchipsas.BluetoothServer;

import android.bluetooth.BluetoothSocket;


interface CommunicatorService {
    Communicator createCommunicatorThread(BluetoothSocket socket);
}
