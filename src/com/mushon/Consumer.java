package com.mushon;

import Network.MyPacketBuilder;

class Consumer implements Runnable {
    PacketQueueClass messageQueue;
    MyPacketBuilder PB;

    public Consumer(MyPacketBuilder pb, PacketQueueClass messageQueue) {
        PB = pb;
        this.messageQueue = messageQueue;
    }

    public void run() {
        try {
            while(!PB.isCurrentSequenceIDGotAck());
            {
                //do not consume from queue since we did not get ack for last message
            }
            messageQueue.retrieve();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}