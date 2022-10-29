package com.matrix.Spring.repository;

import com.matrix.Spring.entity.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByHomeView(String homeView);

    List<ProductEntity> findByHomeLatestAndHomeAboutAndHomeView(String homeLatest, String homeAbout,String homeView);

    void deleteById(Long id);

    @Modifying
    @Transactional
    Long deleteByHomeLatest(String homeLatest);

    List<ProductEntity> findByhomeAboutQuestion(String homeAboutQuestion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE ProductEntity set homeView=:homeView where id=:id")
    int updateHomeElementsHomeView(Long id, String homeView);

    List<ProductEntity> findByOrderByHomeScoreAsc();

    List<ProductEntity> findByHomeLatestOrderByHomeScore(String homeLatest);

    List<ProductEntity> findAllByOrderByIdDesc(Sort sort);

    List<ProductEntity> findAllByOrderByHomeCreativeAsc(Sort sort);

    @Query(value = "SELECT p FROM ProductEntity p")
    List<ProductEntity> findAllByOrderByHomeLatestAsc(Sort sort);

    @Query(value = "SELECT p FROM ProductEntity p")
    List<ProductEntity> findAllPageable(Pageable page);

}
