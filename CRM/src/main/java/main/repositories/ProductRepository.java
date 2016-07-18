package main.repositories;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import main.models.Product;
import main.models.ProductSizeCategory;
import db.DatabaseConnection;

public class ProductRepository extends DatabaseConnection {

	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		try {

			cb = em.getCriteriaBuilder();
			CriteriaQuery<Product> q = cb.createQuery(Product.class);
			Root<Product> p = q.from(Product.class);
			q.select(p);
			List<Product> products = em.createQuery(q).getResultList();

			return products;

		} catch (Exception e) {
			throw e;
		}
	}

	public static Integer createProduct(Product product) {
		try {

			em.getTransaction().begin();
			em.persist(product);
			em.getTransaction().commit();
			Integer id = product.getId();
			return id;
		} catch (Exception e) {
			// so the front end knows that something went wrong
			throw e;
			// throw e;
			// TODO: handle exception
		}
	}

	public static Boolean updateProduct(Product product) {
		try {
			Product currentProduct = em.find(Product.class, product.getId());
			
			em.getTransaction().begin();
			
			currentProduct.setDescription(product.getDescription());
//			ProductSizeCategory currentPSC = em.find(ProductSizeCategory.class, product.getProductSizeCategory().getId());
//			currentProduct.setProductSizeCategory(currentPSC);
			currentProduct.setProductSizeCategory(product.getProductSizeCategory());
			
			currentProduct.setManufacturer(product.getManufacturer());
			currentProduct.setProductType(product.getProductType());
			
			em.getTransaction().commit();
			
			return true;

		} catch (Exception e) {
			
			throw e;
			// TODO: handle exception
		}

	}

	public static Boolean deleteProduct(Integer id) {
		try {

			Product product = em.find(Product.class, id);
			em.getTransaction().begin();
			em.remove(product);
			em.getTransaction().commit();
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
}
