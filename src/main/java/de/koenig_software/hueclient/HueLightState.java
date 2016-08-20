package de.koenig_software.hueclient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by Michael on 24.07.2016.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class HueLightState {

    /**
     * state of the light. On=true, Off=false
     */
    private boolean on;
    /**
     * Brightness of the light. This is a scale from the minimum brightness the light is capable of,
     * 1, to the maximum capable brightness, 254.
     */
    private int bri;
    /**
     * Hue of the light. This is a wrapping value between 0 and 65535. Both 0 and 65535 are red,
     * 25500 is green and 46920 is blue.
     */
    private int hue;

    /**
     * Saturation of the light. 254 is the most saturated (colored) and 0 is the least saturated
     * (white).
     */
    private int sat;

    /**
     * list 2..2 of float 4	The x and y coordinates of a color in CIE color space. The first entry
     * is the x coordinate and the second entry is the y coordinate. Both x and y are between 0 and
     * 1.
     */
    private float[] xy;

    /**
     * The Mired Color temperature of the light. 2012 connected lights are capable of 153 (6500K) to
     * 500 (2000K). //    alert	string	The alert effect, which is a temporary change to the bulb’s
     * state. This can take one of the following values:
     * <ul>
     * <li>“none” – The light is not performing an alert effect. </li>
     * <li>“select” – The light is performing one breathe cycle.</li>
     * <li>“lselect” – The light is performing breathe cycles for 15 seconds or until an
     * "alert": "none" command is received.</li>
     * </ul>
     * <p>
     * Note that this contains the last alert sent to the light and not its current state. i.e.
     * After the breathe cycle has finished the bridge does not reset the alert to "none".
     */
    private int ct;
    /**
     * The dynamic effect of the light, can either be “none” or “colorloop”.
     * <p>
     * If set to colorloop, the light will cycle through all hues using the current brightness and
     * saturation settings.
     */
    private String effect;

    /**
     * Indicates the color mode in which the light is working, this is the last command type it
     * received. Values are “hs” for Hue and Saturation, “xy” for XY and “ct” for Color Temperature.
     * This parameter is only present when the light supports at least one of the values.
     */
    private String colormode;

    /**
     * Indicates if a light can be reached by the bridge.
     */
    private boolean reachable;

}
