package com.matrix.Spring.mapper;

import com.matrix.Spring.dto.ProductDTO;
import com.matrix.Spring.entity.ProductEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface ProductMapper {

    ProductDTO toDTO(ProductEntity productEntity);

    List<ProductDTO> toDTOList(List<ProductEntity> entities);

    List<ProductEntity> fromDTOList(List<ProductDTO> dtoList);

    ProductEntity fromDTO(ProductDTO dto);

}
