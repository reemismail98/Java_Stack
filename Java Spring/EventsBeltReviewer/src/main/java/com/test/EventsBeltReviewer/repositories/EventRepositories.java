package com.test.EventsBeltReviewer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.EventsBeltReviewer.models.Event;
import com.test.EventsBeltReviewer.models.Message;
import com.test.EventsBeltReviewer.models.User;

@Repository
public interface EventRepositories extends CrudRepository<Event, Long>{

	List<Event> findByStateEquals(String state);

	//List<Event> findByStateNotLike(String state);

	List<Event> findByStateIsNot(String state);

	List<Event> findByState(String state);

	Event findEventById(Long event_id);


}
