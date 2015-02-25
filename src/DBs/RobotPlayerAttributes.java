package DBs;

/**
 * Created by Shai on 31/01/2015.
 */
public interface RobotPlayerAttributes {
}

/*
package Server;

public class RobotAttributes implements Encodable {
	protected short			unitID; //the identifier of this unit
	protected String		unitName; //the name of this unit
	protected short			teamID; //the identifier of the team this unit belongs to
	protected String		teamName; //the name of the team this unit belongs to
	protected short			adminID; //the identifier of the entity controlling this unit
	protected String		adminName; //the name of the entity controlling this unit
	protected short			supply; //amount of supply this unit consume
	protected float			size; //size of the unit
	protected short			cargo; //how many can carry
	protected short			shield; //Total hit points before health start decreasing
	protected short			health; //Total hit points before killed
	protected float			demagePerSecond; //points received when hitting unit with specific attributes
	protected String		attackMode; //S - Splash, P - Projectile, L - Linear/Lined.
	protected String		attributes; //L - Light, A - Armored, B - Biological, M - Mechanical, P - Psionic, Ma - Massive, S - Structure.
	protected float			bonusPoints; //bonus points received when hitting unit with specific attributes
	protected float			bonusPointsPerSecond; //bonus points per second received when hitting unit with specific attributes
	protected float			bonusAttributes; //the specific attributes that hitting a unit of that kind will provide the bonus points
	protected float			attackRange; //range in centimeters this unit can hit other units
	protected float			sightRange; //range in centimeters this unit can see other units
	protected float			speed; //speed in centimeters per seconds this unit can travel
	protected float			traverseSpeed; //Traverse speed in degrees per seconds this unit can turn

	protected short			attackUpgradeLevels; //how many upgrades attack of this unit can have
	protected short			attackUpgradeLevelCost; //the base cost of an attack upgrade
	protected short			attackUpgradeLevelCostFactor; //the factor of each level cost (level * cost * (factor * level))




	@Override
	public String Encode() {
		String encoding = String.valueOf(this.unitID) + "|" + String.valueOf(this.unitName) + "|" + String.valueOf(this.teamID); // add to later
		return encoding;
	}
	@Override
	public void Decode(String encoding) {
		String[] values = encoding.split("\\|");
		this.unitID = (short) Integer.parseUnsignedInt(values[0]);
		this.unitName = values[1];
		this.teamID = (short) Integer.parseUnsignedInt(values[2]);

	}

}

 */