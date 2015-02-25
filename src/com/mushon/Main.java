package com.mushon;

import Network.IPacketBuilder;
import Network.MessageType;
import Network.MyPacketBuilder;
import org.jivesoftware.smack.PacketCollector;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.PacketFilter;

import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            MyPacketBuilder PB1 = new MyPacketBuilder("localhost",1492,9001,1);
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
        }
    }
}
