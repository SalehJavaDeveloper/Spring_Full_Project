package com.matrix.Spring.service.impl;

import com.matrix.Spring.dto.ProductDTO;
import com.matrix.Spring.entity.ProductEntity;
import com.matrix.Spring.exception.GetBadRequestException;
import com.matrix.Spring.exception.GetForbiddenException;
import com.matrix.Spring.exception.NotFoundException;
import com.matrix.Spring.mapper.ProductMapper;
import com.matrix.Spring.repository.ProductDao;
import com.matrix.Spring.repository.ProductRepository;
import com.matrix.Spring.repository.RepositoryManager;
import com.matrix.Spring.service.ProductserviceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService implements ProductserviceImpl {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private final ProductDao productDao;
    private final RepositoryManager repositoryManager;

    @Override
    public ProductDTO getProductsById(Long id) {
        ProductEntity productEntity = getEntity(id);
        return productMapper.toDTO(productEntity);
    }

    public List<ProductDTO> findByHomeView(String homeView) {
        List<ProductEntity> byHomeView = productRepository.findByHomeView(homeView);
        return productMapper.toDTOList(byHomeView);
    }

    @Override
    public List<ProductDTO> findByhomeAboutQuestion(String homeAboutQuestion) {
        List<ProductEntity> byhomeAboutQuestion = productRepository.findByhomeAboutQuestion(homeAboutQuestion);
        return productMapper.toDTOList(byhomeAboutQuestion);
    }

    public List<ProductDTO> getProductByHomeLatestAndHomeAbout(String homeLatest, String homeAbout,String homeView) {
        List<ProductEntity> byHomeLatestAndHomeAbout = productDao.getProductByHomeLatestAndHomeAbout(homeLatest, homeAbout,homeView);
        if (byHomeLatestAndHomeAbout.isEmpty()) {
            throw new NotFoundException(HttpStatus.NOT_FOUND, 8, String.format("arguments not found."));
        }
        return productMapper.toDTOList(byHomeLatestAndHomeAbout);

    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductEntity> all = productRepository.findAll();
        if (all.isEmpty()) {
            throw new NotFoundException(HttpStatus.BAD_REQUEST, 6, String.format("Data not found."));
        }
        return productMapper.toDTOList(all);
    }

    public void deleteById(Long id) {
        ProductDTO productsById = getProductsById(id);
        if (productsById == null) {
            throw new GetForbiddenException(HttpStatus.FORBIDDEN, 4, String.format("id %s üzrə məlumat tapılmadı.", id));
        }
        productRepository.deleteById(id);
    }

    public void deleteAllByHomeAboutContains() {
        productRepository.deleteAll();
    }

    @Override
    public List<ProductDTO> saveAllData(List<ProductDTO> productDTOS) {
        List<ProductEntity> entityList = productMapper.fromDTOList(productDTOS);
        List<ProductEntity> entityList1 = productRepository.saveAll(entityList);
        if (entityList1.isEmpty()) {
            throw new GetBadRequestException(HttpStatus.BAD_REQUEST, 7, String.format("Data not found."));
        }
        return productMapper.toDTOList(entityList1);
    }

    @Override
    public Long deleteByHomeLatest(String homeLatest) {
        return productRepository.deleteByHomeLatest(homeLatest);
    }

    @Override
    public int updateById(Long id, String homeView) {
        ProductDTO productId = getProductsById(id);
        if (productId == null) {
            throw new GetBadRequestException(HttpStatus.BAD_REQUEST, 3, String.format("id %s üzrə məlumat tapılamadı.", id));
        }
        return productRepository.updateHomeElementsHomeView(id, homeView);
    }

    @Override
    public ProductDTO updateById2(Long id, String homeAbout) {
        ProductEntity entity = getEntity(id);
        entity.setHomeAbout(homeAbout);
        ProductEntity saveEntity = productRepository.save(entity);
        return productMapper.toDTO(saveEntity);
    }

    public List<ProductDTO> findByOrderByHomeScoreAsc() {
        List<ProductEntity> byOrderByHomeScoreAsc = productRepository.findByOrderByHomeScoreAsc();
        return productMapper.toDTOList(byOrderByHomeScoreAsc);
    }

    public List<ProductDTO> findByHomeLatestOrderByHomeScore(String homeLatest) {
        List<ProductEntity> byhomeLatestOrderByHomeScore = productRepository.findByHomeLatestOrderByHomeScore(homeLatest);
        return productMapper.toDTOList(byhomeLatestOrderByHomeScore);
    }

    public List<ProductDTO> findAllDesc() {
        List<ProductEntity> homeLatest = productRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        return productMapper.toDTOList(homeLatest);
    }

    ProductEntity getEntity(Long id){
       return productRepository.findById(id).orElseThrow(() ->
                new NotFoundException(HttpStatus.NOT_FOUND, 5, String.format("id %s üzrə nəticə tapılmadı.", id)));
    }

    public List<ProductDTO> sortByHomeView(){
        List<ProductEntity> homeView = productRepository.findAllByOrderByIdDesc(Sort.by(Sort.Direction.ASC, "id"));
        return productMapper.toDTOList(homeView);
    }

    public List<ProductDTO> SortWithHomeLatestAsc(){
        List<ProductEntity> homeLatest = productRepository.findAllByOrderByHomeLatestAsc(JpaSort.unsafe(Sort.Direction.DESC, "homeScore * homeScore"));
    return productMapper.toDTOList(homeLatest);
    }

    public List<ProductDTO> findAllPageable(Pageable page){
        List<ProductEntity> allPageable = productRepository.findAllPageable(page);
        return productMapper.toDTOList(allPageable);
    }

    public Page<ProductEntity> findProductWithPagableAndSorting(int offset, int pagesize,String field){
        return null;
                //productRepository.findAll(PageRequest.of(offset, pagesize).withSort(Sort.by(field)));
    }

    @Override
    public List<ProductDTO> findHomeScoreWithSortAndPagable(int limit) {
    var limitedProducts = repositoryManager.getProductLimitter(limit);
    return productMapper.toDTOList(limitedProducts);
    }

    public List<ProductDTO> sortByHomeCreative(){
        List<ProductEntity> homeCreative = productRepository.findAllByOrderByHomeCreativeAsc(JpaSort.unsafe(Sort.Direction.ASC, "homeCreative"));
        return productMapper.toDTOList(homeCreative);
    }
}
