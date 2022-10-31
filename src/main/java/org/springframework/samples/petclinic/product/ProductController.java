package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	private final ProductService productService;
	private final String PRODUCT_LISTING = "/products/productListing";
	private final String PRODUCT_FORM = "/products/createOrUpdateProductForm";
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	
	@ModelAttribute("productTypes")
	public List<ProductType> populateProductTypes() {
		return this.productService.findAllProductTypes();
	}
	
	@GetMapping
	public ModelAndView showProducts() {
		ModelAndView mav = new ModelAndView(PRODUCT_LISTING);
		List<Product> products = productService.getAllProducts();
		mav.addObject("products", products);
		return mav;
	}
	
	@GetMapping("/create")
	public ModelAndView initProductForm() {
		ModelAndView mav= new ModelAndView(PRODUCT_FORM);
		Product product = new Product();
		mav.addObject("product", product);
		return mav;
	}
	
	@PostMapping("/create")
	public ModelAndView saveProdcut(@Valid Product product, BindingResult br) {
		ModelAndView mav = new ModelAndView("welcome");
		if (br.hasErrors()) {
			mav = new ModelAndView(PRODUCT_FORM);
			mav.addObject("errorMessage", "Product form has erros");
			return mav;
		}
		
		mav.addObject("message", "Created succesfully");
		this.productService.save(product);
		return mav;
	}    
}
