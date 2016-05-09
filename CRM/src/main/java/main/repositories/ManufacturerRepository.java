package main.repositories;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import db.DatabaseConnection;
import main.models.Manufacturer;

public class ManufacturerRepository extends DatabaseConnection {

	public List<Manufacturer> getManufacturers() {

		try {
			
			cb = em.getCriteriaBuilder();
			CriteriaQuery<Manufacturer> q = cb.createQuery(Manufacturer.class);
			Root<Manufacturer> c = q.from(Manufacturer.class);
			q.select(c);
			List<Manufacturer> s = em.createQuery(q).getResultList();
			
			return s;
		} 
		catch (Exception e) {
			throw e;
		}
		
	}
	

	public static Integer createManufacturer(Manufacturer manufacturer)
	{
		try {
						
			em.getTransaction().begin();
			em.persist(manufacturer);
			em.getTransaction().commit();
			Integer id = manufacturer.getId();
			return id;
		} catch (Exception e) {
			//so the front end knows that something went wrong
			return -1;
			//throw e;
			// TODO: handle exception
		}
		
	}
	

	public static boolean updateManufacturer(Manufacturer manufacturer) {

		try {
			Manufacturer currentManufacturer = em.find(Manufacturer.class, manufacturer.getId());

			em.getTransaction().begin();
			
			currentManufacturer.setName(manufacturer.getName());
			
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			return false;
			//throw e;
			// TODO: handle exception
		}
		
	}

	public static Boolean deleteManufacturer(Integer id) {
		try {
			
			Manufacturer manufacturer = em.find(Manufacturer.class, id);
			em.getTransaction().begin();
			em.remove(manufacturer);
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			return false;
			
		}
		
	}

	
}
