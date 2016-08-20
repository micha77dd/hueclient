package de.koenig_software.hueclient;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Michael König on 25.07.2016.
 */
@JsonDeserialize(using = AllLightsResponse.Deserializer.class)
public class AllLightsResponse extends ArrayList<HueLight> {


    public static class Deserializer extends BaseNodeDeserializer<AllLightsResponse> {

        @Override
        public AllLightsResponse deserialize(final JsonParser p, final DeserializationContext ctxt)
                throws IOException {
            ctxt.


            final JsonToken current = p.currentToken();
            if (current.isStructStart()) {
                final JsonToken next = p.nextToken();
                final String name = next.name();
                final String value = next.asString();
                final int id = next.id();
                System.out.println(next);
            }


            String raw = p.getText();
            return null;
        }
    }

}
