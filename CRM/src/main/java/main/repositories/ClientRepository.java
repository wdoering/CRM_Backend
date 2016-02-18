package main.repositories;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import db.DatabaseConnection;
import main.models.Client;


public class ClientRepository extends DatabaseConnection{

	public List<Client> getClients() {

		try {
			
			cb = em.getCriteriaBuilder();
			CriteriaQuery<Client> q = cb.createQuery(Client.class);
			Root<Client> c = q.from(Client.class);
			q.select(c);
			List<Client> clientes = em.createQuery(q).getResultList();
			
			return clientes;
			
		} 
		catch (Exception e) {
			throw e;
		}
		
	}
	
	public static Integer createClient(Client client)
	{
		try {
						
			em.getTransaction().begin();
			em.persist(client);
			em.getTransaction().commit();
			Integer id = client.getId();
			return id;
		} catch (Exception e) {
			//so the front end knows that something went wrong
			return -1;
			//throw e;
			// TODO: handle exception
		}
		
	}

	public static boolean updateClient(Client client) {

		try {
			Client currentClient = em.find(Client.class, client.getId());

			em.getTransaction().begin();
			
			currentClient.setCNPJ(client.getCNPJ());
			currentClient.setLegalName(client.getLegalName());
			currentClient.setTradeName(client.getTradeName());
			currentClient.setAddressNumber(client.getAddressNumber());
			currentClient.setCity(client.getCity());
			currentClient.setEmail(client.getEmail());
			currentClient.setNeighborhood(client.getNeighborhood());
			currentClient.setPostalCode(client.getPostalCode());
			currentClient.setPrimaryContactName(client.getPrimaryContactName());
			currentClient.setStateID(client.getStateID());
			currentClient.setStateRegistrationNumber(client.getStateRegistrationNumber());
			currentClient.setStreet(client.getStreet());
			
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			return false;
			//throw e;
			// TODO: handle exception
		}
		
		
		
		
	}

	public static Boolean deleteClient(Integer id) {
		try {
			
			Client client = em.find(Client.class, id);
			em.getTransaction().begin();
			em.remove(client);
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			return false;
			
		}
		
	}
	
	
	
}



