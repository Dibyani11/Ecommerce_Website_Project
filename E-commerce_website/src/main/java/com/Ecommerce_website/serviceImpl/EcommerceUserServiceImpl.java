package com.Ecommerce_website.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce_website.DTO.EcommerceCartRequDTO;
import com.Ecommerce_website.DTO.EcommerceCartResDTO;
import com.Ecommerce_website.DTO.EcommerceCategoryDTO;
import com.Ecommerce_website.DTO.EcommerceCategoryDtoForUserSide;
import com.Ecommerce_website.DTO.EcommerceItemsDTO;
import com.Ecommerce_website.DTO.EcommerceItemsDtoForUserSide;
import com.Ecommerce_website.DTO.EcommerceOrderDTO;
import com.Ecommerce_website.DTO.EcommerceOrderHistoryDTO;
import com.Ecommerce_website.DTO.EcommerceUserDTO;
import com.Ecommerce_website.DTO.EcommerceUserFavAccountDTO;
import com.Ecommerce_website.model.EcommerceCart;
import com.Ecommerce_website.model.EcommerceCategory;
import com.Ecommerce_website.model.EcommerceItems;
import com.Ecommerce_website.model.EcommerceOrder;
import com.Ecommerce_website.model.EcommerceUser;
import com.Ecommerce_website.model.EcommerceUserFavAccount;
import com.Ecommerce_website.model.EcommerceVendor;
import com.Ecommerce_website.repository.EcommerceCartRepository;
import com.Ecommerce_website.repository.EcommerceCategoryRepository;
import com.Ecommerce_website.repository.EcommerceItemsRepository;
import com.Ecommerce_website.repository.EcommerceOrderRepository;
import com.Ecommerce_website.repository.EcommerceUserFavAccountRepository;
import com.Ecommerce_website.repository.EcommerceUserRepository;
import com.Ecommerce_website.repository.EcommerceVendorRepository;
import com.Ecommerce_website.service.EcommerceUserService;

@Service
public class EcommerceUserServiceImpl implements EcommerceUserService {

	@Autowired
	EcommerceUserRepository userRepo;

	@Autowired
	EcommerceVendorRepository vendorRepo;

	@Autowired
	EcommerceCategoryRepository categoryRepo;

	@Autowired
	EcommerceItemsRepository itemRepo;

	@Autowired
	EcommerceCartRepository cartRepo;

	@Autowired
	EcommerceOrderRepository orderRepo;

	@Autowired
	EcommerceUserFavAccountRepository favAccountRepo;

	@Override
	public EcommerceUserDTO addUser(EcommerceUserDTO userDTO) {

		EcommerceUser eUser = new EcommerceUser();

		eUser.setFirstName(userDTO.getFirstName());
		eUser.setLastName(userDTO.getLastName());
		eUser.setEmail(userDTO.getEmail());
		eUser.setMobileNumber(userDTO.getMobileNumber());
		eUser.setBalance(new BigDecimal(2000));
		eUser.setAddress(userDTO.getAddress());
		eUser.setDob(userDTO.getDob());
		eUser.setStatus(true);

		String email = userDTO.getEmail();
		if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			throw new RuntimeException("Invalid Email format.");
		} else {

			EcommerceUser userMail = userRepo.findByEmail(userDTO.getEmail());
			if (userMail == null) {

				String mobileNumber = userDTO.getMobileNumber();
				if (!mobileNumber.matches("\\d{10}")) {
					throw new RuntimeException("Invalid Number format.");
				} else {

					EcommerceUser userNumber = userRepo.findByMobileNumber(userDTO.getMobileNumber());
					if (userNumber == null) {

						EcommerceUser newUser = userRepo.save(eUser);

						userDTO.setUserId(newUser.getUserId());
						userDTO.setFirstName(newUser.getFirstName());
						userDTO.setLastName(newUser.getLastName());
						userDTO.setEmail(newUser.getEmail());
						userDTO.setMobileNumber(newUser.getMobileNumber());
						userDTO.setBalance(newUser.getBalance());
						userDTO.setAddress(newUser.getAddress());
						userDTO.setDob(newUser.getDob());
						userDTO.setStatus(newUser.isStatus());
						userDTO.setCreatedOn(newUser.getCreatedOn());
						userDTO.setLastUpdatedOn(newUser.getLastUpdatedOn());

					} else
						throw new RuntimeException("Numer is in use.");
				}
			} else
				throw new RuntimeException("Email is already in use.");

			return userDTO;
		}
	}

	@Override
	public EcommerceUserDTO updateUser(EcommerceUserDTO userDTO) {

		EcommerceUser ecomUser = userRepo.findById(userDTO.getUserId());
		if (ecomUser != null) {

			ecomUser.setFirstName(userDTO.getFirstName());
			ecomUser.setLastName(userDTO.getLastName());
			ecomUser.setEmail(userDTO.getEmail());
			ecomUser.setMobileNumber(userDTO.getMobileNumber());
			ecomUser.setBalance(new BigDecimal(2000));
			ecomUser.setAddress(userDTO.getAddress());
			ecomUser.setDob(userDTO.getDob());

			String email = userDTO.getEmail();
			if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
				throw new RuntimeException("Invalid Email format.");
			} else {

				EcommerceUser userMail = userRepo.findByEmail(userDTO.getEmail());
				if (userMail == null) {

					String mobileNumber = userDTO.getMobileNumber();
					if (!mobileNumber.matches("\\d{10}")) {
						throw new RuntimeException("Invalid Number format.");
					} else {

						EcommerceUser userNumber = userRepo.findByMobileNumber(userDTO.getMobileNumber());
						if (userNumber == null) {

							EcommerceUser newUser = userRepo.save(ecomUser);

							userDTO.setUserId(newUser.getUserId());
							userDTO.setFirstName(newUser.getFirstName());
							userDTO.setLastName(newUser.getLastName());
							userDTO.setEmail(newUser.getEmail());
							userDTO.setMobileNumber(newUser.getMobileNumber());
							userDTO.setBalance(newUser.getBalance());
							userDTO.setAddress(newUser.getAddress());
							userDTO.setDob(newUser.getDob());
							userDTO.setStatus(newUser.isStatus());
							userDTO.setCreatedOn(newUser.getCreatedOn());
							userDTO.setLastUpdatedOn(newUser.getLastUpdatedOn());

						} else
							throw new RuntimeException("Number is in use.");
					}
				} else
					throw new RuntimeException("Email is already in use.");

				return userDTO;
			}
		} else
			throw new RuntimeException("Ecommerce User is not present.");
	}

	@Override
	public List<EcommerceUserDTO> getAllUser() {

		List<EcommerceUser> userId = userRepo.findAll();

		List<EcommerceUserDTO> userDto = new ArrayList<>();

		for (EcommerceUser allUser : userId) {

			EcommerceUserDTO allUserDto = new EcommerceUserDTO();

			allUserDto.setUserId(allUser.getUserId());
			allUserDto.setFirstName(allUser.getFirstName());
			allUserDto.setLastName(allUser.getLastName());
			allUserDto.setEmail(allUser.getEmail());
			allUserDto.setMobileNumber(allUser.getMobileNumber());
			allUserDto.setBalance(allUser.getBalance());
			allUserDto.setAddress(allUser.getAddress());
			allUserDto.setDob(allUser.getDob());
			allUserDto.setStatus(allUser.isStatus());
			allUserDto.setCreatedOn(allUser.getCreatedOn());
			allUserDto.setLastUpdatedOn(allUser.getLastUpdatedOn());

			userDto.add(allUserDto);

		}
		return userDto;
	}

	@Override
	public String deleteUserById(long id) {

		EcommerceUser userId = userRepo.findById(id);

		if (userId != null) {

			userId.setStatus(false);

			userRepo.save(userId);

			return "User Deleted";
		} else
			throw new RuntimeException("User With given Id is not present");
	}

	@Override
	public EcommerceCategoryDtoForUserSide getCtegoryById(long id) {

		EcommerceCategory checkCategoryId = categoryRepo.findById(id);
		if (checkCategoryId != null) {

			EcommerceCategoryDtoForUserSide userSideCategoryDTO = new EcommerceCategoryDtoForUserSide();

			userSideCategoryDTO.setCategoryId(checkCategoryId.getCategoryId());
			userSideCategoryDTO.setName(checkCategoryId.getName());
			userSideCategoryDTO.setVendorId(checkCategoryId.getEcommerceVendor().getVendorId());

			return userSideCategoryDTO;

		} else
			throw new RuntimeException("Category with given Id id not present.");
	}

	@Override
	public List<EcommerceCategoryDtoForUserSide> getCategoryByVendorId(long vendorId) {

		EcommerceVendor checkVendor = vendorRepo.findById(vendorId);
		if (checkVendor != null) {

			List<EcommerceCategory> checkCategory = categoryRepo.findByEcommerceVendorVendorId(vendorId);

			List<EcommerceCategoryDtoForUserSide> listingAllCategory = new ArrayList();

			for (EcommerceCategory getAllEcommerceCategory : checkCategory) {

				EcommerceCategoryDtoForUserSide categoryDto = new EcommerceCategoryDtoForUserSide();

				categoryDto.setCategoryId(getAllEcommerceCategory.getCategoryId());
				categoryDto.setName(getAllEcommerceCategory.getName());
				categoryDto.setVendorId(getAllEcommerceCategory.getEcommerceVendor().getVendorId());

				listingAllCategory.add(categoryDto);
			}
			return listingAllCategory;
		} else
			throw new RuntimeException("Vender with given Id is not present.");
	}

	@Override
	public EcommerceItemsDtoForUserSide getItemById(long id) {

		EcommerceItems checkItem = itemRepo.findById(id);
		if (checkItem != null) {

			EcommerceItemsDtoForUserSide itemDto = new EcommerceItemsDtoForUserSide();

			itemDto.setItemId(checkItem.getItemId());
			itemDto.setName(checkItem.getName());
			itemDto.setQuantity(checkItem.getQuantity());
			itemDto.setAmount(checkItem.getAmount());
			itemDto.setStatus(checkItem.isStatus());
			itemDto.setVendorId(checkItem.getEcommerceVendor().getVendorId());
			itemDto.setCategoryId(checkItem.getEcommerceCategory().getCategoryId());

			return itemDto;
		} else
			throw new RuntimeException("Item with given Id is not present.");
	}

	@Override
	public List<EcommerceItemsDtoForUserSide> getItemsByCategoryId(long categoryId) {

		EcommerceCategory checkCategoryId = categoryRepo.findById(categoryId);
		if (checkCategoryId != null) {

			List<EcommerceItems> checkItem = itemRepo.findByEcommerceCategoryCategoryId(categoryId);

			List<EcommerceItemsDtoForUserSide> allItem = new ArrayList();

			for (EcommerceItems getAllEcommerceItem : checkItem) {

				EcommerceItemsDtoForUserSide itemDto = new EcommerceItemsDtoForUserSide();

				itemDto.setItemId(getAllEcommerceItem.getItemId());
				itemDto.setName(getAllEcommerceItem.getName());
				itemDto.setQuantity(getAllEcommerceItem.getQuantity());
				itemDto.setAmount(getAllEcommerceItem.getAmount());
				itemDto.setStatus(getAllEcommerceItem.isStatus());
				itemDto.setVendorId(getAllEcommerceItem.getEcommerceVendor().getVendorId());
				itemDto.setCategoryId(getAllEcommerceItem.getEcommerceCategory().getCategoryId());

				allItem.add(itemDto);
			}
			return allItem;
		} else
			throw new RuntimeException("Category is not present.");
	}

	@Override
	public EcommerceCartResDTO addToCart(EcommerceCartRequDTO cartReqDTO) {

		EcommerceCart newCart = new EcommerceCart();

		BigDecimal totalAmount = new BigDecimal(0);

		List<EcommerceItems> allItems = cartReqDTO.getItemId();

		for (EcommerceItems ecommerceItems : allItems) {

			EcommerceItems checkItem = itemRepo.findById(ecommerceItems.getItemId());
			if (checkItem != null) {

				long itemQuantity = ecommerceItems.getQuantity();
				BigDecimal itemAmount = checkItem.getAmount();

				if (itemQuantity > 1) {

					itemAmount = itemAmount.multiply(BigDecimal.valueOf(itemQuantity));

					totalAmount = totalAmount.add(itemAmount);
				} else
					totalAmount = totalAmount.add(itemAmount);
			} else
				throw new RuntimeException("Item with given Id is not present.");
		}

		newCart.setAmount(totalAmount);

		EcommerceCart addToCart = cartRepo.save(newCart);

		EcommerceCartResDTO responseDTO = new EcommerceCartResDTO();

		responseDTO.setCartId(addToCart.getCartId());
		responseDTO.setAmount(addToCart.getAmount());
		return responseDTO;
	}

	@Override
	public EcommerceCartResDTO updateCart(EcommerceCartRequDTO cartReqDTO) {

		EcommerceCart cartId = cartRepo.findById(cartReqDTO.getCartId());
		if (cartId != null) {

			BigDecimal totalAmount = new BigDecimal(0);

			List<EcommerceItems> allItems = cartReqDTO.getItemId();

			for (EcommerceItems ecommerceItems : allItems) {

				EcommerceItems checkItem = itemRepo.findById(ecommerceItems.getItemId());
				if (checkItem != null) {

					long itemQuantity = ecommerceItems.getQuantity();
					BigDecimal itemAmount = checkItem.getAmount();

					if (itemQuantity > 1) {

						itemAmount = itemAmount.multiply(BigDecimal.valueOf(itemQuantity));

						totalAmount = totalAmount.add(itemAmount);
					} else
						totalAmount = totalAmount.add(itemAmount);
				} else
					throw new RuntimeException("Item with given Id is not present.");
			}

			cartId.setAmount(totalAmount);

			EcommerceCart addToCart = cartRepo.save(cartId);

			EcommerceCartResDTO responseDTO = new EcommerceCartResDTO();

			responseDTO.setCartId(addToCart.getCartId());
			responseDTO.setAmount(addToCart.getAmount());

			return responseDTO;
		} else
			throw new RuntimeException("Cart with given id is not present.");
	}

	@Override
	public EcommerceOrderDTO addOrder(EcommerceOrderDTO orderDTO) {

		EcommerceOrder placingOrder = new EcommerceOrder();

		EcommerceUser checkUser = userRepo.findById(orderDTO.getUserId());
		if (checkUser != null) {

			EcommerceVendor checkVendor = vendorRepo.findById(orderDTO.getVendorId());
			if (checkVendor != null) {

				EcommerceCart checkCart = cartRepo.findById(orderDTO.getCartId());
				if (checkCart != null) {

					BigDecimal amountToPay = checkCart.getAmount();

					BigDecimal userBalance = checkUser.getBalance();

					int checkUserBalance = userBalance.compareTo(amountToPay);
					if (checkUserBalance >= 0) {

						BigDecimal afterOrderUserBalance = userBalance.subtract(amountToPay);
						checkUser.setBalance(afterOrderUserBalance);
						userRepo.save(checkUser);

						BigDecimal addToVendor = checkVendor.getBalance().add(amountToPay);
						checkVendor.setBalance(addToVendor);

						placingOrder.setAmount(amountToPay);
						placingOrder.setTransactionId(UUID.randomUUID().toString());
						placingOrder.setEcommerceUser(checkUser);
						placingOrder.setEcommerceVendor(checkVendor);
						placingOrder.setEcommerceCart(checkCart);
						placingOrder.setDescription("Order Successful");

						EcommerceOrder savingOrder = orderRepo.save(placingOrder);

						orderDTO.setOrderId(savingOrder.getOrderId());
						orderDTO.setAmount(savingOrder.getAmount());
						orderDTO.setTransactionId(savingOrder.getTransactionId());
						orderDTO.setUserId(savingOrder.getEcommerceUser().getUserId());
						orderDTO.setVendorId(savingOrder.getEcommerceVendor().getVendorId());
						orderDTO.setCartId(savingOrder.getEcommerceCart().getCartId());
						orderDTO.setDescription(savingOrder.getDescription());
						orderDTO.setCreatedOn(savingOrder.getCreatedOn());
						orderDTO.setLastUpdatedOn(savingOrder.getLastUpdatedOn());

					} else
						throw new RuntimeException("User Balance is low can't place order");
				} else
					throw new RuntimeException("Cart with given Id is not present.");
			} else
				throw new RuntimeException("Vendor with given Id is not present.");
		} else
			throw new RuntimeException("User with given Id is not present");

		return orderDTO;
	}

	@Override
	public String deleteCart(long id) {

		EcommerceCart checkCart = cartRepo.findById(id);
		if (checkCart != null) {

			cartRepo.delete(checkCart);

			return "Deleted Successfully.";
		} else
			throw new RuntimeException("Cart with given id is not present.");
	}

	// check this one
	@Override
	public EcommerceOrderHistoryDTO getOrderById(long id) {

		EcommerceOrder checkOrder = orderRepo.findById(id);
		if (checkOrder != null) {

			EcommerceOrderHistoryDTO orderDTO = new EcommerceOrderHistoryDTO();

			orderDTO.setOrderId(checkOrder.getOrderId());
			orderDTO.setAmount(checkOrder.getAmount());
			orderDTO.setTransactionId(checkOrder.getTransactionId());
			orderDTO.setUserId(checkOrder.getEcommerceUser().getUserId());
			orderDTO.setVendorId(checkOrder.getEcommerceVendor().getVendorId());
			orderDTO.setCartId(checkOrder.getEcommerceCart().getCartId());
			orderDTO.setDescription(checkOrder.getDescription());

			return orderDTO;

		} else
			throw new RuntimeException("Order with given id is not present.");
	}

	@Override
	public List<EcommerceOrderHistoryDTO> getOrderByUserId(long userId) {

		EcommerceUser checkUserId = userRepo.findById(userId);
		if (checkUserId != null) {

			List<EcommerceOrder> userInOrder = orderRepo.findByEcommerceUserUserId(userId);

			List<EcommerceOrderHistoryDTO> orderDTO = new ArrayList<>();

			for (EcommerceOrder usersAllOrder : userInOrder) {

				EcommerceOrderHistoryDTO savedOrder = new EcommerceOrderHistoryDTO();

				savedOrder.setOrderId(usersAllOrder.getOrderId());
				savedOrder.setAmount(usersAllOrder.getAmount());
				savedOrder.setTransactionId(usersAllOrder.getTransactionId());
				savedOrder.setUserId(usersAllOrder.getEcommerceUser().getUserId());
				savedOrder.setVendorId(usersAllOrder.getEcommerceVendor().getVendorId());
				savedOrder.setCartId(usersAllOrder.getEcommerceCart().getCartId());
				savedOrder.setDescription(usersAllOrder.getDescription());

				orderDTO.add(savedOrder);
			}
			return orderDTO;
		} else
			throw new RuntimeException("User hasn't place any order.");
	}

	@Override
	public EcommerceOrderHistoryDTO getEcommerceOrderByUserIdAndOrderId(long userId, long orderId) {

		EcommerceUser checkUserId = userRepo.findById(userId);
		if (checkUserId != null) {
			
			EcommerceOrder checkOrderId = orderRepo.findById(orderId);
			if (checkOrderId != null) {
				
				EcommerceOrder checkOrderWithUser = orderRepo.findByEcommerceUserUserIdAndOrderId(userId, orderId);
			    if (checkOrderWithUser != null) {
					
			    	EcommerceOrderHistoryDTO historyDTO = new EcommerceOrderHistoryDTO();
			    	
			    	historyDTO.setOrderId(checkOrderWithUser.getOrderId());
			    	historyDTO.setAmount(checkOrderWithUser.getAmount());
			    	historyDTO.setTransactionId(checkOrderWithUser.getTransactionId());
			    	historyDTO.setUserId(checkOrderWithUser.getEcommerceUser().getUserId());
			    	historyDTO.setVendorId(checkOrderWithUser.getEcommerceVendor().getVendorId());
			    	historyDTO.setCartId(checkOrderWithUser.getEcommerceCart().getCartId());
			    	historyDTO.setDescription(checkOrderWithUser.getDescription());

					return historyDTO;
				}else
					throw new RuntimeException("No data Exists.");
			}else
				throw new RuntimeException("Order is not placed with given Id.");
		}else
			throw new RuntimeException("User With Given Id is Not Present.");
	}

	@Override
	public EcommerceUserFavAccountDTO addUserFavAccount(EcommerceUserFavAccountDTO userAccountDTO) {

		EcommerceUser checkUser = userRepo.findById(userAccountDTO.getUserId());
		if (checkUser != null) {

			EcommerceItems checkItems = itemRepo.findById(userAccountDTO.getItemId());
			if (checkItems != null) {

				EcommerceUserFavAccount favAccount = new EcommerceUserFavAccount();

				favAccount.setItemName(checkItems.getName());
				favAccount.setAmount(checkItems.getAmount());
				favAccount.setStatus(checkItems.isStatus());
				favAccount.setEcommerceItems(checkItems);
				favAccount.setEcommerceUser(checkUser);

				EcommerceUserFavAccount addFavAccount = favAccountRepo.save(favAccount);

				userAccountDTO.setUserAccountId(addFavAccount.getUserAccountId());
				userAccountDTO.setItemName(addFavAccount.getItemName());
				userAccountDTO.setAmount(addFavAccount.getAmount());
				userAccountDTO.setStatus(true);
				userAccountDTO.setItemId(addFavAccount.getEcommerceItems().getItemId());
				userAccountDTO.setUserId(addFavAccount.getEcommerceUser().getUserId());

			} else
				throw new RuntimeException("Item with given Id is not present.");
		} else
			throw new RuntimeException("User Is not Present.");
		return userAccountDTO;
	}

	@Override
	public EcommerceUserFavAccountDTO getFavAccountById(long id) {

		EcommerceUserFavAccount checkAccount = favAccountRepo.findById(id);
		if (checkAccount != null) {

			EcommerceUserFavAccountDTO favAccountDto = new EcommerceUserFavAccountDTO();

			favAccountDto.setUserAccountId(checkAccount.getUserAccountId());
			favAccountDto.setItemName(checkAccount.getItemName());
			favAccountDto.setAmount(checkAccount.getAmount());
			favAccountDto.setStatus(checkAccount.isStatus());
			favAccountDto.setItemId(checkAccount.getEcommerceItems().getItemId());
			favAccountDto.setUserId(checkAccount.getEcommerceUser().getUserId());

			return favAccountDto;
		} else
			throw new RuntimeException("Account with given Id is not present.");
	}

	@Override
	public String deleteFavAccount(long id) {

		EcommerceUserFavAccount userAccount = favAccountRepo.findById(id);
		if (userAccount != null) {

			userAccount.setStatus(false);

			EcommerceUserFavAccount deleteAccount = favAccountRepo.save(userAccount);

			return "UserAccount Deleted Successfully.";
		} else
			throw new RuntimeException("Account Id is not preent.");
	}
}
