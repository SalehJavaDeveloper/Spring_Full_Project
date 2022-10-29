package com.matrix.Spring.service;

import com.matrix.Spring.dto.CategoryDto;

import java.util.List;

public interface CategoryImpl {

    List<CategoryDto> sortByInsertDate();

   CategoryDto saveCategory(String categoryName);
}
