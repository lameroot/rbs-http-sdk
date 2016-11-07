package ru.rbs.http.api.methods.adapters;

import ru.rbs.http.api.methods.RegisterOrderProcess;

public class RegisterOrderProcessTypeAdapter extends BaseProcessTypeAdapter<RegisterOrderProcess> {

    @Override
    public Class<RegisterOrderProcess> getType() {
        return RegisterOrderProcess.class;
    }
}
