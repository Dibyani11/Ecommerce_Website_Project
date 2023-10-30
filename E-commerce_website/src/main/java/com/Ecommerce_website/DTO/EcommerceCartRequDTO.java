package com.Ecommerce_website.DTO;

import java.math.BigDecimal;
import java.util.List;

import com.Ecommerce_website.model.EcommerceItems;

public class EcommerceCartRequDTO {

	private long cartId;
	private BigDecimal amount;
	private  List<EcommerceItems> itemId;

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
	public List<EcommerceItems> getItemId() {
		return itemId;
	}
	public void setItemId(List<EcommerceItems> itemId) {
		this.itemId = itemId;
	}	
	
}
