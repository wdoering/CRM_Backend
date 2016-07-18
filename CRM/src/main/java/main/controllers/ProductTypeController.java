package main.controllers;

import java.util.List;

import main.models.ProductType;
import main.repositories.ProductTypeRepository;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductTypeController {


    @RequestMapping(value="/producttype", method=RequestMethod.GET)
    public List<ProductType> productType(@RequestParam(value="id", defaultValue="0") Integer id) {

    	ProductTypeRepository cr = new ProductTypeRepository();
        List<ProductType> productTypeList = cr.getProductTypes();
    	return productTypeList;

    }
    
    @RequestMapping(value="/producttype", method=RequestMethod.POST)
    public Integer createProductType(@RequestBody ProductType productType) {
    	
    	Integer retorno = ProductTypeRepository.createProductType(productType);
    	return retorno;
    }
    
    @RequestMapping(value="/producttype", method=RequestMethod.PUT)
    public Boolean editProductType(@RequestBody ProductType productType) {
    	
    	Boolean retorno = ProductTypeRepository.updateProductType(productType);
		return retorno;

    }
    
    @RequestMapping(value="/producttype", method=RequestMethod.DELETE)
    public Boolean deleteProductType(@RequestParam(value="id") Integer id) {

    	Boolean retorno = ProductTypeRepository.deleteProductType(id);
        return retorno;
    	

    }
    
}
