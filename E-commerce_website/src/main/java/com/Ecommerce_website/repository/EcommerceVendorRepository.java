package com.Ecommerce_website.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce_website.model.EcommerceVendor;

public interface EcommerceVendorRepository extends JpaRepository<EcommerceVendor, Long>{

	EcommerceVendor findByEmail(String email);
	
	EcommerceVendor findById(long id);
	
}
