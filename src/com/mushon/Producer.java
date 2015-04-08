package com.mushon;
//http://www.codeproject.com/Tips/813407/Producer-Consumer-Problem#
import Network.MyPacketBuilder;

public class Producer implements Runnable {
    PacketQueueClass messageQueue;
    MyPacketBuilder PB;
    //String emailMessageContent;

    public Producer(MyPacketBuilder pb, PacketQueueClass messageQueue) {
        PB = pb;
        this.messageQueue = messageQueue;
    }

    public void run() {
        try {
            messageQueue.adds(PB);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}