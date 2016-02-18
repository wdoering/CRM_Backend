package main.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity 
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	@Column(nullable = false)
	private String description;
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private ProductSizeCategory productSizeCategory;
	
	//brandId
	@OneToOne
	@JoinColumn(name = "manufacturerId", unique=true, nullable=false, updatable=false)
	private Manufacturer manufacturerId;
	
	
	//	TODO: create an FK to a product_type table: shoe, shirt TO BE CREATED
	@Column(nullable = false)
	private Integer typeId;
	
	public Product(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductSizeCategory getProductSizeCategory() {
		return productSizeCategory;
	}

	public void setProductSizeCategory(ProductSizeCategory productSizeCategory) {
		this.productSizeCategory = productSizeCategory;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
}
