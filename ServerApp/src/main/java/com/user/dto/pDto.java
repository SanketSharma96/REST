package com.user.dto;



import java.io.Serializable;


public class pDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String productName;
	private Double unitPrice;
	private String category;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	
}

