package com.mushon;

import Network.MyPacketBuilder;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PacketQueueClass {

    Queue<MyPacketBuilder> q = new LinkedList<MyPacketBuilder>();
    private int queueMaxSize = 20;

    synchronized void retrieve() throws InterruptedException {
        while (true) {
            while (q.isEmpty()) {
                wait();
            }
            q.remove();
            System.out.print("Packet Queue::::::[");
            Iterator<MyPacketBuilder> it = q.iterator();
            while (it.hasNext())
                System.out.print(it.next() + ",");
            System.out.print("]");
            System.out.println();
            notifyAll();
        }
    }

    synchronized void adds(MyPacketBuilder packet) throws InterruptedException {
        while (q.size() == queueMaxSize) {
            wait();
        }
        q.add(packet);
        System.out.print("Packet Queue::::::[");
        Iterator<MyPacketBuilder> it = q.iterator();
        while (it.hasNext()) {
            //System.out.print(it.next() + ",");
            it.next().SendNextPacket();
        }
        System.out.print("]");
        System.out.println();
        notify();
    }
}