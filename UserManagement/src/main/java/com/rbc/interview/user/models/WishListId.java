package com.rbc.interview.user.models;

import java.io.Serializable;

public class WishListId implements Serializable {

        private String userId;

        private String itemId;

        // default constructor

       public WishListId(String userId, String itemId) {
           this.userId = userId;
           this.itemId = itemId;
       }

        // equals() and hashCode()
    }


