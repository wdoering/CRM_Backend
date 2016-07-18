package main.repositories;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import main.models.ProductType;
import db.DatabaseConnection;

public class ProductTypeRepository extends DatabaseConnection {

	public List<ProductType> getProductTypes() {
		// TODO Auto-generated method stub
		try {

			cb = em.getCriteriaBuilder();
			CriteriaQuery<ProductType> q = cb.createQuery(ProductType.class);
			Root<ProductType> p = q.from(ProductType.class);
			q.select(p);
			List<ProductType> productTypes = em.createQuery(q).getResultList();

			return productTypes;

		} catch (Exception e) {
			throw e;
		}
	}

	public static Integer createProductType(ProductType productType) {
		try {

			em.getTransaction().begin();
			em.persist(productType);
			em.getTransaction().commit();
			Integer id = productType.getId();
			return id;
		} catch (Exception e) {
			// so the front end knows that something went wrong
			return -1;
			// throw e;
			// TODO: handle exception
		}
	}

	public static Boolean updateProductType(ProductType productType) {
		try {
			ProductType currentProductType = em.find(ProductType.class, productType.getId());

			em.getTransaction().begin();

			currentProductType.setDescription(productType.getDescription());
			em.getTransaction().commit();

			return true;

		} catch (Exception e) {
			return false;
			// throw e;
			// TODO: handle exception
		}

	}

	public static Boolean deleteProductType(Integer id) {
		try {

			ProductType productType = em.find(ProductType.class, id);
			em.getTransaction().begin();
			em.remove(productType);
			em.getTransaction().commit();
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	
}
