package ru.rbs.http.api.methods.adapters;

import ru.rbs.http.api.methods.DepositProcess;

public class DepositProcessTypeAdapter extends BaseProcessTypeAdapter<DepositProcess> {

    @Override
    public Class<DepositProcess> getType() {
        return DepositProcess.class;
    }
}
