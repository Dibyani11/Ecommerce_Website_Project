package com.Ecommerce_website.service;

import java.util.List;

import com.Ecommerce_website.DTO.EcommerceCategoryDTO;
import com.Ecommerce_website.DTO.EcommerceItemsDTO;
import com.Ecommerce_website.DTO.EcommerceOrderDTO;
import com.Ecommerce_website.DTO.EcommerceOrderHistoryDTO;
import com.Ecommerce_website.DTO.EcommerceVendorDTO;
import com.Ecommerce_website.model.EcommerceItems;

public interface EcommerceVendorService {

	public EcommerceVendorDTO addVendor(EcommerceVendorDTO vendorDTO);

	public EcommerceVendorDTO updateVendor(EcommerceVendorDTO vendorDTO);
	
	public EcommerceVendorDTO getVendorById(long id);
	
	public String deleteVendor(long id);
	
	public EcommerceCategoryDTO addCategory(EcommerceCategoryDTO categoryDTO);
	
	public EcommerceCategoryDTO updateCategory(EcommerceCategoryDTO categoryDTO);
	
	public EcommerceCategoryDTO getCategoryById(long id);

	List<EcommerceCategoryDTO> getAllCategoryByEcommerceVendorId(long vendorId);
	
	public EcommerceItemsDTO addItems(EcommerceItemsDTO itemsDTO);
	
	public EcommerceItemsDTO getItemById(long id);
	
	public List<EcommerceItemsDTO> getAllItemByEcommerceCategoryId(long categoryId);
	
	public EcommerceItemsDTO updateItem(EcommerceItemsDTO itemsDTO);

    public List<EcommerceOrderHistoryDTO> getOrderByVendorId(long vendorId);
    
    public EcommerceOrderHistoryDTO getAllOrderByEcommerceVendorIdAndEcommerceOrderId(long vendorId , long orderId);
}
