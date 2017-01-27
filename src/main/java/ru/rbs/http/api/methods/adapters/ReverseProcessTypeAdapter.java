package ru.rbs.http.api.methods.adapters;

import ru.rbs.http.api.methods.ReverseProcess;

public class ReverseProcessTypeAdapter extends BaseProcessTypeAdapter<ReverseProcess>{

    @Override
    public Class<ReverseProcess> getType() {
        return ReverseProcess.class;
    }
}
