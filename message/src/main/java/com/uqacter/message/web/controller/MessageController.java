package com.uqacter.message.web.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uqacter.message.dao.MessageDao;
import com.uqacter.message.model.Message;

@RestController
public class MessageController {
	@Autowired
	private MessageDao messageDao;
	
	@RequestMapping(value="/Messages", method=RequestMethod.GET)
    public List<Message> listMessages() {
        return messageDao.findAll();
    }
	
	@GetMapping(value = "/Messages/{id}")
	public Message printMessage(@PathVariable int id) {
		return messageDao.findById(id);
	}
	
	@GetMapping(value = "/Messages/{idUserA}/{idUserB}")
	public List<Message> printConversation(@PathVariable int idUserA, @PathVariable int idUserB) {
		return messageDao.findByUsers(idUserA, idUserB);
	}
	
	@PostMapping(value = "/Messages")
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
