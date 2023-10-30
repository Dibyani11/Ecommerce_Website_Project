package com.Ecommerce_website.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ECOMMERCE_ITEMS")
public class EcommerceItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITEM_ID")
	private long itemId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "QUANTITY")
	private long quantity;

	@Column(name = "AMOUNT")
	private BigDecimal amount;

	@Column(name = "STATUS")
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "VENDOR_ID")
	private EcommerceVendor ecommerceVendor;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private EcommerceCategory ecommerceCategory;

	@ManyToOne
	@JoinColumn(name = "CART_ID")
	private EcommerceCart ecommerceCart;

	@Column(name = "CREATED_ON", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdOn;

	@Column(name = "LAST_UPDATED_ON", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date lastUpdatedOn;

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public EcommerceVendor getEcommerceVendor() {
		return ecommerceVendor;
	}

	public void setEcommerceVendor(EcommerceVendor ecommerceVendor) {
		this.ecommerceVendor = ecommerceVendor;
	}

	public EcommerceCategory getEcommerceCategory() {
		return ecommerceCategory;
	}

	public void setEcommerceCategory(EcommerceCategory ecommerceCategory) {
		this.ecommerceCategory = ecommerceCategory;
	}

	public EcommerceCart getEcommerceCart() {
		return ecommerceCart;
	}

	public void setEcommerceCart(EcommerceCart ecommerceCart) {
		this.ecommerceCart = ecommerceCart;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}
}
