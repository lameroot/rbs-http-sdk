package ru.rbs.http.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class JsonParamsHelper {

    private final static Logger logger = LoggerFactory.getLogger(JsonParamsHelper.class);
    private final static ObjectMapper objectMapper = new ObjectMapper();

    private Map params = new HashMap<>();

    public JsonParamsHelper add(Object key, Object value) {
        params.put(key, value);
        return this;
    }

    public String toString() {
        try {
            return objectMapper.writeValueAsString(params);
        } catch (JsonProcessingException e) {
            logger.error("Error convert params to json",e);
        }
        return null;
    }
}
