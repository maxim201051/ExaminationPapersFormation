package ua.nau.epf.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import javafx.util.Pair;

import java.io.IOException;

public class JavaFXPairCustomDeserializer extends JsonDeserializer<Pair<String, Long>> {
    @Override
    public Pair<String, Long> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        String key = node.get("key").asText();
        Long value = node.get("value").longValue();
        return new Pair<>(key, value);
    }
}
