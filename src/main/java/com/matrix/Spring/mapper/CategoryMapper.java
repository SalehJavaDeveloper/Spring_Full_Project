package com.matrix.Spring.mapper;

import com.matrix.Spring.dto.CategoryDto;
import com.matrix.Spring.dto.ProductDTO;
import com.matrix.Spring.entity.CategoryEntity;
import com.matrix.Spring.entity.ProductEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;

    @Component
    @Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
            injectionStrategy = InjectionStrategy.CONSTRUCTOR
    )
public interface CategoryMapper {

    CategoryDto toDTO(CategoryEntity productEntity);

    List<CategoryDto> toDTOList(List<CategoryEntity> entities);

    List<CategoryEntity> fromDTOList(List<CategoryDto> dtoList);

    CategoryEntity fromDTO(CategoryDto dto);
}
