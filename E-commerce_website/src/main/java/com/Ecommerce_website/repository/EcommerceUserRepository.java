package com.Ecommerce_website.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce_website.model.EcommerceUser;

public interface EcommerceUserRepository extends JpaRepository<EcommerceUser, Long>{

	EcommerceUser findByEmail(String email);
	
	EcommerceUser findById(long id);

	EcommerceUser findByMobileNumber(String mobileNumber);

}
