package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

	private final ProductService productService;
	
	@Autowired
	public ProductTypeFormatter(ProductService productService) {
		this.productService = productService;
		
	}	
	
    @Override
    public String print(ProductType object, Locale locale) {
        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
    	ProductType productType = this.productService.getProductType(text);
    	
    	if (productType == null) {
    		throw new ParseException("Product type was not found:" +  text, 0);
    	}
    		
        return productType;
    }
    
}
