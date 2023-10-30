package com.Ecommerce_website.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce_website.DTO.EcommerceCategoryDTO;
import com.Ecommerce_website.DTO.EcommerceItemsDTO;
import com.Ecommerce_website.DTO.EcommerceOrderHistoryDTO;
import com.Ecommerce_website.DTO.EcommerceVendorDTO;
import com.Ecommerce_website.service.EcommerceVendorService;

@RestController
@RequestMapping("/vendor")
public class EcommerceVendorController {

	@Autowired
	EcommerceVendorService vendorService;

	// localhost:8089/vendor/add
	@PostMapping("/add")
	private EcommerceVendorDTO createVendor(@RequestBody EcommerceVendorDTO vendorDTO) {
		return vendorService.addVendor(vendorDTO);
	}

	// localhost:8089/vendor/update
	@PutMapping("/update")
	private EcommerceVendorDTO updateVendor(@RequestBody EcommerceVendorDTO vendorDTO) {
		return vendorService.updateVendor(vendorDTO);
	}

	// localhost:8089/vendor/1
	@GetMapping("/{id}")
	private EcommerceVendorDTO getVendorById(@PathVariable long id) {
		return vendorService.getVendorById(id);
	}

	// localhost:8089/vendor/delete/3
	@DeleteMapping("delete/{id}")
	private String deleteEcommerceVendorById(@PathVariable long id) {
		return vendorService.deleteVendor(id);
	}

	// localhost:8089/vendor/addCategory
	@PostMapping("/addCategory")
	private EcommerceCategoryDTO createCategory(@RequestBody EcommerceCategoryDTO categoryDTO) {
		return vendorService.addCategory(categoryDTO);
	}

	// localhost:8089/vendor/updateCategory
	@PutMapping("/updateCategory")
	private EcommerceCategoryDTO updateEcommerceCategory(@RequestBody EcommerceCategoryDTO categoryDTO) {
		return vendorService.updateCategory(categoryDTO);
	}

	// localhost:8089/vendor/getCategory/3
	@GetMapping("/getCategory/{id}")
	private EcommerceCategoryDTO getOneCategory(@PathVariable long id) {
		return vendorService.getCategoryById(id);
	}

	// localhost:8089/vendor/getAllCategory/2
	@GetMapping("/getAllCategory/{vendorId}")
	private List<EcommerceCategoryDTO> getAllCategoriesByVendorId(@PathVariable long vendorId) {
		return vendorService.getAllCategoryByEcommerceVendorId(vendorId);
	}

	// localhost:8089/vendor/addItem
	@PostMapping("/addItem")
	private EcommerceItemsDTO createItems(@RequestBody EcommerceItemsDTO itemsDTO) {
		return vendorService.addItems(itemsDTO);
	}

	// localhost:8089/vendor/getItem/4
	@GetMapping("/getItem/{id}")
	private EcommerceItemsDTO getItemById(@PathVariable long id) {
		return vendorService.getItemById(id);
	}

	// localhost:8089/vendor/getAllItem/1
	@GetMapping("/getAllItem/{categoryId}")
	private List<EcommerceItemsDTO> getAllItemByCategoryId(@PathVariable long categoryId) {
		return vendorService.getAllItemByEcommerceCategoryId(categoryId);
	}

	// localhost:8089/vendor/updateItem
	@PutMapping("/updateItem")
	private EcommerceItemsDTO updateEcommerceItem(@RequestBody EcommerceItemsDTO itemsDTO) {
		return vendorService.updateItem(itemsDTO);
	}

	// localhost:8089/vendor/getAllOrder/2
	@GetMapping("/getAllOrder/{vendorId}")
	private List<EcommerceOrderHistoryDTO> getEcommerceOrderByEcommerceVendorId(@PathVariable long vendorId) {
		return vendorService.getOrderByVendorId(vendorId);
	}

	// localhost:8089/vendor/getAllOrder/1/1
	@GetMapping("/getAllOrder/{vendorId}/{orderId}")
	private EcommerceOrderHistoryDTO getAllOrderByVendorIdAndOrderId(@PathVariable long vendorId,
			@PathVariable long orderId) {
		return vendorService.getAllOrderByEcommerceVendorIdAndEcommerceOrderId(vendorId, orderId);
	}
}
