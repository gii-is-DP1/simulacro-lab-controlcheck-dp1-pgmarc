package org.springframework.samples.petclinic.product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository pr) {
		this.productRepository = pr;
	}
	
	@Transactional(readOnly = true)
    public List<Product> getAllProducts() throws DataAccessException {
        return productRepository.findAll();
    }

	@Transactional(readOnly = true)
    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.findProductLessThan(price);
    }

	@Transactional(readOnly = true)
    public ProductType getProductType(String typeName) {
        return productRepository.findProductTypeByName(typeName);
    }
	
	@Transactional(readOnly = true)
    public List<ProductType> findAllProductTypes() {
        return productRepository.findAllProductTypes();
    }
	
    @Transactional
    public Product save(Product p){
        return productRepository.save(p);       
    }
}
