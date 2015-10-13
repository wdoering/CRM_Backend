package main.controllers;
import java.util.List;

import main.models.Client;
import main.repositories.ClientRepository;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController {
	 

	    @RequestMapping(value="/client", method=RequestMethod.GET)
	    public List<Client> client(@RequestParam(value="id", defaultValue="0") Integer id) {

	    	ClientRepository cr = new ClientRepository();
	        List<Client> clientList = cr.getClients();
	    	return clientList;
	
	    }
	    
	    @RequestMapping(value="/client", method=RequestMethod.POST)
	    public Boolean createClient(@RequestBody Client client) {
	    	
	    	Boolean retorno = ClientRepository.createClient(client);
	    	return retorno;
	    }
	    
	    @RequestMapping(value="/client", method=RequestMethod.PUT)
	    public Boolean editClient(@RequestBody Client client) {
	    	
	    	Boolean retorno = ClientRepository.updateClient(client);
			return retorno;
	
	    }
	    
	    @RequestMapping(value="/client", method=RequestMethod.DELETE)
	    public Boolean deleteClient(@RequestParam(value="id") Integer id) {

	    	Boolean retorno = ClientRepository.deleteClient(id);
	        return retorno;
	    	
	
	    }
	    
}
