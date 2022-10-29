package com.matrix.Spring.service.impl;

import com.matrix.Spring.dto.CategoryDto;
import com.matrix.Spring.entity.CategoryEntity;
import com.matrix.Spring.mapper.CategoryMapper;
import com.matrix.Spring.repository.CategoryRepository;
import com.matrix.Spring.service.CategoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryImpl {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> sortByInsertDate() {
        List<CategoryEntity> insertDate = categoryRepository.findAllByOrderByInsertDateDesc(Sort.by(Sort.Direction.DESC, "insertDate"));
        return categoryMapper.toDTOList(insertDate);
    }

    public CategoryDto saveCategory(String categoryName){
        CategoryEntity entity = new CategoryEntity();
        entity.setInsertDate(LocalDate.now());
        entity.setCategoryName(categoryName);
        CategoryEntity categoryEntities1 = categoryRepository.save(entity);
        return categoryMapper.toDTO(categoryEntities1);
    }
}
