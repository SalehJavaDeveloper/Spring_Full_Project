package com.matrix.Spring.controller;

import com.matrix.Spring.dto.CategoryDto;
import com.matrix.Spring.service.impl.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/insertDate")
    public List<CategoryDto> sortByInsertDate() {
        return categoryService.sortByInsertDate();
    }

    @PostMapping("/save/mycategory/{categoryName}")
    public CategoryDto saveCategory(@PathVariable("categoryName") String categoryName){
      return categoryService.saveCategory(categoryName);
    }
}
