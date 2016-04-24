package main.controllers;
import java.util.List;

import main.models.Product;
import main.repositories.ProductRepository;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @RequestMapping(value="/product", method=RequestMethod.GET)
    public List<Product> product(@RequestParam(value="id", defaultValue="0") Integer id) {
    	try {
    		ProductRepository pr = new ProductRepository();
            List<Product> productList = pr.getProducts();
        	return productList;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.getMessage());
			return null;
		}
    	

    }
    
    @RequestMapping(value="/product", method=RequestMethod.POST)
    public Integer createProduct(@RequestBody Product product) {
    	
    	Integer retorno = ProductRepository.createProduct(product);
    	return retorno;
    }
    
    @RequestMapping(value="/product", method=RequestMethod.PUT)
    public Boolean editProduct(@RequestBody Product product) {
    	
    	Boolean retorno = ProductRepository.updateProduct(product);
		return retorno;

    }
    
    @RequestMapping(value="/product", method=RequestMethod.DELETE)
    public Boolean deleteProduct(@RequestParam(value="id") Integer id) {

    	Boolean retorno = ProductRepository.deleteProduct(id);
        return retorno;
    }
    
    
    
}
