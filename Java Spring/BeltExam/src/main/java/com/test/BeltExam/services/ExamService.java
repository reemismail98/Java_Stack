package com.test.BeltExam.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.test.BeltExam.models.Course;
import com.test.BeltExam.models.User;
import com.test.BeltExam.repositories.CourseRepositories;
import com.test.BeltExam.repositories.UserRepositories;

@Service
	public class ExamService {
		private final UserRepositories userRepository;
		private final CourseRepositories courseRepository;
		
		public ExamService(UserRepositories userRepository,CourseRepositories courseRepository) {
			this.userRepository = userRepository;
			this.courseRepository = courseRepository;

			
		}

		public User registerUser(User user) {
			String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setPassword(hashed);
			return userRepository.save(user);
		}

		public User findByEmail(String email) {
			return userRepository.findByEmail(email);
		}

		// find user by id
		public User findUserById(Long id) {
			Optional<User> u = userRepository.findById(id);

			if (u.isPresent()) {
				return u.get();
			} else {
				return null;
			}
		}
		

		public boolean authenticateUser(String email, String password) {
			User user = userRepository.findByEmail(email);
			if (user == null) {
				return false;
			} else {
				if (BCrypt.checkpw(password, user.getPassword())) {
					return true;
				} else {
					return false;
				}
			}
		}
		

		public List<Course> allCourse() {
	        return courseRepository.findAll();
		}
		
		public Course createCourse(Course course) {
			return courseRepository.save(course);}
			
		public Course findCourseById(Long course_id) {
			return courseRepository.findCourseById(course_id);
		}
		public Course updateCourse( Course course) {
			return courseRepository.save(course);		
		}
	
		public User updateUser(User userAdded) {
			return userRepository.save(userAdded);	
		}
			
			
//			public Course updateCourse(Long id,Long capacity,String instructor,String cou) {
//			    Optional<Course> optionalc = courseRepository.findById(id);
//			if (optionalc.isPresent()) {
//				Course update=optionalc.get();
//				update.setId(id);
//				update.setCapacity(capacity);
//				update.setInstructor(instructor);
//				update.setCou(cou);
//			return courseRepository.save(update);}
//			else {
//				return null;
//			}
//			 }
		
			public void deleteCourse(Long course_id) {
				courseRepository.deleteById(course_id);
			}
			public void deleteUserFromCourse(Course course,User user) {
				List<User> u = course.getUsers();
				u.remove(user);
				courseRepository.save(course);
				}
}


