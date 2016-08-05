package de.koenig_software.hueclient;

import lombok.Data;

/**
 * @author Michael König on 25.07.2016.
 */
@Data
public class SetLightStateRequest extends HueLightState {

    /**
     * The duration of the transition from the light’s current state to the new state. This is given as a multiple of 100ms and defaults to 4 (400ms). For example, setting transitiontime:10 will make the transition last 1 second.
     */
    private int transitiontime;
    /**
     * As of 1.7. Increments or decrements the value of the brightness.  bri_inc is ignored if the bri attribute is provided. Any ongoing bri transition is stopped. Setting a value of 0 also stops any ongoing transition. The bridge will return the bri value after the increment is performed.
     */
    private int bri_inc;
    /**
     * As of 1.7. Increments or decrements the value of the sat.  sat_inc is ignored if the sat attribute is provided. Any ongoing sat transition is stopped. Setting a value of 0 also stops any ongoing transition. The bridge will return the sat value after the increment is performed.
     */
    private int sat_inc;
    /**
     * As of 1.7. Increments or decrements the value of the hue.   hue_inc is ignored if the hue attribute is provided. Any ongoing color transition is stopped. Setting a value of 0 also stops any ongoing transition. The bridge will return the hue value after the increment is performed.
     * Note if the resulting values are < 0 or > 65535 the result is wrapped. For example:
     * <p>
     * {"hue_inc":  1}
     * on a hue value of 65535 results in a hue of 0.
     * <p>
     * {"hue_inc":  -2}
     * on a hue value of 0 results in a hue of 65534.
     */
    private int hue_inc;
    /**
     * As of 1.7. Increments or decrements the value of the ct. ct_inc is ignored if the ct attribute is provided. Any ongoing color transition is stopped. Setting a value of 0 also stops any ongoing transition. The bridge will return the ct value after the increment is performed.
     */
    private int ct_inc;
    /**
     * As of 1.7. Increments or decrements the value of the xy.  xy_inc is ignored if the xy attribute is provided. Any ongoing color transition is stopped. Setting a value of 0 also stops any ongoing transition. Will stop at it's gamut boundaries. The bridge will return the xy value after the increment is performed. Max value [0.5, 0.5].
     */
    private float[] xy_inc;
}
