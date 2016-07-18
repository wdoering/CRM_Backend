package main.repositories;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import main.models.ProductSizeCategory;
import db.DatabaseConnection;

public class ProductSizeCategoryRepository extends DatabaseConnection {

	public List<ProductSizeCategory> getProductSizeCategories() {

		try {

			cb = em.getCriteriaBuilder();
			CriteriaQuery<ProductSizeCategory> q = cb.createQuery(ProductSizeCategory.class);
			Root<ProductSizeCategory> psc = q.from(ProductSizeCategory.class);
			q.select(psc);
			List<ProductSizeCategory> productSizeCategorys = em.createQuery(q).getResultList();

			return productSizeCategorys;

		} catch (Exception e) {
			throw e;
		}
	}

	public static Integer createProductSizeCategory(ProductSizeCategory productSizeCategory) {
		try {

			em.getTransaction().begin();
			em.persist(productSizeCategory);
			em.getTransaction().commit();
			Integer id = productSizeCategory.getId();
			return id;
		} catch (Exception e) {

			throw e;
			
		}
	}

	public static Boolean updateProductSizeCategory(ProductSizeCategory productSizeCategory) {
		try {
			ProductSizeCategory currentProductSizeCategory = em.find(ProductSizeCategory.class, productSizeCategory.getId());

			em.getTransaction().begin();
			currentProductSizeCategory.setDescription(currentProductSizeCategory.getDescription());
			em.getTransaction().commit();

			return true;

		} catch (Exception e) {
			return false;
			// throw e;
			// TODO: actually throw the exception,
			
		}

	}

	public static Boolean deleteProductSizeCategory(Integer id) {
		try {

			ProductSizeCategory productSizeCategory = em.find(ProductSizeCategory.class, id);
			em.getTransaction().begin();
			em.remove(productSizeCategory);
			em.getTransaction().commit();
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
}
