package com.rbc.interview.inventory.inventorymanagement.models;

import java.io.Serializable;

public class ItemId implements Serializable {

    private String categoryId;
    private String itemId;

    public ItemId(String categoryId, String itemId) {
        this.categoryId = categoryId;
        this.itemId = itemId;
    }
}
