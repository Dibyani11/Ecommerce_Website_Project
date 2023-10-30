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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ECOMMERCE_ORDER")
public class EcommerceOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID")
	private long orderId;
	
	@OneToOne
	@JoinColumn(name = "CART_ID")
	private EcommerceCart ecommerceCart;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private EcommerceUser ecommerceUser;
	
	@ManyToOne
	@JoinColumn(name = "VENDOR_ID")
	private EcommerceVendor ecommerceVendor;
	
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
	@Column(name = "TRANSACTION_ID")
	private String transactionId;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "CREATED_ON", updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name = "LAST_UPDATED_ON")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedOn;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public EcommerceCart getEcommerceCart() {
		return ecommerceCart;
	}

	public void setEcommerceCart(EcommerceCart ecommerceCart) {
		this.ecommerceCart = ecommerceCart;
	}

	public EcommerceUser getEcommerceUser() {
		return ecommerceUser;
	}

	public void setEcommerceUser(EcommerceUser ecommerceUser) {
		this.ecommerceUser = ecommerceUser;
	}

	public EcommerceVendor getEcommerceVendor() {
		return ecommerceVendor;
	}

	public void setEcommerceVendor(EcommerceVendor ecommerceVendor) {
		this.ecommerceVendor = ecommerceVendor;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
