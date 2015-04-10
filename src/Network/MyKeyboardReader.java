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
        int motorPower = 255;
        while (true) {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String cmd = null;
            try {
                cmd = br.readLine();
                System.out.println(cmd);
                if (cmd.toString().equals("reset")){
                    PB.setCurrentUnitCommandDurationMillis(1);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.DEVICESWRESET);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("w")) {
                    PB.setCurrentUnitCommandDurationMillis(300);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.MOVEFORWARDTIMED);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("ww")) {
                    PB.setCurrentUnitCommandDurationMillis(100);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.MOVEFORWARDTIMED);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("x")) {
                    PB.setCurrentUnitCommandDurationMillis(300);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.MOVEBACKWARDTIMED);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("xx")) {
                    PB.setCurrentUnitCommandDurationMillis(100);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.MOVEBACKWARDTIMED);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("a")) {
                    PB.setCurrentUnitCommandDurationMillis(300);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.ROTATELEFTTIMED);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("aa")) {
                    PB.setCurrentUnitCommandDurationMillis(100);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.ROTATELEFTTIMED);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("d")) {
                    PB.setCurrentUnitCommandDurationMillis(300);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.ROTATERIGHTTIMED);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("dd")) {
                    PB.setCurrentUnitCommandDurationMillis(100);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.ROTATERIGHTTIMED);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("s")) {
                    PB.setCurrentUnitCommandDurationMillis(300);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.MOVESTOP);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("q")) {
                    PB.setCurrentUnitCommandDurationMillis(90);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.SERVOAFORWARDSTEPS);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("qq")) {
                    PB.setCurrentUnitCommandDurationMillis(10);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.SERVOAFORWARDSTEPS);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("qqq")) {
                    PB.setCurrentUnitCommandDurationMillis(180);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.SERVOAFORWARDSTEPS);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("e")) {
                    PB.setCurrentUnitCommandDurationMillis(90);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.SERVOABACKWARDSTEPS);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("ee")) {
                    PB.setCurrentUnitCommandDurationMillis(10);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.SERVOABACKWARDSTEPS);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("eee")) {
                    PB.setCurrentUnitCommandDurationMillis(180);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.SERVOABACKWARDSTEPS);
                    PB.BuildPacket(MessageType.UNITCOMMAND);
                }else if (cmd.toString().equals("power")) {
                    motorPower -= 10;
                    if (motorPower < 100)
                        motorPower = 255;
                    PB.setCurrentUnitCommandDurationMillis(motorPower);
                    PB.setCurrentUnitCommandOpCode(UnitCommandOpCode.DEVICEMOTORSPOWER);
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