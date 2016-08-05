package de.koenig_software.hueclient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Michael König on 25.07.2016.
 */
@Data
public class NewHueLightsResponse extends ArrayList<HueLight> {

    private final String lastscan;

    @JsonIgnore
    public LocalDateTime getLastScanTime() {
        return LocalDateTime.parse(lastscan);
    }

}
