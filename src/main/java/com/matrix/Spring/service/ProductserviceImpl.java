package com.matrix.Spring.service;

import com.matrix.Spring.dto.ProductDTO;
import com.matrix.Spring.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductserviceImpl{
    ProductDTO getProductsById(Long id);
    List<ProductDTO> findByHomeView(String homeView);
    List<ProductDTO> getProductByHomeLatestAndHomeAbout(String homeLatest, String homeAbout,String homeView);
    List<ProductDTO> findByhomeAboutQuestion(String homeAboutQuestion);
     List<ProductDTO> findAll();
     void deleteById(Long id);
     void deleteAllByHomeAboutContains();
     List<ProductDTO> saveAllData(List<ProductDTO> entityList);
    Long deleteByHomeLatest(String homeLatest);
    int updateById(Long id, String homeView);
    ProductDTO updateById2(Long id,String homeAbout);
    List<ProductDTO> findByOrderByHomeScoreAsc();
    List<ProductDTO> findByHomeLatestOrderByHomeScore(String homeLatest);
    List<ProductDTO> findAllDesc();
    List<ProductDTO> sortByHomeView();
    List<ProductDTO> SortWithHomeLatestAsc();
    List<ProductDTO> sortByHomeCreative();
    List<ProductDTO> findAllPageable(Pageable page);
    Page<ProductEntity> findProductWithPagableAndSorting(int offset, int pagesize, String field);

    List<ProductDTO> findHomeScoreWithSortAndPagable(int limit);
}
