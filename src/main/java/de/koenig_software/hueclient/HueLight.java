package de.koenig_software.hueclient;

import lombok.Data;

/**
 * Created by Michael on 24.07.2016.
 */
@Data
public class HueLight {

    /** A fixed name describing the type of light e.g. “Extended color light”. */
    private String type;
    /** A unique, editable name given to the light. */
    private String name;
    /** The hardware model of the light. */
    private String modelid;
    /** An identifier for the software version running on the light. */
    private String swversion;
    /**
     * As of 1.9. Unique ID of the luminaire the light is a part of in the format:
     * AA:BB:CC:DD-XX-YY.  AA:BB:, ... represents the hex of the luminaireid, XX the lightsource
     * position (incremental but may contain gaps) and YY the lightpoint position (index of light in
     * luminaire group).  A gap in the lightpoint position indicates an incomplete luminaire (light
     * search required to discover missing light points in this case).
     */
    private String luminaireuniqueid;
    /** As of 1.7. The manufacturer name. */
    private String manufacturername;
    /**
     * As of 1.4. Unique id of the device. The MAC address of the device with a unique endpoint id
     * in the form: AA:BB:CC:DD:EE:FF:00:11-XX
     */
    private String uniqueid;

    /** Details the state of the light, see {@link HueLightState} for more details. */
    private HueLightState state;

    /**
     * This parameter is reserved for future functionality. As from 1.11 point symbols are no longer
     * returned.
     */
    private String pointsymbol;

}
