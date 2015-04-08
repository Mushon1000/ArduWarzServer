package com.mushon;

import Network.*;
import java.net.*;

public class MainClass {


    public static void main(String... s) throws InterruptedException, SocketException, UnknownHostException {

        try {

        DatagramSocket serverSocket = new DatagramSocket(9009);
        serverSocket.connect(InetAddress.getByName("192.168.1.101"), 9001);

        MyPacketBuilder PB1 = new MyPacketBuilder(serverSocket,1492,1,"192.168.1.101");


        PacketQueueClass messageQueue = new PacketQueueClass();


        new Thread(new Consumer(PB1,messageQueue)).start();

        Client client = new Client(serverSocket); //client reader for receiving packets
        client.start();


        MyKeyboardReader keyboardReader = new MyKeyboardReader(PB1,messageQueue); //keyboard reader for reading commands from user
        System.out.println("Server started - enter w\\s\\a\\d & Enter...");
        keyboardReader.start();


        } catch (SocketException e)
        {
            System.out.println("SocketException: " + e);
        }
    }


}