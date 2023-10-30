package com.Ecommerce_website.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce_website.DTO.EcommerceCategoryDTO;
import com.Ecommerce_website.DTO.EcommerceItemsDTO;
import com.Ecommerce_website.DTO.EcommerceOrderHistoryDTO;
import com.Ecommerce_website.DTO.EcommerceVendorDTO;
import com.Ecommerce_website.model.EcommerceCategory;
import com.Ecommerce_website.model.EcommerceItems;
import com.Ecommerce_website.model.EcommerceOrder;
import com.Ecommerce_website.model.EcommerceVendor;
import com.Ecommerce_website.repository.EcommerceCategoryRepository;
import com.Ecommerce_website.repository.EcommerceItemsRepository;
import com.Ecommerce_website.repository.EcommerceOrderRepository;
import com.Ecommerce_website.repository.EcommerceUserRepository;
import com.Ecommerce_website.repository.EcommerceVendorRepository;
import com.Ecommerce_website.service.EcommerceVendorService;

@Service
public class EcommerceVendorServiceImpl implements EcommerceVendorService {

	@Autowired
	EcommerceVendorRepository vendorRepo;

	@Autowired
	EcommerceUserRepository userRepo;

	@Autowired
	EcommerceCategoryRepository categoryRepo;

	@Autowired
	EcommerceItemsRepository itemRepo;

	@Autowired
	EcommerceOrderRepository orderRepo;

//	@Autowired
//	ModelMapper modelMapper;

	@Override
	public EcommerceVendorDTO addVendor(EcommerceVendorDTO vendorDTO) {

		EcommerceVendor eVendor = new EcommerceVendor();

		eVendor.setName(vendorDTO.getName());
		eVendor.setEmail(vendorDTO.getEmail());
		eVendor.setMobileNumber(vendorDTO.getMobileNumber());
		eVendor.setAddress(vendorDTO.getAddress());
		eVendor.setStatus(true);
		eVendor.setAvailability(vendorDTO.getAvailability());
		eVendor.setBalance(new BigDecimal(0));

		EcommerceVendor vendorEmail = vendorRepo.findByEmail(vendorDTO.getEmail());
		if (vendorEmail == null) {

			EcommerceVendor newVendor = vendorRepo.save(eVendor);

			vendorDTO.setVendorId(newVendor.getVendorId());
			vendorDTO.setName(newVendor.getName());
			vendorDTO.setEmail(newVendor.getEmail());
			vendorDTO.setMobileNumber(newVendor.getMobileNumber());
			vendorDTO.setAddress(newVendor.getAddress());
			vendorDTO.setStatus(newVendor.isStatus());
			vendorDTO.setAvailability(newVendor.getAvailability());
			vendorDTO.setBalance(newVendor.getBalance());
			vendorDTO.setCreatedOn(newVendor.getCreatedOn());
			vendorDTO.setLastUpdatedOn(newVendor.getLastUpdatedOn());

		} else
			throw new RuntimeException("Vendor with same email is present.");
		return vendorDTO;
	}

	@Override
	public EcommerceVendorDTO updateVendor(EcommerceVendorDTO vendorDTO) {

		EcommerceVendor vendorId = vendorRepo.findById(vendorDTO.getVendorId());
		if (vendorId != null) {

			vendorId.setName(vendorDTO.getName());
			vendorId.setEmail(vendorDTO.getEmail());
			vendorId.setMobileNumber(vendorDTO.getMobileNumber());
			vendorId.setAddress(vendorDTO.getAddress());
			vendorId.setAvailability(vendorDTO.getAvailability());

			EcommerceVendor vendorEmail = vendorRepo.findByEmail(vendorDTO.getEmail());
			if (vendorEmail == null) {

				EcommerceVendor newVendor = vendorRepo.save(vendorId);

				vendorDTO.setVendorId(newVendor.getVendorId());
				vendorDTO.setName(newVendor.getName());
				vendorDTO.setEmail(newVendor.getEmail());
				vendorDTO.setMobileNumber(newVendor.getMobileNumber());
				vendorDTO.setAddress(newVendor.getAddress());
				vendorDTO.setStatus(newVendor.isStatus());
				vendorDTO.setAvailability(newVendor.getAvailability());
				vendorDTO.setBalance(newVendor.getBalance());
				vendorDTO.setCreatedOn(newVendor.getCreatedOn());
				vendorDTO.setLastUpdatedOn(newVendor.getLastUpdatedOn());

			} else
				throw new RuntimeException("Vendor Email is already in use.");
		} else
			throw new RuntimeException("Vendor is not present.");

		return vendorDTO;
	}

	@Override
	public EcommerceVendorDTO getVendorById(long id) {

		EcommerceVendor checkVendor = vendorRepo.findById(id);
		if (checkVendor != null) {

			EcommerceVendorDTO vendorDTO = new EcommerceVendorDTO();

			vendorDTO.setVendorId(checkVendor.getVendorId());
			vendorDTO.setName(checkVendor.getName());
			vendorDTO.setEmail(checkVendor.getEmail());
			vendorDTO.setMobileNumber(checkVendor.getMobileNumber());
			vendorDTO.setAddress(checkVendor.getAddress());
			vendorDTO.setStatus(checkVendor.isStatus());
			vendorDTO.setAvailability(checkVendor.getAvailability());
			vendorDTO.setBalance(checkVendor.getBalance());
			vendorDTO.setCreatedOn(checkVendor.getCreatedOn());
			vendorDTO.setLastUpdatedOn(checkVendor.getLastUpdatedOn());

			return vendorDTO;
		} else
			throw new RuntimeException("EcommerceVendor with Id is not present.");
	}

	@Override
	public String deleteVendor(long id) {

		EcommerceVendor vendor = vendorRepo.findById(id);
		if (vendor != null) {

			vendorRepo.delete(vendor);

			return "EcommerceVendor Deleted successfully.";

		} else
			throw new RuntimeException("EcommerceVendor with given Id is not Present.");
	}

	@Override
	public EcommerceCategoryDTO addCategory(EcommerceCategoryDTO categoryDTO) {

		EcommerceVendor vendorId = vendorRepo.findById(categoryDTO.getVendorId());
		if (vendorId != null) {

			EcommerceCategory checkName = categoryRepo.findByNameAndEcommerceVendorVendorId(categoryDTO.getName(),
					categoryDTO.getVendorId());
			if (checkName == null) {

				EcommerceCategory category = new EcommerceCategory();

				category.setName(categoryDTO.getName());
				category.setEcommerceVendor(vendorId);

				EcommerceCategory newCategory = categoryRepo.save(category);

				categoryDTO.setCategoryId(newCategory.getCategoryId());
				categoryDTO.setName(newCategory.getName());
				categoryDTO.setVendorId(newCategory.getEcommerceVendor().getVendorId());
				categoryDTO.setCreatedOn(newCategory.getCreatedOn());
				categoryDTO.setLastUpdatedOn(newCategory.getLastUpdatedOn());

				return categoryDTO;
			} else
				throw new RuntimeException("Vendor with same categoryName is already present.");
		} else
			throw new RuntimeException("Vendor With given Id is not present.");
	}

	@Override
	public EcommerceCategoryDTO updateCategory(EcommerceCategoryDTO categoryDTO) {

		EcommerceCategory categoryId = categoryRepo.findById(categoryDTO.getCategoryId());
		if (categoryId != null) {

			EcommerceCategory checkName = categoryRepo.findByNameAndEcommerceVendorVendorId(categoryDTO.getName(),
					categoryId.getEcommerceVendor().getVendorId());
			if (checkName == null) {

				categoryId.setCategoryId(categoryDTO.getCategoryId());
				categoryId.setName(categoryDTO.getName());

				EcommerceCategory updateCategory = categoryRepo.save(categoryId);

				categoryDTO.setCategoryId(updateCategory.getCategoryId());
				categoryDTO.setName(updateCategory.getName());
				categoryDTO.setVendorId(updateCategory.getEcommerceVendor().getVendorId());
				categoryDTO.setCreatedOn(updateCategory.getCreatedOn());
				categoryDTO.setLastUpdatedOn(updateCategory.getLastUpdatedOn());

			} else
				throw new RuntimeException("Vender with categoryName is present.");
		} else
			throw new RuntimeException("Category with given Id is not present.");

		return categoryDTO;
	}

	@Override
	public EcommerceCategoryDTO getCategoryById(long id) {

		EcommerceCategory categoryId = categoryRepo.findById(id);
		if (categoryId != null) {

			EcommerceCategoryDTO categoryDTO = new EcommerceCategoryDTO();

			categoryDTO.setCategoryId(categoryId.getCategoryId());
			categoryDTO.setName(categoryId.getName());
			categoryDTO.setVendorId(categoryId.getEcommerceVendor().getVendorId());
			categoryDTO.setCreatedOn(categoryId.getCreatedOn());
			categoryDTO.setLastUpdatedOn(categoryId.getLastUpdatedOn());

			return categoryDTO;

		} else
			throw new RuntimeException("Category with given Id id not present.");
	}

	@Override
	public List<EcommerceCategoryDTO> getAllCategoryByEcommerceVendorId(long vendorId) {

		EcommerceVendor vendor = vendorRepo.findById(vendorId);
		if (vendor != null) {

			List<EcommerceCategory> category = categoryRepo.findByEcommerceVendorVendorId(vendorId);

			List<EcommerceCategoryDTO> allCategory = new ArrayList();

			for (EcommerceCategory getAllEcommerceCategory : category) {

				EcommerceCategoryDTO categoryDTO = new EcommerceCategoryDTO();

				categoryDTO.setCategoryId(getAllEcommerceCategory.getCategoryId());
				categoryDTO.setName(getAllEcommerceCategory.getName());
				categoryDTO.setVendorId(getAllEcommerceCategory.getEcommerceVendor().getVendorId());
				categoryDTO.setCreatedOn(getAllEcommerceCategory.getCreatedOn());
				categoryDTO.setLastUpdatedOn(getAllEcommerceCategory.getLastUpdatedOn());

				allCategory.add(categoryDTO);
			}
			return allCategory;
		} else
			throw new RuntimeException("Vender with given Id is not present.");
	}

	@Override
	public EcommerceItemsDTO addItems(EcommerceItemsDTO itemsDTO) {

		EcommerceCategory checkCategory = categoryRepo.findById(itemsDTO.getCategoryId());
		if (checkCategory != null) {

			EcommerceItems checkNameVid = itemRepo.findByNameAndEcommerceVendorVendorId(itemsDTO.getName(),
					checkCategory.getEcommerceVendor().getVendorId());
			if (checkNameVid == null) {

				EcommerceItems addItem = new EcommerceItems();

				addItem.setName(itemsDTO.getName());
				addItem.setQuantity(0);
				addItem.setAmount(itemsDTO.getAmount());
				addItem.setStatus(true);
				addItem.setEcommerceVendor(checkCategory.getEcommerceVendor());
				addItem.setEcommerceCategory(checkCategory);

				EcommerceItems newItem = itemRepo.save(addItem);

				itemsDTO.setItemId(newItem.getItemId());
				itemsDTO.setName(newItem.getName());
				itemsDTO.setQuantity(newItem.getQuantity());
				itemsDTO.setAmount(newItem.getAmount());
				itemsDTO.setStatus(newItem.isStatus());
				itemsDTO.setVendorId(newItem.getEcommerceVendor().getVendorId());
				itemsDTO.setCategoryId(newItem.getEcommerceCategory().getCategoryId());
				itemsDTO.setCreatedOn(newItem.getCreatedOn());
				itemsDTO.setLastUpdatedOn(newItem.getLastUpdatedOn());

				return itemsDTO;

			} else
				throw new RuntimeException("Item is already present for that particular Vendor.");
		} else
			throw new RuntimeException("Category with given Id is not present");
	}

	@Override
	public EcommerceItemsDTO getItemById(long id) {

		EcommerceItems checkItem = itemRepo.findById(id);
		if (checkItem != null) {

			EcommerceItemsDTO itemDTO = new EcommerceItemsDTO();

			itemDTO.setItemId(checkItem.getItemId());
			itemDTO.setName(checkItem.getName());
			itemDTO.setQuantity(checkItem.getQuantity());
			itemDTO.setAmount(checkItem.getAmount());
			itemDTO.setStatus(checkItem.isStatus());
			itemDTO.setVendorId(checkItem.getEcommerceVendor().getVendorId());
			itemDTO.setCategoryId(checkItem.getEcommerceCategory().getCategoryId());
			itemDTO.setCreatedOn(checkItem.getCreatedOn());
			itemDTO.setLastUpdatedOn(checkItem.getLastUpdatedOn());

			return itemDTO;
		} else
			throw new RuntimeException("Item with given Id is not present.");
	}

	@Override
	public List<EcommerceItemsDTO> getAllItemByEcommerceCategoryId(long categoryId) {

		EcommerceCategory checkCategory = categoryRepo.findById(categoryId);
		if (checkCategory != null) {

			List<EcommerceItems> item = itemRepo.findByEcommerceCategoryCategoryId(categoryId);

			List<EcommerceItemsDTO> allItem = new ArrayList();

			for (EcommerceItems getAllEcommerceItem : item) {

				EcommerceItemsDTO itemDTO = new EcommerceItemsDTO();

				itemDTO.setItemId(getAllEcommerceItem.getItemId());
				itemDTO.setName(getAllEcommerceItem.getName());
				itemDTO.setQuantity(getAllEcommerceItem.getQuantity());
				itemDTO.setAmount(getAllEcommerceItem.getAmount());
				itemDTO.setStatus(getAllEcommerceItem.isStatus());
				itemDTO.setVendorId(getAllEcommerceItem.getEcommerceVendor().getVendorId());
				itemDTO.setCategoryId(getAllEcommerceItem.getEcommerceCategory().getCategoryId());
				itemDTO.setCreatedOn(getAllEcommerceItem.getCreatedOn());
				itemDTO.setLastUpdatedOn(getAllEcommerceItem.getLastUpdatedOn());

				allItem.add(itemDTO);
			}
			return allItem;
		} else
			throw new RuntimeException("Category is not present.");
	}

	@Override
	public EcommerceItemsDTO updateItem(EcommerceItemsDTO itemsDTO) {

		EcommerceItems checkItem = itemRepo.findById(itemsDTO.getItemId());
		if (checkItem != null) {

			EcommerceItems checkNameCatId = itemRepo.findByNameAndEcommerceCategoryCategoryId(itemsDTO.getName(),
					itemsDTO.getCategoryId());
			if (checkNameCatId == null) {

				checkItem.setName(itemsDTO.getName());
				checkItem.setAmount(itemsDTO.getAmount());
				checkItem.setStatus(itemsDTO.isStatus());

				EcommerceItems updatedItem = itemRepo.save(checkItem);

				itemsDTO.setItemId(updatedItem.getItemId());
				itemsDTO.setName(updatedItem.getName());
				itemsDTO.setQuantity(updatedItem.getQuantity());
				itemsDTO.setAmount(updatedItem.getAmount());
				itemsDTO.setStatus(updatedItem.isStatus());
				itemsDTO.setVendorId(updatedItem.getEcommerceVendor().getVendorId());
				itemsDTO.setCategoryId(updatedItem.getEcommerceCategory().getCategoryId());
				itemsDTO.setCreatedOn(updatedItem.getCreatedOn());
				itemsDTO.setLastUpdatedOn(updatedItem.getLastUpdatedOn());

				return itemsDTO;
			} else
				throw new RuntimeException("Category with same item is present.");
		} else
			throw new RuntimeException("Item with given Id is not present.");
	}

	@Override
	public List<EcommerceOrderHistoryDTO> getOrderByVendorId(long vendorId) {

		EcommerceVendor checkVendor = vendorRepo.findById(vendorId);
		if (checkVendor != null) {

			List<EcommerceOrder> allOrders = orderRepo.findByEcommerceVendorVendorId(vendorId);

			List<EcommerceOrderHistoryDTO> orderDTO = new ArrayList<>();

			for (EcommerceOrder listingAllOrders : allOrders) {

				EcommerceOrderHistoryDTO allOrderDto = new EcommerceOrderHistoryDTO();

				allOrderDto.setOrderId(listingAllOrders.getOrderId());
				allOrderDto.setAmount(listingAllOrders.getAmount());
				allOrderDto.setTransactionId(listingAllOrders.getTransactionId());
				allOrderDto.setUserId(listingAllOrders.getEcommerceUser().getUserId());
				allOrderDto.setVendorId(listingAllOrders.getEcommerceVendor().getVendorId());
				allOrderDto.setCartId(listingAllOrders.getEcommerceCart().getCartId());
				allOrderDto.setDescription(listingAllOrders.getDescription());

				orderDTO.add(allOrderDto);
			}
			return orderDTO;
		} else
			throw new RuntimeException("Vendor with given Id is not present.");
	}

	@Override
	public EcommerceOrderHistoryDTO getAllOrderByEcommerceVendorIdAndEcommerceOrderId(long vendorId, long orderId) {

		EcommerceVendor checkVendorId = vendorRepo.findById(vendorId);
		if (checkVendorId != null) {

			EcommerceOrder checkOrder = orderRepo.findById(orderId);
			if (checkOrder != null) {

				EcommerceOrder checkOrderWithVendor = orderRepo.findByEcommerceVendorVendorIdAndOrderId(vendorId,
						orderId);
				if (checkOrderWithVendor != null) {

					EcommerceOrderHistoryDTO allOrderDto = new EcommerceOrderHistoryDTO();

					allOrderDto.setOrderId(checkOrderWithVendor.getOrderId());
					allOrderDto.setAmount(checkOrderWithVendor.getAmount());
					allOrderDto.setTransactionId(checkOrderWithVendor.getTransactionId());
					allOrderDto.setUserId(checkOrderWithVendor.getEcommerceUser().getUserId());
					allOrderDto.setVendorId(checkOrderWithVendor.getEcommerceVendor().getVendorId());
					allOrderDto.setCartId(checkOrderWithVendor.getEcommerceCart().getCartId());
					allOrderDto.setDescription(checkOrderWithVendor.getDescription());

					return allOrderDto;

				} else
					throw new RuntimeException("No data Exists.");
			} else
				throw new RuntimeException("Order with given OrderId is not present.");
		} else
			throw new RuntimeException("EcommerceVendor with given Id is not present.");
	}
}
