package com.test.ProductsAndCategories.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.ProductsAndCategories.models.Categories;
import com.test.ProductsAndCategories.models.Products;
import com.test.ProductsAndCategories.services.ProductsAndCategoryService;

@Controller
public class ProductAndCategoryController {
	private final ProductsAndCategoryService productsAndCategoryService;

	public ProductAndCategoryController(ProductsAndCategoryService productsAndCategoryService) {
		this.productsAndCategoryService = productsAndCategoryService;
	}

	@RequestMapping("/product/new")
	public String product(@ModelAttribute("product") Products product) {
		return "product.jsp";
	}

	@RequestMapping("/product")
	public String createProucts(@ModelAttribute("product") Products product, BindingResult result) {
		if (result.hasErrors()) {
			return "product.jsp";
		} else {
			productsAndCategoryService.createProduct(product);
		}
		return "redirect:/product/new";
	}
	
	
	
			@RequestMapping("/category/new")
	public String category(@ModelAttribute("category") Categories category) {
		return "category.jsp";
	}

	@RequestMapping("/category")
	public String createProucts(@ModelAttribute("category") Categories category, BindingResult result) {
		if (result.hasErrors()) {
			return "category.jsp";
		} else {
			productsAndCategoryService.createCategory(category);
		}
		return "redirect:/category/new";
	}
	
	@RequestMapping("/product/{id}")
  	public String showProduct(@PathVariable("id") Long id,Model model) {
	  	Products products = productsAndCategoryService.findProduct(id);
		List<Categories> category = productsAndCategoryService.findProductNotContains(products);
		model.addAttribute("category", category);
	    model.addAttribute("product", products);
  		return "showproduct.jsp";
  	}
	  

		@RequestMapping(value = "/productaddcategory/{id}", method = RequestMethod.POST)
		public String addCategory(@RequestParam(value = "categories") Long category_id, @PathVariable("id") Long id) {
			Products product = productsAndCategoryService.findProduct(id);
			Categories category = productsAndCategoryService.findCategoey(category_id);
			productsAndCategoryService.addProd(category,product);
			return ("redirect:/product/"+id);
		}
		
		@RequestMapping("/category/{id}")
	  	public String showCategories(@PathVariable("id") Long id,Model model) {
			Categories category = productsAndCategoryService.findCategoey(id);
			List<Products> product = productsAndCategoryService.findCategoryNotContains(category);
			model.addAttribute("category", category);
		    model.addAttribute("product", product);
	  		return "showcategory.jsp";
	  	}
		

		
			@RequestMapping(value = "/categoryaddproduct/{id}", method = RequestMethod.POST)
			public String addProducts(@RequestParam(value = "products") Long product_id, @PathVariable("id") Long id) {
				Categories category = productsAndCategoryService.findCategoey(id);
				Products product = productsAndCategoryService.findProduct(product_id);
				productsAndCategoryService.addCat(product, category);
				return ("redirect:/category/"+id);
			}

}
