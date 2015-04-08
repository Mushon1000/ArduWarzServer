package com.mushon;

import Network.IPacketBuilder;
import Network.MessageType;
import Network.MyPacketBuilder;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.PacketFilter;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*try {
            DatagramSocket serverSocket = new DatagramSocket(9001, InetAddress.getByName("localhost1"));
            MyPacketBuilder PB1 = new MyPacketBuilder(serverSocket,1492,1);
            PB1.BuildPacket(MessageType.UNITCOMMAND);
            PB1.SendNextPacket();
            System.out.println(PB1.getIPAddressStr());
            //PB1.SetCurrentPacket();
            //System.out.println("Length: " + sendData.getLength());
            System.out.println(PB1.GetCurrentPacket());
            //System.out.println();


        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }*/
    }
}
