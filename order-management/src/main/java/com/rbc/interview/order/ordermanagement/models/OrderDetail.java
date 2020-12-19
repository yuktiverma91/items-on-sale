package com.rbc.interview.order.ordermanagement.models;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name = "orderDetail")
@IdClass(OrderItemId.class)
public class OrderDetail {
    @Id
    String orderId;
    @Id
    String itemId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
