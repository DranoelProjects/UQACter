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
		messages.add(new Message(Long.valueOf(1), new Date(new java.util.Date().getTime()), new String("Bonjour !"), "Mathias", "Léonard"));
		messages.add(new Message(Long.valueOf(2), new Date(new java.util.Date().getTime()), new String("Hello !"), "Léonard", "Mathias"));
		messages.add(new Message(Long.valueOf(3), new Date(new java.util.Date().getTime()), new String("Ola !"), "Léonard", "Patrick"));
		messages.add(new Message(Long.valueOf(4), new Date(new java.util.Date().getTime()), new String("Guten Tag !"), "Léonard", "Lucie"));
		messages.add(new Message(Long.valueOf(5), new Date(new java.util.Date().getTime()), new String("Buongiorno !"), "Lucie", "Mathias"));
		messages.add(new Message(Long.valueOf(6), new Date(new java.util.Date().getTime()), new String("Buenos Dias !"), "Robert", "Mathias"));
		messages.add(new Message(Long.valueOf(7), new Date(new java.util.Date().getTime()), new String("你好"), "Léonard", "Mathias"));
		
	}
	
	@Override
	public List<Message> findAll() {
		return messages;
	}

	@Override
	public Message findById(Long id) {
		for (Message message : messages) {
			if (message.getId() == id) {
				return message;
			}
		}
		return null;
	}
	
	@Override
	public List<Message> findByUsers(String userA, String userB) {
		List<Message> output = new ArrayList<>();
		for (Message message : messages) {
			if ((message.getEmitter().equals(userA) && message.getReceiver().equals(userB)) ||
			    (message.getEmitter().equals(userB) && message.getReceiver().equals(userA))) {
				output.add(message);
			}
		}
		return output;
	}

	@Override
	public Message save(Message message) {
		messages.add(message);
		return message;
	}

	@Override
	public List<String> findInterlocutors(String userA) {
		List<String> output = new ArrayList<>();
		
		for (Message message : messages) {
			if (message.getEmitter().equals(userA) && !output.contains(message.getReceiver())) {
				output.add(message.getReceiver());
			}
			if (message.getReceiver().equals(userA) && !output.contains(message.getEmitter())) {
				output.add(message.getEmitter());
			}
		}
					
		return output;
	}
	
}
