package com.Ecommerce_website.service;

import java.util.List;

import com.Ecommerce_website.DTO.EcommerceCartRequDTO;
import com.Ecommerce_website.DTO.EcommerceCartResDTO;
import com.Ecommerce_website.DTO.EcommerceCategoryDtoForUserSide;
import com.Ecommerce_website.DTO.EcommerceItemsDtoForUserSide;
import com.Ecommerce_website.DTO.EcommerceOrderDTO;
import com.Ecommerce_website.DTO.EcommerceOrderHistoryDTO;
import com.Ecommerce_website.DTO.EcommerceUserDTO;
import com.Ecommerce_website.DTO.EcommerceUserFavAccountDTO;

public interface EcommerceUserService {
 
	public EcommerceUserDTO addUser(EcommerceUserDTO userDTO);
	
	public EcommerceUserDTO updateUser(EcommerceUserDTO userDTO);
	
	public List<EcommerceUserDTO> getAllUser();
	
	public String deleteUserById(long id);
	
	public EcommerceCategoryDtoForUserSide getCtegoryById(long id);
	
	public List<EcommerceCategoryDtoForUserSide> getCategoryByVendorId(long vendorId);
	
	public EcommerceItemsDtoForUserSide getItemById(long id);
	
	public List<EcommerceItemsDtoForUserSide> getItemsByCategoryId(long categoryId);
	
	public EcommerceCartResDTO addToCart(EcommerceCartRequDTO cartReqDTO);
	
	public EcommerceCartResDTO updateCart(EcommerceCartRequDTO cartReqDTO);
	
	public String deleteCart(long id);
	
	public EcommerceOrderDTO addOrder(EcommerceOrderDTO orderDTO);

	public EcommerceOrderHistoryDTO getOrderById(long id);
	
	public List<EcommerceOrderHistoryDTO> getOrderByUserId(long userId);
	
	public EcommerceOrderHistoryDTO getEcommerceOrderByUserIdAndOrderId(long userId , long orderId);
	
	public EcommerceUserFavAccountDTO addUserFavAccount(EcommerceUserFavAccountDTO userAccountDTO);

	public EcommerceUserFavAccountDTO getFavAccountById(long id);
	
	public String deleteFavAccount(long id);
}
