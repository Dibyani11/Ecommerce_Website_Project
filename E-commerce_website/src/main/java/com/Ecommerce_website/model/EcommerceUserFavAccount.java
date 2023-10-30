package com.Ecommerce_website.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_FAVOURITE_ACCOUNT")
public class EcommerceUserFavAccount {

	@Id
    @Column(name = "USER_ACCOUNT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userAccountId;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "AMOUNT")
    private BigDecimal amount;
    
    @Column(name = "STATUS")
    private boolean status;
    
    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private EcommerceItems ecommerceItems;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private EcommerceUser ecommerceUser;

	public long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(long userAccountId) {
		this.userAccountId = userAccountId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public EcommerceItems getEcommerceItems() {
		return ecommerceItems;
	}

	public void setEcommerceItems(EcommerceItems ecommerceItems) {
		this.ecommerceItems = ecommerceItems;
	}

	public EcommerceUser getEcommerceUser() {
		return ecommerceUser;
	}

	public void setEcommerceUser(EcommerceUser ecommerceUser) {
		this.ecommerceUser = ecommerceUser;
	}
}