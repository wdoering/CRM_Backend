package main.controllers;

import java.util.List;

import main.models.ProductSizeCategory;
import main.repositories.ProductSizeCategoryRepository;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductSizeCategoryController {


    @RequestMapping(value="/productsizecategory", method=RequestMethod.GET)
    public List<ProductSizeCategory> productType(@RequestParam(value="id", defaultValue="0") Integer id) {

    	ProductSizeCategoryRepository pscr = new ProductSizeCategoryRepository();
        List<ProductSizeCategory> productTypeList = pscr.getProductSizeCategories();
    	return productTypeList;

    }
    
    @RequestMapping(value="/productsizecategory", method=RequestMethod.POST)
    public Integer createProductSizeCategory(@RequestBody ProductSizeCategory productType) {
    	
    	Integer retorno = ProductSizeCategoryRepository.createProductSizeCategory(productType);
    	return retorno;
    }
    
    @RequestMapping(value="/productsizecategory", method=RequestMethod.PUT)
    public Boolean editProductSizeCategory(@RequestBody ProductSizeCategory productType) {
    	
    	Boolean retorno = ProductSizeCategoryRepository.updateProductSizeCategory(productType);
		return retorno;

    }
    
    @RequestMapping(value="/productsizecategory", method=RequestMethod.DELETE)
    public Boolean deleteProductSizeCategory(@RequestParam(value="id") Integer id) {

    	Boolean retorno = ProductSizeCategoryRepository.deleteProductSizeCategory(id);
        return retorno;
    	

    }
    
}
