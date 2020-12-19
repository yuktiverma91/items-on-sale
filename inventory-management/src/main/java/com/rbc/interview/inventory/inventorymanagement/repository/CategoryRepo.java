package com.rbc.interview.inventory.inventorymanagement.repository;

import com.rbc.interview.inventory.inventorymanagement.models.Category;
import com.rbc.interview.inventory.inventorymanagement.models.CategoryItemMapping;
import com.rbc.interview.inventory.inventorymanagement.models.ItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Jpa21Utils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo  extends JpaRepository<Category, String> {


}
