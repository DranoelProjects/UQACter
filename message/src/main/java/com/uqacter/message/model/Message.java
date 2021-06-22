package com.uqacter.message.model;

import java.util.Date;

public class Message {
	private int id;
	private Date date;
	private String text;
	private int emitter;
	private int receiver;
	
	public Message() {
		super();
	}

	public Message(int id, Date date, String text, int emitter, int receiver) {
		super();
		this.id = id;
		this.date = date;
		this.text = text;
		this.emitter = emitter;
		this.receiver = receiver;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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

	public int getEmitter() {
		return emitter;
	}

	public void setEmitter(int emitter) {
		this.emitter = emitter;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", date=" + date + ", text=" + text + ", emitter=" + emitter + ", receiver="
				+ receiver + "]";
	}
	
}
