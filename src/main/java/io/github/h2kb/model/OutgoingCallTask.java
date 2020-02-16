package io.github.h2kb.model;

import java.util.Date;

public class OutgoingCallTask {

    private final Long id;

    private final Date createAt;

    private final Long deliveryOrderId;

    public OutgoingCallTask(Long id, Date createAt, Long deliveryOrderId) {
        this.id = id;
        this.createAt = createAt;
        this.deliveryOrderId = deliveryOrderId;
    }

    public Long getId() {
        return id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Long getDeliveryOrderId() {
        return deliveryOrderId;
    }
}
