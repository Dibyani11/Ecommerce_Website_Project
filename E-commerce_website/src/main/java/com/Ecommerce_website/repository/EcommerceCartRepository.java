package com.Ecommerce_website.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce_website.model.EcommerceCart;

public interface EcommerceCartRepository extends JpaRepository<EcommerceCart, Long>{

	EcommerceCart findById(long id);
}
