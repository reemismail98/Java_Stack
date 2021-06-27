package com.test.ProductsAndCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.ProductsAndCategories.models.Categories;
import com.test.ProductsAndCategories.models.Products;

@Repository
public interface ProductRepositoer extends CrudRepository<Products, Long>{
	    List<Products> findAll();

		List<Products> findByCategoriesNotContains(Categories category);

	}

