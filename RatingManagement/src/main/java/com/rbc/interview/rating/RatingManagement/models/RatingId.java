package com.rbc.interview.rating.RatingManagement.models;

import java.io.Serializable;

public class RatingId implements Serializable {
    String userId;
    String itemId;

    public RatingId(String userId, String itemId) {
        this.userId = userId;
        this.itemId = itemId;
    }
}
