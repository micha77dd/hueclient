package de.koenig_software.hueclient;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author Michael on 24.07.2016.
 */
@Component
@FeignClient(name="hue", url = "${hue.server.root}")
public interface HueLightsClient {

    @RequestMapping(path = "/api/{username}/lights", method = GET)
    AllLightsResponse getAllLights(@PathVariable("username") final String username);

    @RequestMapping(path = "/api/{username}/lights/new", method = GET)
    NewHueLightsResponse getNewLights(@PathVariable("username") final String username);

    @RequestMapping(path = "/api/<username>/lights", method = POST)
    SearchLightsResponse searchForNewLights(@PathVariable("username") final String username);

    @RequestMapping(path = "/api/{username}/lights/{id}", method = GET)
    HueLight getLightAttributesAndState(@PathVariable("username") final String username,
                                        @PathVariable("id") final String id);

    @RequestMapping(path = "/api/{username}/lights/{id}", method = PUT)
    RenameLightResponse setLightAttributesRename(@PathVariable("username") final String username,
                                                 @PathVariable("id") final String id,
                                                 @RequestBody RenameLightRequest request);

    @RequestMapping(path = "/api/{username}/lights/{id}/state", method = PUT)
    SetLightStateResponse setLightState(@PathVariable("username") final String username,
                                        @PathVariable("id") final String id,
                                        @RequestBody SetLightStateRequest request);

    @RequestMapping(path = "/api/{username}/lights/{id}", method = DELETE)
    void deleteLights(@PathVariable("username") final String username,
                      @PathVariable("id") final String id);

}
