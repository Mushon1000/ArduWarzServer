package DBs;

/**
 * Created by Shai on 31/01/2015.
 */
public interface RobotPlayerStats {
}


/*
package Server;

public class RobotStats implements Encodable {
	protected int 			kills; //How many times this unit killed other units
	protected int 			deaths; //How many times this unit was killed
	protected double 		kdr;
	protected int 			moves; //how many moves this unit performed
	protected int 			centimetersTraveled; //how many centimeters this unit traveled
	protected int 			tilesExplored; //how many tiles this unit explored
	protected int 			see;
	protected int 			resourceCollected; //total resources collected by this unit
	protected int 			PointsReceived; //total points received for hitting units
	protected int 			PointsGiven; //total points other units received upon hitting this unit
	protected int 			bonusPointsReceived; //total bonus points received for hitting unit with specific attributes
	protected int 			bonusPointsGiven; //total bonus points other units received upon hitting this unit
	protected int 			timeSpentAtCooldown; //how many seconds this unit was in cooldown state
	protected int 			oneShotTaken; //how many deaths by one shot caused to you
	protected int 			oneShotGiven; //how many kills by one shot you caused



	@Override
	public String Encode() {
		String encoding = String.valueOf(this.kills) + "|" + String.valueOf(this.deaths) + "|" + String.valueOf(this.kdr); // add to later
		return encoding;
	}
	@Override
	public void Decode(String encoding) {
		String[] values = encoding.split("\\|");
		this.kills = Integer.parseInt(values[0]);
		this.deaths = Integer.parseInt(values[1]);
		this.kdr = Double.parseDouble(values[2]);

	}

}

 */