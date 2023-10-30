package com.Ecommerce_website.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce_website.model.EcommerceCategory;

public interface EcommerceCategoryRepository extends JpaRepository<EcommerceCategory, Long> {

	EcommerceCategory findByNameAndEcommerceVendorVendorId(String name, long vendorId);

	EcommerceCategory findById(long id);

	List<EcommerceCategory> findByEcommerceVendorVendorId(long vendorId);
}
