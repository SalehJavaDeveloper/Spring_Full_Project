package com.matrix.Spring.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class CategoryDto {

    private Long id;

    private String categoryName;

    private LocalDate insertDate;
}
