package com.test.ControllersAndViews.repositeries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.ControllersAndViews.controllers.Users;
import com.test.ControllersAndViews.models.User;
	@Repository

	public interface UserRepositories extends CrudRepository<User, Long> {
	    User findByEmail(String email);

	}


