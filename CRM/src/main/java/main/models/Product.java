package main.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "sizeCategoryId", nullable=false)
	private ProductSizeCategory productSizeCategory;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "manufacturerId", nullable=false)
	private Manufacturer manufacturer;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name = "productTypeId", nullable=false)
	private ProductType productType;
	
	
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
	
	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType ProductType) {
		this.productType = ProductType;
	}

	// TODO: FK to price table
	public Product(){
		
	}

	
}
