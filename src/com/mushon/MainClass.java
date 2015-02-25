package com.mushon;

import Network.MessageType;
import Network.MyPacketBuilder;
import Network.UnitCommandOpCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MainClass {


    public static void main(String... s) throws InterruptedException, SocketException, UnknownHostException {
        MyPacketBuilder PB1 = new MyPacketBuilder("192.168.1.101",1492,9001,1);
        //PB1.BuildPacket(MessageType.UNITCOMMAND);
        //PB1.SendNextPacket();
        PacketQueueClass messageQueue = new PacketQueueClass();

        new Thread(new Consumer(PB1,messageQueue)).start();

int i = 0;
while (true) {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String cmd = null;
    try {
        cmd = br.readLine();
        System.out.println(cmd);
        if (cmd.toString().equals("w")) {
            PB1.setCurrentUnitCommandDurationMillis(2000);
            PB1.setCurrentUnitCommandOpCode(UnitCommandOpCode.MOVEFORWARDTIMED);
            PB1.BuildPacket(MessageType.UNITCOMMAND);
        }else if (cmd.toString().equals("x")) {
            PB1.setCurrentUnitCommandDurationMillis(500);
            PB1.setCurrentUnitCommandOpCode(UnitCommandOpCode.MOVEBACKWARDTIMED);
            PB1.BuildPacket(MessageType.UNITCOMMAND);
        }else if (cmd.toString().equals("a")) {
            PB1.setCurrentUnitCommandDurationMillis(500);
            PB1.setCurrentUnitCommandOpCode(UnitCommandOpCode.ROTATELEFTTIMED);
            PB1.BuildPacket(MessageType.UNITCOMMAND);
        }else if (cmd.toString().equals("d")) {
            PB1.setCurrentUnitCommandDurationMillis(500);
            PB1.setCurrentUnitCommandOpCode(UnitCommandOpCode.ROTATERIGHTTIMED);
            PB1.BuildPacket(MessageType.UNITCOMMAND);
        }else {
            PB1.setCurrentUnitCommandDurationMillis(500);
            PB1.setCurrentUnitCommandOpCode(UnitCommandOpCode.MOVESTOP);
            PB1.BuildPacket(MessageType.UNITCOMMAND);
        }





            new Thread(new Producer(PB1, messageQueue)).start();
            //System.out.print("Q size(" + messageQueue.q.size() + ")| ");
            //Thread.sleep(0);
            //i++;

    } catch (IOException ioe) {
        System.out.println("IO error trying to read your name!");
        System.exit(1);
    }


}
        /*
        for (int i = 0; i < 1000; ++i) {
            new Thread(new Producer(" " + i, messageQueue)).start();
            System.out.print("Q size(" + messageQueue.q.size() + ")| ");
            Thread.sleep(0);
        }
        */

    }


}