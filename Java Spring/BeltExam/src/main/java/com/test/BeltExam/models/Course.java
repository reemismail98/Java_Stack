package com.test.BeltExam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

	@Entity
	@Table(name = "courses")
	public class Course {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Min(1)
		private Long capacity;
		
		@NotEmpty(message = " instructor is required!")
		private String instructor;
		@NotEmpty(message = "Name is required!")
		@NotEmpty(message = " course is required!")
		private String cou;
		

		@Column(updatable = false)
		private Date createdAt;
		private Date updatedAt;
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(name = "students_courses",
		joinColumns = @JoinColumn(name = "course_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id"))
		private List<User> users;
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "user_id")
		private User user;

		public Course() {
		}
		
		
		public Course(Long id,Long capacity,String instructor,String cou) {
			this.id = id;
			this.capacity = capacity;
			this.instructor = instructor;
			this.cou = cou;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		
		public Long getCapacity() {
			return capacity;
		}


		public String getCou() {
			return cou;
		}


		public void setCou(String cou) {
			this.cou = cou;
		}


		public void setCapacity(Long capacity) {
			this.capacity = capacity;
		}


		public String getInstructor() {
			return instructor;
		}


		public void setInstructor(String instructor) {
			this.instructor = instructor;
		}


		public Date getCreatedAt() {
			return createdAt;
		}


		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}


		public Date getUpdatedAt() {
			return updatedAt;
		}


		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}


		public List<User> getUsers() {
			return users;
		}


		public void setUsers(List<User> users) {
			this.users = users;
		}


		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
}
