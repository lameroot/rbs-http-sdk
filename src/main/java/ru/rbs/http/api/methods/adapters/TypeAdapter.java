package ru.rbs.http.api.methods.adapters;

import java.io.IOException;

public interface TypeAdapter<T> {

    T fromJson(String json) throws IOException;
}
