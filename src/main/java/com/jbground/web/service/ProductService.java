package com.jbground.web.service;

import com.jbground.web.model.Paging;
import com.jbground.web.model.Product;
import com.jbground.web.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductService {
	

	@Resource(type = ProductRepository.class)
	private ProductRepository productRepository;

	public Page<Product> getProductListByPage(Paging paging) {
		PageRequest page = PageRequest.of(paging.getPageNo(), paging.getPageSize());
		return productRepository.findAll(page);
	}
}
