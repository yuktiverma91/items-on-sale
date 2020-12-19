package com.rbc.interview.order.ordermanagement.models;

import java.io.Serializable;

public class UserOrderClass implements Serializable {

    String userId;
    String orderId;

    public UserOrderClass(String userId, String orderId) {
        this.userId = userId;
        this.orderId = orderId;
    }
}
