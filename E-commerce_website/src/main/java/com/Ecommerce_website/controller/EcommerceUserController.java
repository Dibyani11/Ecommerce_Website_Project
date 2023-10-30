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

import com.Ecommerce_website.DTO.EcommerceCartRequDTO;
import com.Ecommerce_website.DTO.EcommerceCartResDTO;
import com.Ecommerce_website.DTO.EcommerceCategoryDTO;
import com.Ecommerce_website.DTO.EcommerceCategoryDtoForUserSide;
import com.Ecommerce_website.DTO.EcommerceItemsDtoForUserSide;
import com.Ecommerce_website.DTO.EcommerceOrderDTO;
import com.Ecommerce_website.DTO.EcommerceOrderHistoryDTO;
import com.Ecommerce_website.DTO.EcommerceUserDTO;
import com.Ecommerce_website.DTO.EcommerceUserFavAccountDTO;
import com.Ecommerce_website.service.EcommerceUserService;
import com.Ecommerce_website.service.EcommerceVendorService;

@RestController
@RequestMapping("/user")
public class EcommerceUserController {

	@Autowired
	private EcommerceUserService userService;

	// localhost:8089/user/add
	@PostMapping("/add")
	public EcommerceUserDTO createEcommerceUser(@RequestBody EcommerceUserDTO userDTO) {
		return userService.addUser(userDTO);
	}

	// localhost:8089/user/update
	@PutMapping("/update")
	public EcommerceUserDTO updateEcommerceUser(@RequestBody EcommerceUserDTO userDTO) {
		return userService.updateUser(userDTO);
	}

	// localhost:8089/user/getAll
	@GetMapping("/getAll")
	private List<EcommerceUserDTO> getAllEcommerceUser() {
		return userService.getAllUser();
	}

	// localhost:8089/user/delete/3
	@DeleteMapping("/delete/{id}")
	private String deleteUser(@PathVariable long id) {
		return userService.deleteUserById(id);
	}

	// localhost:8089/user/getCategory/2
	@GetMapping("/getCategory/{id}")
	public EcommerceCategoryDtoForUserSide getEcommerceCategoryById(@PathVariable long id) {
		return userService.getCtegoryById(id);
	}
	
	// localhost:8089/user/getAllCategory/1
	@GetMapping("/getAllCategory/{vendorId}")
	public List<EcommerceCategoryDtoForUserSide> getEcommerceCategoriesByVendorId(@PathVariable long vendorId) {
		return userService.getCategoryByVendorId(vendorId);
	}

	// localhost:8089/user/getItem/1
	@GetMapping("/getItem/{id}")
	public EcommerceItemsDtoForUserSide getEcommerceItemById(@PathVariable long id) {
		return userService.getItemById(id);
	}
	
	// localhost:8089/user/getAllItems/2
	@GetMapping("/getAllItems/{categoryId}")
	public List<EcommerceItemsDtoForUserSide> getEcommerceItemsByCategoryId(@PathVariable long categoryId) {
		return userService.getItemsByCategoryId(categoryId);
	}
	
	// localhost:8089/user/addCart
	@PostMapping("/addCart")
	private EcommerceCartResDTO addEcommerceCart(@RequestBody EcommerceCartRequDTO cartReqDTO) {
		return userService.addToCart(cartReqDTO);
	}

	// localhost:8089/user/updateCart
	@PutMapping("/updateCart")
	private EcommerceCartResDTO updateEcommeerceCart(@RequestBody EcommerceCartRequDTO cartReqDTO) {
		return userService.updateCart(cartReqDTO);
	}

	// localhost:8089/user/deleteCart/2
	@DeleteMapping("/deleteCart/{id}")
	private String deleteEcommerceCart(@PathVariable long id) {
		return userService.deleteCart(id);
	}

	// localhost:8089/user/addOrder
	@PostMapping("/addOrder")
	private EcommerceOrderDTO addEcommerceOrder(@RequestBody EcommerceOrderDTO orderDTO) {
		return userService.addOrder(orderDTO);
	}

	// localhost:8089/user/getOrder/2
	@GetMapping("/getOrder/{id}")
	private EcommerceOrderHistoryDTO getEcommerceOrderByOrderId(@PathVariable long id) {
		return userService.getOrderById(id);
	}

	// localhost:8089/user/getAllUserOrder/2
	@GetMapping("getAllUserOrder/{userId}")
	private List<EcommerceOrderHistoryDTO> getEcommerceOrderByUserId(@PathVariable long userId) {
		return userService.getOrderByUserId(userId);
	}
	
	// localhost:8089/user/getAllUserOrder/1/2
	@GetMapping("/getAllEcommerceOrder/{userId}/{orderId}")
	private EcommerceOrderHistoryDTO getAllOrderByEcommerceUserId(@PathVariable long userId, @PathVariable long orderId) {
		return userService.getEcommerceOrderByUserIdAndOrderId(userId, orderId);
	}
	
	// localhost:8089/user/addFavAccount
	@PostMapping("/addFavAccount")
	private EcommerceUserFavAccountDTO addEcommerceUserFavAccount(@RequestBody EcommerceUserFavAccountDTO userAccountDTO) {
		return userService.addUserFavAccount(userAccountDTO);
	}
	
	// localhost:8089/user/getFavAccount/2
	@GetMapping("/getFavAccount/{id}")
	private EcommerceUserFavAccountDTO getEcommerceUserFavAccount(@PathVariable long id) {
		return userService.getFavAccountById(id);
	}
	
	// localhost:8089/user/deleteFavAccount/1
	@DeleteMapping("/deleteFavAccount/{id}")
	private String deleteEcommerceUserFavAccount(@PathVariable long id) {
		return userService.deleteFavAccount(id);
	}
}
