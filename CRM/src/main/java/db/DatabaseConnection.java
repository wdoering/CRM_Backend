package db;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

public class DatabaseConnection {
	protected static EntityManagerFactory emf;
	protected static EntityManager em;
	protected static CriteriaBuilder cb;
	
	public DatabaseConnection(){
		emf = Persistence.createEntityManagerFactory("CRM");
		em = emf.createEntityManager();
		cb = em.getCriteriaBuilder();
	}
	
	public static CriteriaBuilder connect(){
		
		
		try {
			
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("CRM");
			EntityManager em = emf.createEntityManager();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
			
			return cb;
		} catch (Exception e) {
			throw e;
		}
		
		
	};
	public static void connectionClose(CriteriaBuilder cb){}
	
	
	
}
