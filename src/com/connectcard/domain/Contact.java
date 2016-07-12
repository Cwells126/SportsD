package com.connectcard.domain;

public class Contact {
	
	
	private int idUser;
	private int idContact;
	private String nmUser;
	private String state;
	private String email;
	private String name;
	private String subject;
	private String message;
	private String tempPassword;
	
	public Contact() {
	}



	public int getIdUser() {
		return idUser;
	}



	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}



	public int getIdContact() {
		return idContact;
	}



	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}





	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getNmUser() {
		return nmUser;
	}



	public void setNmUser(String nmUser) {
		this.nmUser = nmUser;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTempPassword() {
		return tempPassword;
	}



	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}
    
	
	
    
    

}
