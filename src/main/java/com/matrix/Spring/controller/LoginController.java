package com.matrix.Spring.controller;
import com.matrix.Spring.dto.ProductDTO;
import com.matrix.Spring.entity.ProductEntity;
import com.matrix.Spring.service.ProductserviceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(value = "product info")
@RequestMapping("/login")
public class LoginController {
    private final ProductserviceImpl productService;

    @GetMapping(value = "/get-products_by_id/{id}")
    public ProductDTO getProductsById(@PathVariable("id") Long id) {
       return productService.getProductsById(id);
    }

    @GetMapping("/find-by-home-about-question/{homeAboutQuestion}")
    public List<ProductDTO> findByhomeAboutQuestion(@PathVariable("homeAboutQuestion") String homeAboutQuestion){
       return  productService.findByhomeAboutQuestion(homeAboutQuestion);
    }
    @GetMapping("/findByThreeCategory")
    public List<ProductDTO> getProductByHomeLatestAndHomeAbout(@RequestParam(required = false) String homeLatest,
                                                               @RequestParam(required = false) String homeAbout,
                                                               @RequestParam(required = false) String homeView){
       return productService.getProductByHomeLatestAndHomeAbout(homeLatest, homeAbout,homeView);
    }

    @GetMapping("/find-all-elements")
    public List<ProductDTO> findAllColumns(){
        return productService.findAll();
    }

    @GetMapping("/get-info-home_view/{homeView}")
    public List<ProductDTO> findByHomeView(@PathVariable("homeView") String homeView) {
      return productService.findByHomeView(homeView);
    }

    @ApiOperation(value = "Get a product by id", notes = "Returns a product as per the id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "Not found - The product was not found")
    })
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        productService.deleteById(id);
    }

    @DeleteMapping("/delete all")
    public void deleteAllByHomeAboutContains() {
        productService.deleteAllByHomeAboutContains();
    }

    @PostMapping(value = "/save-data")
    public List<ProductDTO> saveAllData(List<ProductDTO> productDTOS){
        return productService.saveAllData(productDTOS);
    }

    @DeleteMapping(value = "/delete-column/{homeLatest}")
    public Long deleteByHomeLatest(@PathVariable("homeLatest")String homeLatest){
        return productService.deleteByHomeLatest(homeLatest);
    }

    @PutMapping("/update-by-id/{id}/{homeView}")
    public int updateById(@PathVariable("id") Long id, @PathVariable("homeView") String homeView){
        return productService.updateById(id, homeView);
    }

    @PutMapping("gpn/update-by-id-query/{id}/{homeAbout}")
    public ProductDTO updateById2(Long id, String homeAbout){
    return productService.updateById2(id,homeAbout);
    }

    @ApiOperation(value = "Asc column on database",response = ProductEntity.class)
    @GetMapping("/ascScore")
    public List<ProductDTO> findByOrderByHomeScoreAsc(){
        return productService.findByOrderByHomeScoreAsc();
    }

    @GetMapping("/order-by-homeLatest/{homeLatest}")
    public List<ProductDTO> findByHomeLatestOrderByHomeScore(String homeLatest){
    return productService.findByHomeLatestOrderByHomeScore(homeLatest);
    }//todooo

    @GetMapping("/descScore")
    public List<ProductDTO> findAllDesc(){return productService.findAllDesc();}

    @GetMapping("/sort-by/home-view")
    public List<ProductDTO> sortByHomeView(){
      return productService.sortByHomeView();
    }

    @GetMapping(value = "/sort-by/home-latest")
    public List<ProductDTO> SortWithHomeLatestAsc(){
       return productService.SortWithHomeLatestAsc();
    }

    @GetMapping("/sort/pageable")
    public List<ProductDTO> findAllPageable(@PathVariable Pageable page){
       return productService.findAllPageable(page);
    }

    @GetMapping("/pagandsort/{offset}/{pageSize}/{column}")
    public Page<ProductEntity> findProductWithPagableAndSorting(@PathVariable int offset,
                                                                @PathVariable int pageSize,
                                                                @PathVariable String column){
    return productService.findProductWithPagableAndSorting(offset,pageSize,column);
    }

    @GetMapping(value = "/sort/homeCraetive")
    public List<ProductDTO> sortByHomeCreative(){
       return productService.sortByHomeCreative();
    }

    @GetMapping(value = "/limit/{limit}")
    public List<ProductDTO> findHomeScoreWithSortAndPagable(@PathVariable int limit){
       return productService.findHomeScoreWithSortAndPagable(limit);
    }

}