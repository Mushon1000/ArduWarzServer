package Network;

import java.io.IOException;
import java.net.*;

/**
 * Created by Shai on 31/01/2015.
 */
public class MyPacketBuilder implements IPacketBuilder {


    long lastSequenceID; //for tracking sequence
    long currentSequenceID; //for tracking sequence



    long unitID; //the unit ID to communicate with 4294967295
    boolean currentSequenceIDGotAck = true; //true ate start since there were no packet before... true if got ack for current sequence id
    boolean isChecksumValid;
    int sessionPort; //UDP/TCP port
    DatagramSocket serverSocket; //socket object for communication
    int maxPacketSize;
    byte[] receiveData; // the byte[] to hold incoming packets
    byte[] nextReceiveData; // the byte[] to hold incoming packets
    MyByteArray sendData; //the byte[] to hold outgoing packets
    MyByteArray nextSendData; //the byte[] to hold outgoing packets
    String IPAddressStr; //String representation of the IP address for communications
    InetAddress IPAddress; //IP address for communications

    short protocolID = 23;    //256
    long seqID;                //4294967295
    long checksum;             //4294967295
    UnitCommandOpCode currentUnitCommandOpCode; //this should be set every time a unit command is built
    long currentUnitCommandDurationMillis = 1000;



    public MyPacketBuilder() {
    }

    public MyPacketBuilder(DatagramSocket socket, int maxPacketSize, long unitID, String IPAddressStr) throws SocketException, UnknownHostException {
        this.IPAddressStr = IPAddressStr;
        this.maxPacketSize = maxPacketSize;
        this.sessionPort = socket.getPort();
        this.unitID = unitID;


        this.serverSocket = socket;
        this.IPAddress = InetAddress.getByName(IPAddressStr);

        this.receiveData = new byte[maxPacketSize];
        this.sendData = new MyByteArray(maxPacketSize);

        this.setSeqID(1); //init sequence ID to 1
    }

    @Override
    public void SendNextPacket() {
        DatagramPacket sendPacket =  new DatagramPacket(sendData.getArrayAsByteArray(), sendData.getLength());
        try {
            serverSocket.send(sendPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void BuildPacket(MessageType messageType) {



        sendData.setArrValue(0,(byte)(protocolID));                                 //protocolID
        sendData.setArrValue(1,(byte)((messageType.getMessageTypeCode() >> 8) & 0xFF));   //msg_type
        sendData.setArrValue(2,(byte)(messageType.getMessageTypeCode() & 0xFF));          //msg_type
        sendData.setArrValue(3,(byte)((getUnitID()  >> 24) & 0xFF));                //unit_id
        sendData.setArrValue(4,(byte)((getUnitID()  >> 16) & 0xFF));                //unit_id
        sendData.setArrValue(5,(byte)((getUnitID()  >> 8) & 0xFF));                 //unit_id
        sendData.setArrValue(6,(byte)(getUnitID() & 0xFF));                         //unit_id
        sendData.setArrValue(7,(byte)((getSeqID()  >> 24) & 0xFF));                 //seq_id
        sendData.setArrValue(8,(byte)((getSeqID()  >> 16) & 0xFF));                 //seq_id
        sendData.setArrValue(9,(byte)((getSeqID()  >> 8) & 0xFF));                  //seq_id
        sendData.setArrValue(10,(byte)(getSeqID() & 0xFF));                         //seq_id
        sendData.setArrValue(11,(byte)((getChecksum()  >> 24) & 0xFF));             //checksum
        sendData.setArrValue(12,(byte)((getChecksum()  >> 16) & 0xFF));             //checksum
        sendData.setArrValue(13,(byte)((getChecksum()  >> 8) & 0xFF));              //checksum
        sendData.setArrValue(14,(byte)(getChecksum() & 0xFF));                      //checksum
        switch(messageType)
        {
            case UNITCOMMAND:
                BuildPacketUNITCOMMAND();
                setSeqID(getSeqID()+1); //increment sequence id
                currentSequenceIDGotAck = false; //need to set to true when ack is received
                break;
            default:
                System.out.println("Unhandled message type: " + messageType.toString());
        }
    }

    private void BuildPacketUNITCOMMAND(){
        int commandsCount = 1;
        int commandOpCode = getCurrentUnitCommandOpCode().getUnitCommandOpCodeCode();
        //int RSV
        long duration = getCurrentUnitCommandDurationMillis();

        sendData.setArrValue(15,(byte)(commandsCount)); //Command_count
        sendData.setArrValue(16,(byte)((commandOpCode >> 8) & 0xFF)); //Command_opCode
        sendData.setArrValue(17,(byte)(commandOpCode & 0xFF)); //Command_opCode
        sendData.setArrValue(18,(byte)(0)); //RSV

        sendData.setArrValue(19,(byte)((duration >> 24) & 0xFF)); //Duration
        sendData.setArrValue(20,(byte)((duration >> 16) & 0xFF)); //Duration
        sendData.setArrValue(21,(byte)((duration >> 8) & 0xFF)); //Duration
        sendData.setArrValue(22,(byte)(duration & 0xFF)); //Duration
    }


    @Override
    public boolean IsLastPacketReceivedAck() {
        return false;
    }

    @Override
    public void CalcSequenceID() {
        if (currentSequenceIDGotAck){
            setCurrentSequenceID(getCurrentSequenceID()+1);
            setCurrentSequenceIDGotAck(false);
        }
    }

    @Override
    public MyByteArray GetCurrentPacket() {
        return null;
    }

    @Override
    public MyByteArray GetNextPacket() {
        return null;
    }

    @Override
    public MyByteArray SetCurrentPacket(MyByteArray currentPacket) {
        return null;
    }

    @Override
    public MyByteArray SetNextPacket(MyByteArray nextPacket) {
        return null;
    }





    //Getters & Setters
    public long getLastSequenceID() {
        return lastSequenceID;
    }

    public void setLastSequenceID(long lastSequenceID) {
        this.lastSequenceID = lastSequenceID;
    }

    public long getCurrentSequenceID() {
        return currentSequenceID;
    }

    public void setCurrentSequenceID(long currentSequenceID) {
        this.currentSequenceID = currentSequenceID;
    }

    public boolean isCurrentSequenceIDGotAck() {
        return currentSequenceIDGotAck;
    }

    public void setCurrentSequenceIDGotAck(boolean currentSequenceIDGotAck) {
        this.currentSequenceIDGotAck = currentSequenceIDGotAck;
    }

    public boolean isChecksumValid() {
        return isChecksumValid;
    }

    public void setChecksumValid(boolean isChecksumValid) {
        this.isChecksumValid = isChecksumValid;
    }

    public int getSessionPort() {
        return sessionPort;
    }

    public void setSessionPort(int sessionPort) {
        this.sessionPort = sessionPort;
    }

    public DatagramSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(DatagramSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public int getMaxPacketSize() {
        return maxPacketSize;
    }

    public void setMaxPacketSize(int maxPacketSize) {
        this.maxPacketSize = maxPacketSize;
    }

    public byte[] getReceiveData() {
        return receiveData;
    }

    public void setReceiveData(byte[] receiveData) {
        this.receiveData = receiveData;
    }

    public byte[] getNextReceiveData() {
        return nextReceiveData;
    }

    public void setNextReceiveData(byte[] nextReceiveData) {
        this.nextReceiveData = nextReceiveData;
    }

    public MyByteArray getSendData() {
        return sendData;
    }

    public void setSendData(MyByteArray sendData) {
        this.sendData = sendData;
    }

    public MyByteArray getNextSendData() {
        return nextSendData;
    }

    public void setNextSendData(MyByteArray nextSendData) {
        this.nextSendData = nextSendData;
    }

    public String getIPAddressStr() {
        return IPAddressStr;
    }

    public void setIPAddressStr(String IPAddressStr) {
        this.IPAddressStr = IPAddressStr;
    }

    public InetAddress getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(InetAddress IPAddress) {
        this.IPAddress = IPAddress;
    }

    public long getUnitID() {
        return unitID;
    }

    public void setUnitID(long unitID) {
        this.unitID = unitID;
    }

    public long getChecksum() {
        return checksum;
    }

    public void setChecksum(long checksum) {
        this.checksum = checksum;
    }

    public short getProtocolID() {
        return protocolID;
    }

    public void setProtocolID(short protocolID) {
        this.protocolID = protocolID;
    }

    public long getSeqID() {
        return seqID;
    }

    public void setSeqID(long seqID) {
        this.seqID = seqID;
    }

    public UnitCommandOpCode getCurrentUnitCommandOpCode() {
        return currentUnitCommandOpCode;
    }

    public void setCurrentUnitCommandOpCode(UnitCommandOpCode currentUnitCommandOpCode) {
        this.currentUnitCommandOpCode = currentUnitCommandOpCode;
    }

    public long getCurrentUnitCommandDurationMillis() {
        return currentUnitCommandDurationMillis;
    }

    public void setCurrentUnitCommandDurationMillis(long currentUnitCommandDurationMillis) {
        this.currentUnitCommandDurationMillis = currentUnitCommandDurationMillis;
    }
}
