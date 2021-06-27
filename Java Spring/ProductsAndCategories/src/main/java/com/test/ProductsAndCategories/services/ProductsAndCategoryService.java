package com.test.ProductsAndCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.test.ProductsAndCategories.models.Categories;
import com.test.ProductsAndCategories.models.Products;
import com.test.ProductsAndCategories.repositories.CategoryRepositoer;
import com.test.ProductsAndCategories.repositories.ProductRepositoer;

@Service
public class ProductsAndCategoryService {

	private final ProductRepositoer productRepositoer;
	private final CategoryRepositoer categoryRepositoer;

	public ProductsAndCategoryService(ProductRepositoer productRepositoer, CategoryRepositoer categoryRepositoer) {
		this.productRepositoer = productRepositoer;
		this.categoryRepositoer = categoryRepositoer;
	}

	public Products createProduct(Products product) {
		return productRepositoer.save(product);
	}

	public Categories createCategory(Categories category) {
		return categoryRepositoer.save(category);
	}

	public List<Categories> allCategory() {
		return categoryRepositoer.findAll();
	}
	public List<Products> allProduct() {
		return productRepositoer.findAll();
	}
	public List<Categories> findProductNotContains(Products product) {
		return categoryRepositoer.findByProductsNotContains(product);
	}


	public Products findProduct(Long id) {
		Optional<Products> product = productRepositoer.findById(id);
		if (product.isPresent()) {
			return product.get();

		} else {
			return null;
		}
	}
	public Categories findCategoey(Long id) {
		Optional<Categories> category = categoryRepositoer.findById(id);
		if (category.isPresent()) {
			return category.get();

		} else {
			return null;
		}
	}
	public void addCat(Products product, Categories category) {
		List<Products> prolist = category.getProducts();
		prolist.add(product);
		category.setProducts(prolist);
		categoryRepositoer.save(category);
		}
	public List<Products> findCategoryNotContains(Categories category) {
		return productRepositoer.findByCategoriesNotContains(category);
	}
	public void addProd(Categories category,Products product) {
		List<Categories> catlist = product.getCategories();
		catlist.add(category);
		product.setCategories(catlist);
		productRepositoer.save(product);
		}

}
