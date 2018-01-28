package com.nick.dao;

import com.nick.model.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll();

    Category findById(Long cId);
}
