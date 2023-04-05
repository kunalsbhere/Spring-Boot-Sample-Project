package com.demo.service;





import static org.springframework.beans.BeanUtils.copyProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.ProductRequest;
import com.demo.dto.ProductResponse;
import com.demo.entity.Product;
import com.demo.exception.UserCustomException;
import com.demo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl  implements	 ProductService {

	@Autowired
	ProductRepository productRepo;
	
	@Override
	public long addProduct(ProductRequest productRequest) {
		Product product = Product.builder()
				.productName(productRequest.getProductName())
				.price(productRequest.getPrice())
				.quantity(productRequest.getQuantity()).build();
		productRepo.save(product);
		return product.getProductId();
	}
	
	@Override
	public ProductResponse getProductById(long productId) {
		Product product = productRepo.findById(productId).orElseThrow(() -> new UserCustomException("ERROR :","No product Found for the Id "+productId));
		ProductResponse productRes = new ProductResponse();
		copyProperties(product , productRes);
		
		return productRes;
	}

	@Override
	public void deleteProductById(long productId) {
		if(!productRepo.existsById(productId))
			throw new UserCustomException("No product found for the id "+productId,"PRODUCT_NOT_FOUND");
		
		productRepo.deleteById(productId);
		
	}

	@Override
	public void reduceQuantity(long productId, long quantity) {
		Product product = productRepo.findById(productId).orElseThrow(() -> new UserCustomException("Product with given Id not found",
	                "PRODUCT_NOT_FOUND"));
	
		if(product.getQuantity() < quantity) {
		    throw new UserCustomException("Product does not have sufficient Quantity","INSUFFICIENT_QUANTITY"
		    );
		}
	
		product.setQuantity(product.getQuantity() - quantity);
		productRepo.save(product);
		
	}
}
