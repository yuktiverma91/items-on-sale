package com.rbc.interview.order.ordermanagement.models;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "userOrder")
@IdClass(UserOrderClass.class)
public class UserOrder {
    @Id
    String userId;
    @Id
    String orderId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
