package com.test.BeltExam.repositories;

	import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.BeltExam.models.User;

	@Repository
	public interface UserRepositories extends CrudRepository<User, Long>{

		User findByEmail(String email);
}
