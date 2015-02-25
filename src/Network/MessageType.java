package Network;

/**
 * Created by Shai on 31/01/2015.
 */
public enum MessageType {

    GLOBALALERT	(0),	//Emergency actions for all units
    GLOBALINFORM (1),	//Global updates for all units
    UNITALERT (10),	//Actions for a specific unit
    UNITQUERY (11),	//Query for a specific unit
    UNITINFORM (12),	//Updates for a specific unit
    UNITCOMMAND (13),	//Commands for a specific unit
    COORDSUPDATE (20),	//Updates about coordinations
    COORDSQUERY (21) //Query for coordinations
    ;


    private final int MessageTypeCode;

    MessageType(int MessageTypeCode) {
        this.MessageTypeCode = MessageTypeCode;
    }

    public int getMessageTypeCode() {
        return this.MessageTypeCode;
    }

}
