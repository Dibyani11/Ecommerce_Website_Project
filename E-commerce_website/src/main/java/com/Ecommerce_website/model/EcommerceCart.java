package com.Ecommerce_website.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ECOMMERCE_CART")
public class EcommerceCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CART_ID")
	private long cartId;
	
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
	@OneToMany(mappedBy = "ecommerceCart")
	private List<EcommerceItems> ecommerceItems;

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public List<EcommerceItems> getEcommerceItems() {
		return ecommerceItems;
	}

	public void setEcommerceItems(List<EcommerceItems> ecommerceItems) {
		this.ecommerceItems = ecommerceItems;
	}
}
