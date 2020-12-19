package com.rbc.interview.user.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "wishlist")
@IdClass(WishListId.class)
public class UserWishList {
    @Id
    String userId;
    @Id
    String itemId;

    public String getUserId() {
        return userId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

}
