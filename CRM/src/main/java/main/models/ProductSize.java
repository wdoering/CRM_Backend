package main.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class ProductSize implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	Integer id;
	
	@Column(nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(name = "productSizeCategoryId")
	private ProductSizeCategory productSizeCategory;
	
	

	public Integer getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductSizeCategory getProductSizeCategory() {
		return productSizeCategory;
	}

	public void setProductSizeCategory(ProductSizeCategory productSizeCategory) {
		this.productSizeCategory = productSizeCategory;
	}


}
