package com.test.BeltExam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.BeltExam.models.Course;

	@Repository
	public interface CourseRepositories extends CrudRepository<Course, Long>{
		List<Course> findAll();

		Course findCourseById(Long course_id);
}
