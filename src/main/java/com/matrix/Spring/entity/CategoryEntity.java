package com.matrix.Spring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "category")
@Getter
@Setter
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "category_name", columnDefinition = "TEXT")
    private String categoryName;

    @Column(name = "insert_date", columnDefinition = "DATE")
    private LocalDate insertDate = LocalDate.now();
}
