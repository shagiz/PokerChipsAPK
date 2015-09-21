package com.shagi.poker.pokerchipsas.severmode;

import android.bluetooth.BluetoothSocket;


interface CommunicatorService {
    Communicator createCommunicatorThread(BluetoothSocket socket);
}
