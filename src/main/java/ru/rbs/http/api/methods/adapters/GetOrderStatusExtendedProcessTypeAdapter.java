package ru.rbs.http.api.methods.adapters;

import ru.rbs.http.api.methods.OrderStatusExtendedProcess;

public class GetOrderStatusExtendedProcessTypeAdapter extends BaseProcessTypeAdapter<OrderStatusExtendedProcess> {

    @Override
    public Class<OrderStatusExtendedProcess> getType() {
        return OrderStatusExtendedProcess.class;
    }
}
