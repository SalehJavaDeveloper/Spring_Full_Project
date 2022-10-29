package com.matrix.Spring.repository;

import com.matrix.Spring.entity.CategoryEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
     List<CategoryEntity> findAllByOrderByInsertDateDesc(Sort sort);

}
