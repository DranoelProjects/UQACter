package com.uqacter.message.web.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uqacter.message.dao.MessageDao;
import com.uqacter.message.model.Message;

@RestController
public class MessageController {
	@Autowired
	private MessageDao messageDao;
	
	@GetMapping(path = "/messages/", produces = "application/json")
    public List<Message> listMessages() {
        return messageDao.findAll();
    }
	
	@GetMapping(path = "/messages/{id}", produces = "application/json")
	public Message printMessage(@PathVariable Long id) {
		return messageDao.findById(id);
	}
	
	@GetMapping(path = "/messages/{userA}/{userB}", produces = "application/json")
	public List<Message> printConversation(@PathVariable String userA, @PathVariable String userB) {
		return messageDao.findByUsers(userA, userB);
	}
	
	@GetMapping(path = "/messages/conversations/{userA}", produces = "application/json")
	public List<String> printInterlocutor(@PathVariable String userA) {
		return messageDao.findInterlocutors(userA);
	}
	
	@PostMapping(path = "/messages/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Void> addMessage(@RequestBody Message message) {
		Message messageAdded = messageDao.save(message);

		if (messageAdded == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(messageAdded.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
}
