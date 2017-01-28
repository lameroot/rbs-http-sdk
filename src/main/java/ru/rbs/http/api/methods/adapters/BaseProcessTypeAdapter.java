package ru.rbs.http.api.methods.adapters;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.rbs.http.api.methods.BaseProcess;
import ru.rbs.http.api.util.Strings;

import java.io.IOException;

public abstract class BaseProcessTypeAdapter<T extends BaseProcess> implements TypeAdapter<T>{

    protected ObjectMapper objectMapper;

    public BaseProcessTypeAdapter() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    public T fromJson(String json) throws IOException {
        T object = objectMapper.readValue(json,getType());
        if ( null == object.getErrorCode() ) object.setErrorCode(0);
        if (Strings.isNullOrEmpty(object.getErrorMessage())) object.setErrorMessage("Success message");
        return object;
    }

    public abstract Class<T> getType();
}
