package com.Ecommerce_website.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce_website.model.EcommerceOrder;

public interface EcommerceOrderRepository extends JpaRepository<EcommerceOrder, Long> {

	public EcommerceOrder findById(long id);

	public List<EcommerceOrder> findByEcommerceUserUserId(long id);

	public List<EcommerceOrder> findByEcommerceVendorVendorId(long id);

	public EcommerceOrder findByEcommerceVendorVendorIdAndOrderId(long vendorId, long orderId);

	public EcommerceOrder findByEcommerceUserUserIdAndOrderId(long userId, long orderId);
}
