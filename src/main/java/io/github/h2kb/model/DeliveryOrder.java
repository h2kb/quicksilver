package io.github.h2kb.model;

public class DeliveryOrder {

    private final Long id;

    private final String orderNumber;

    private final Long customerId;

    public DeliveryOrder(Long id, String orderNumber, Long customerId) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
