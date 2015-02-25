package Network;

/**
 * Created by Shai on 31/01/2015.
 */
public interface IUDPServer {

}

/*
package Server;
import java.io.*;
import java.net.*;

//See more at: http://systembash.com/content/a-simple-java-udp-server-and-udp-client/#sthash.Su6TN2vn.dpuf


class UDPServer
{


	public int GetFirstNullIndex(byte[] arr){
		int index = 0;
		for (int i=0; i<=arr.length-1; i++) {
			if (arr[i] != 0) {
				index=i;
				break;
			}
		}
		return index;
	}
	public static void main(String args[]) throws Exception
	{
		int port = 9001;
		DatagramSocket serverSocket = new DatagramSocket(port);
		byte[] receiveData = new byte[1024];
		MyByteArray sendData = new MyByteArray(1);
		InetAddress IPAddress = InetAddress.getByName("192.168.1.101");


		byte randMin = 1;
		byte randMax = (byte) 127;
		byte randTemp = 0;
		long packetCount = 0;
		while(packetCount < 0)
		{
			//
            //    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            //    serverSocket.receive(receivePacket);
            //    String sentence = new String( receivePacket.getData());
            //    System.out.println("RECEIVED: " + sentence);
            //    InetAddress IPAddress = receivePacket.getAddress();
            //    int port = receivePacket.getPort();
			//

Thread.sleep(10);
        //String capitalizedSentence = sentence.toUpperCase();
        //sendData = capitalizedSentence.getBytes();

        //System.out.println(randMin +","+randMax);
        //randTemp = (byte) ( ((Math.random() * (randMax -randMin) + randMin)));
        //System.out.println(randTemp);
        //if (randTemp < 0) randTemp += 256;

        sendData.setArrValue(0,(byte) (0));
        //randTemp = (byte) ( ((Math.random() * (randMax -randMin) + randMin)));
        sendData.setArrValue(1,(byte) (228)); //operation
        //randTemp = (byte) ( ((Math.random() * (randMax -randMin) + randMin)));
        sendData.setArrValue(2,(byte) (1)); //duration

        System.out.println("Length: " + sendData.getLength());
        sendData.PrintByteArray();System.out.println();
        DatagramPacket sendPacket =  new DatagramPacket(sendData.getArrayAsByteArray(), sendData.getLength(), IPAddress, port);
        serverSocket.send(sendPacket);
        packetCount +=1;
        System.out.println(packetCount);
        //System.out.println(sendPacket);
        }

        sendData.setArrValue(0,(byte)(23)); //protocolID
        sendData.setArrValue(1,(byte)(0)); //msg_type
        sendData.setArrValue(2,(byte)(13)); //msg_type
        sendData.setArrValue(3,(byte)(0)); //unit_id
        sendData.setArrValue(4,(byte)(0)); //unit_id
        sendData.setArrValue(5,(byte)(0)); //unit_id
        sendData.setArrValue(6,(byte)(1)); //unit_id
        sendData.setArrValue(7,(byte)(0)); //seq_id
        sendData.setArrValue(8,(byte)(0)); //seq_id
        sendData.setArrValue(9,(byte)(0)); //seq_id
        sendData.setArrValue(10,(byte)(2)); //seq_id
        sendData.setArrValue(11,(byte)(0)); //checksum
        sendData.setArrValue(12,(byte)(0)); //checksum
        sendData.setArrValue(13,(byte)(0)); //checksum
        sendData.setArrValue(14,(byte)(0)); //checksum

        sendData.setArrValue(15,(byte)(1)); //Command_count
        sendData.setArrValue(16,(byte)(0)); //Command_opCode
        sendData.setArrValue(17,(byte)(102)); //Command_opCode
        sendData.setArrValue(18,(byte)(0)); //RSV
        sendData.setArrValue(19,(byte)(0)); //Duration
        sendData.setArrValue(20,(byte)(0)); //Duration
        sendData.setArrValue(21,(byte)(0)); //Duration
        sendData.setArrValue(22,(byte)(5)); //Duration





        System.out.println("Length: " + sendData.getLength());
        sendData.PrintByteArray();System.out.println();
        DatagramPacket sendPacket =  new DatagramPacket(sendData.getArrayAsByteArray(), sendData.getLength(), IPAddress, port);
        serverSocket.send(sendPacket);



        }
        }
*/