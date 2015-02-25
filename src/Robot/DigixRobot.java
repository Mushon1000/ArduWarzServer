package Robot;

import Arduino.IArduino;

/**
 * Created by Shai on 31/01/2015.
 */
public class DigixRobot implements IRobot{

    IArduino myArduino;

    @Override
    public void moveStepForward() {
        int stepTime = 1500;
        myArduino.startEngineA(stepTime); // for 3 secs

    }

}
