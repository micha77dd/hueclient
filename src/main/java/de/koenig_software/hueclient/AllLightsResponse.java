package de.koenig_software.hueclient;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Michael König on 25.07.2016.
 */
@JsonDeserialize(using = AllLightsResponse.Deserializer.class)
public class AllLightsResponse extends ArrayList<HueLight> {

    static class Deserializer extends StdDeserializer<AllLightsResponse> {

        public Deserializer() {
            super(AllLightsResponse.class);
        }

        @Override
        public AllLightsResponse deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException {
            final AllLightsResponse response = new AllLightsResponse();

            final JavaType elementType = ctxt.constructType(HueLight.class);
            final JsonDeserializer<Object> hueLightDeser = ctxt.findRootValueDeserializer(elementType);

            if (p.isExpectedStartObjectToken()) {
                String id = null;
                while (true) {
                    final JsonToken next = p.nextToken();
                    if (next == null) {
                        break;
                    }

                    if (!p.isExpectedStartObjectToken()) {
                        id = p.getText();
                        continue;
                    }

                    final HueLight light = (HueLight) hueLightDeser.deserialize(p, ctxt);
                    light.setId(id);
                    response.add(light);
                }
            } else {
                throw new IllegalArgumentException("unexpected JSON structure. " + p.getText());
            }

            return response;
        }
    }

}
