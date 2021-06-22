package com.uqacter.message.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uqacter.message.model.Message;

@Repository
public class MessageDaoImpl implements MessageDao {

	public static List<Message> messages = new ArrayList<>();
	static {
		messages.add(new Message(1, new Date(new java.util.Date().getTime()), new String("Bonjour !"), 0, 1));
		messages.add(new Message(2, new Date(new java.util.Date().getTime()), new String("Hello !"), 1, 0));
	}
	
	@Override
	public List<Message> findAll() {
		return messages;
	}

	@Override
	public Message findById(int id) {
		for (Message message : messages) {
			if (message.getId() == id) {
				return message;
			}
		}
		return null;
	}

	@Override
	public Message save(Message message) {
		messages.add(message);
		return message;
	}

}
