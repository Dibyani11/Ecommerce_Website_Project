package com.Ecommerce_website.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce_website.model.EcommerceItems;

public interface EcommerceItemsRepository extends JpaRepository<EcommerceItems, Long>{

	EcommerceItems findByNameAndEcommerceVendorVendorId(String name, long vendorId);

	EcommerceItems findById(long id);
	
	List<EcommerceItems> findByEcommerceCategoryCategoryId(long categoryId);

	EcommerceItems findByNameAndEcommerceCategoryCategoryId(String name, long categoryId);

}
