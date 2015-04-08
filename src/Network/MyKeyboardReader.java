package Network;


import com.mushon.PacketQueueClass;
import com.mushon.Producer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Shai on 09/04/2015.
 */
public class MyKeyboardReader extends Thread {
    MyPacketBuilder PB;
    PacketQueueClass MessageQueue;

    public MyKeyboardReader(MyPacketBuilder pb, PacketQueueClass messageQueue){
        this.PB = pb;
        this.MessageQueue = messageQueue;
    }



    public void run()
    {
        while (true) {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String cmd = null;
            try {
                cmd = br.readLine();
                System.out.println(cmd);
                if (cmd.toString().equals("w")) {
                    PB.setCurrentUnitCommandDurationMillis(300);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.MOVEFORWARDTIMED);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("x")) {
                    PB.setCurrentUnitCommandDurationMillis(300);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.MOVEBACKWARDTIMED);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("a")) {
                    PB.setCurrentUnitCommandDurationMillis(300);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.ROTATELEFTTIMED);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("d")) {
                    PB.setCurrentUnitCommandDurationMillis(300);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.ROTATERIGHTTIMED);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else {
                    PB.setCurrentUnitCommandDurationMillis(300);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.MOVESTOP);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }

                new Thread(new Producer(PB, MessageQueue)).start();

            } catch (IOException ioe) {
                System.out.println("IO error trying to read your name!");
                System.exit(1);
            }


        }
    }




}