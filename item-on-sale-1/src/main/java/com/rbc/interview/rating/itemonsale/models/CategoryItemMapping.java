package com.rbc.interview.rating.itemonsale.models;

import javax.persistence.Id;

public class CategoryItemMapping {
    String itemId;

    String categoryId;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
