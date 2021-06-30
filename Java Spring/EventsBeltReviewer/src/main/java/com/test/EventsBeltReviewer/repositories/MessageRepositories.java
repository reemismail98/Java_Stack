package com.test.EventsBeltReviewer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.EventsBeltReviewer.models.Event;
import com.test.EventsBeltReviewer.models.Message;

@Repository
public interface MessageRepositories extends CrudRepository<Message, Long>{

	List<Message> findByEvent(Event event);

}
