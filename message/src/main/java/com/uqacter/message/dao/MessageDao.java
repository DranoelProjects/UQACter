package com.uqacter.message.dao;

import java.util.List;

import com.uqacter.message.model.Message;

public interface MessageDao {
	public List<Message>findAll();
	public Message findById(Long id);
	public List<Message> findByUsers(String userA, String userB);
	public Message save(Message message);
	public List<String> findInterlocutors(String userA);
}
