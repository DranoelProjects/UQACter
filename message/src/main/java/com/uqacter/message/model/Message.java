package com.uqacter.message.model;

import java.util.Date;

public class Message {
	private Long id;
	private Date date;
	private String text;
	private String emitter;
	private String receiver;
	
	public Message() {
		super();
	}

	public Message(Long id, Date date, String text, String emitter, String receiver) {
		super();
		this.id = id;
		this.date = date;
		this.text = text;
		this.emitter = emitter;
		this.receiver = receiver;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmitter() {
		return emitter;
	}

	public void setEmitter(String emitter) {
		this.emitter = emitter;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", date=" + date + ", text=" + text + ", emitter=" + emitter + ", receiver="
				+ receiver + "]";
	}
	
}
