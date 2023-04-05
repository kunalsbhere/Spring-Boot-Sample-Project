package com.demo.service;

import com.demo.dto.ProductRequest;
import com.demo.dto.ProductResponse;

public interface ProductService {

	long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(long productId);

	void deleteProductById(long productId);

	void reduceQuantity(long productId, long quantity);

}
