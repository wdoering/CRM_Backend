package main.controllers;
import java.util.List;

import main.models.Manufacturer;
import main.repositories.ManufacturerRepository;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ManufacturerController {
	 

	    @RequestMapping(value="/manufacturer", method=RequestMethod.GET)
	    public List<Manufacturer> manufacturer(@RequestParam(value="id", defaultValue="0") Integer id) {

	    	ManufacturerRepository cr = new ManufacturerRepository();
	        List<Manufacturer> manufacturerList = cr.getManufacturers();
	    	return manufacturerList;
	
	    }
	    
	    @RequestMapping(value="/manufacturer", method=RequestMethod.POST)
	    public Integer createManufacturer(@RequestBody Manufacturer manufacturer) {
	    	
	    	Integer retorno = ManufacturerRepository.createManufacturer(manufacturer);
	    	return retorno;
	    }
	    
	    @RequestMapping(value="/manufacturer", method=RequestMethod.PUT)
	    public Boolean editManufacturer(@RequestBody Manufacturer manufacturer) {
	    	
	    	Boolean retorno = ManufacturerRepository.updateManufacturer(manufacturer);
			return retorno;
	
	    }
	    
	    @RequestMapping(value="/manufacturer", method=RequestMethod.DELETE)
	    public Boolean deleteManufacturer(@RequestParam(value="id") Integer id) {

	    	Boolean retorno = ManufacturerRepository.deleteManufacturer(id);
	        return retorno;
	    	
	
	    }
	    
}
