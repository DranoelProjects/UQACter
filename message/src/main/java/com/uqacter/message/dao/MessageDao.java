package com.uqacter.message.dao;

import java.util.List;

import com.uqacter.message.model.Message;

public interface MessageDao {
	public List<Message>findAll();
	public Message findById(int id);
	public Message save(Message message);
}
