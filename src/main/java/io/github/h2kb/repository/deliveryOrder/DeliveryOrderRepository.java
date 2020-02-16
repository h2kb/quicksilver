package io.github.h2kb.repository.deliveryOrder;

import io.github.h2kb.model.DeliveryOrder;

public interface DeliveryOrderRepository {

    DeliveryOrder findById(Long id);

    DeliveryOrder findByOrderNumber(String orderNumber);
}
