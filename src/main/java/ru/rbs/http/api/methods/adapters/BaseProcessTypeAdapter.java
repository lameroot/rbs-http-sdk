package ru.rbs.http.api.methods.adapters;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public abstract class BaseProcessTypeAdapter<T> implements TypeAdapter<T>{

    protected ObjectMapper objectMapper;

    public BaseProcessTypeAdapter() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    public T fromJson(String json) throws IOException {
        return objectMapper.readValue(json,getType());
    }

    public abstract Class<T> getType();
}
