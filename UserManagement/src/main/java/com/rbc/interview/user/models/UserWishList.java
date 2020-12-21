package com.rbc.interview.user.models;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "wishlist")

public class UserWishList {

    @Id
    String itemId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

}
