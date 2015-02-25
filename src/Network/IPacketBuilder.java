package Network;

/**
 * Created by Shai on 31/01/2015.
 */
public interface IPacketBuilder {
    void SendNextPacket();
    void BuildPacket(MessageType messageType);
    boolean IsLastPacketReceivedAck();
    void CalcSequenceID();
    MyByteArray GetCurrentPacket(); //returns MyByteArray object containing the bytes of the current packet
    MyByteArray GetNextPacket(); //returns MyByteArray object containing the bytes of the next packet
    MyByteArray SetCurrentPacket(MyByteArray currentPacket); //sets MyByteArray object containing the bytes of the current packet
    MyByteArray SetNextPacket(MyByteArray nextPacket); //sets MyByteArray object containing the bytes of the next packet


    /*
    vars needed for implementation:
    long lastSequenceID //for tracking sequence
    long currentSequenceID //for tracking sequence
    boolean currentSequenceIDGotAck //true if got ack for current sequence id
    boolean isChecksumValid
    int sessionPort //UDP/TCP port
	DatagramSocket serverSocket //socket object for communication
	int maxPacketSize
	byte[] receiveData // the byte[] to hold incoming packets
	byte[] nextReceiveData // the byte[] to hold incoming packets
	MyByteArray sendData //the byte[] to hold outgoing packets
	MyByteArray nextSendData //the byte[] to hold outgoing packets
	InetAddress IPAddress //IP address for communications


	global protocol headers:
	protocolID
	msg_type
	unit_id
	seq_id
	checksum

	message types:
	int GLOBALALERT	= 0	//Emergency actions for all units
    int GLOBALINFORM = 1	//Global updates for all units
    int UNITALERT = 10	//Actions for a specific unit
    int UNITQUERY = 11	//Query for a specific unit
    int UNITINFORM = 12	//Updates for a specific unit
    int UNITCOMMAND = 13	//Commands for a specific unit
    int COORDSUPDATE = 20	//Updates about coordinations
    int COORDSQUERY = 21	//Query for coordinations

    UNITCOMMAND fields:
	Command_count
	Command_opCode
	Duration
     */
}
