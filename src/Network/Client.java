package Network;

import java.net.*;


/**
 * Created by Shai on 07/04/2015.
 */
public class Client extends Thread {

    DatagramSocket socket = null;
    byte[] buffer = null;
    int socketTO = 1000;



    public Client(DatagramSocket socket, int timeOut){
        this.socket = socket;
        buffer = new byte[1024];
        this.socketTO = timeOut;
    }


    public void run()
    {
        /*try {
            socket.setSoTimeout(socketTO);
        } catch (SocketException e) {
            e.printStackTrace();
        }*/
        while ( true ) {
                   DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                   //System.out.println("1");

                   try {
                        //System.out.println("2");
                        socket.receive(packet);
                       //System.out.println("3");
                        handlePacket(packet, buffer);
                        //String s = new String(packet.getData());
                        //System.out.println(s);
                    } catch ( Exception e ) {
                        System.out.println("Exception: \n" + e.getMessage());
                        e.printStackTrace();

                    }
                }
    }

    private void handlePacket(DatagramPacket packet, byte[] buffer) {

        for(int i = 0; i < buffer.length; i++)
        {
            System.out.print("[" + buffer[i] + "]");
        }
        System.out.println();
        byte[] message = new byte[buffer.length - 5];
        for(int i = 5; i < buffer.length; i++)
        {
            message[i-5] = buffer[i-1];
        }
        String s = new String(message);
        System.out.print("Info from robot: ");
        System.out.println(s);
    }
}
