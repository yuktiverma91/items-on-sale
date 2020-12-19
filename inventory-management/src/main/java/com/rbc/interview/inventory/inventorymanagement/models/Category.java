package com.rbc.interview.inventory.inventorymanagement.models;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    String categoryId;
    String categoryName;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "post_tags",
            joinColumns = { @JoinColumn(name = "categoryId") },
            inverseJoinColumns = { @JoinColumn(name = "categoryId") })


    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
