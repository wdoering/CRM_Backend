package main.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	@ManyToOne
	@JoinColumn(name = "manufacturerId", nullable=false, updatable=false)
	private Manufacturer manufacturer;

	public Integer getId(){
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

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	//	TODO: create an FK to a product_type table: shoe, shirt 
	@Column(nullable = false)
	private Integer typeId;
	
	// TODO: FK to price table
	public Product(){
		
	}

	
}
