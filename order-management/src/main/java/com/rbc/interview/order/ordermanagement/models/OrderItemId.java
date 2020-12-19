package com.rbc.interview.order.ordermanagement.models;

import java.io.Serializable;

public class OrderItemId implements Serializable {
    String orderId;
    String itemId;

    public OrderItemId(String orderId, String itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }
}
