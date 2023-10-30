package com.Ecommerce_website.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce_website.model.EcommerceUserFavAccount;

public interface EcommerceUserFavAccountRepository extends JpaRepository<EcommerceUserFavAccount, Long>{

	EcommerceUserFavAccount findById(long id);
}
