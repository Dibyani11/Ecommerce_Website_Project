package com.Ecommerce_website.DTO;

import java.math.BigDecimal;

public class EcommerceCartResDTO {

	private long cartId;
	private BigDecimal amount;
	
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
}