package ru.rbs.http.api.methods.adapters;

import ru.rbs.http.api.methods.RegisterPreAuthOrderProcess;

public class RegisterPreAuthOrderProcessTypeAdapter extends BaseProcessTypeAdapter<RegisterPreAuthOrderProcess> {

    @Override
    public Class<RegisterPreAuthOrderProcess> getType() {
        return RegisterPreAuthOrderProcess.class;
    }
}
