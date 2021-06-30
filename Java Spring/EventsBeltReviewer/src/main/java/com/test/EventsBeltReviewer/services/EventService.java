package com.test.EventsBeltReviewer.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.test.EventsBeltReviewer.models.Event;
import com.test.EventsBeltReviewer.models.Message;
import com.test.EventsBeltReviewer.models.User;
import com.test.EventsBeltReviewer.repositories.EventRepositories;
import com.test.EventsBeltReviewer.repositories.MessageRepositories;
import com.test.EventsBeltReviewer.repositories.UserRepositories;

@Service
public class EventService {
	private final UserRepositories userRepository;
	private final EventRepositories eventRepository;
	private final MessageRepositories messageRepository;


	public EventService(UserRepositories userRepository,EventRepositories eventRepository,MessageRepositories messageRepository) {
		this.userRepository = userRepository;
		this.eventRepository=eventRepository;
		this.messageRepository=messageRepository;
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

	public List<Event> eventsInState(String state) {
		return eventRepository.findByState(state);
	}

	public List<Event> eventsOutOfState(String state) {
		
		return eventRepository.findByStateIsNot(state);
	}
	public Event createEvent(Event event) {
		return eventRepository.save(event);
		
	}

	public Event findEventById(Long event_id) {
		return eventRepository.findEventById(event_id);
	}

	public User updateUser(User attendee) {
		return userRepository.save(attendee);		
	}

	public void deleteEvent(Long event_id) {
		 eventRepository.deleteById(event_id);
	}

	public Event updateEvent( Event event) {
		return eventRepository.save(event);		
	}

	public MessageRepositories getMessageRepository() {
		return messageRepository;
	}

	public Message createMessage( Message message) {
		return messageRepository.save(message);
		
	}
	public Event findByIdEvent(Long id) {
		Optional<Event> optionalEvent = eventRepository.findById(id);
		if (optionalEvent.isPresent()) {
			return optionalEvent.get();
		} else {
			return null;
		}
	}
	public List<Message> findMessageeEvent(Event event) {
		return messageRepository.findByEvent(event);
	}

	

	



}
