package com.mushon;

/**
 * Created by Shai on 31/01/2015.
 */
import Robot.DigixRobot;
import Robot.IRobot;

public class RobotTester {

    public static void main(String[] args) {

        IRobot robot1 = (IRobot) new DigixRobot();
        // Read commands from command line
        // Call robot1 according commands

        // Example: got walkonestep command then:
        robot1.moveStepForward();

    }

}
