package com.connectcard.domain;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User implements java.io.Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 4924458258697619457L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_USER")
	private int idUser;
	
	@Column(name="USER_NM")
	private String userNm;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;

	
	
	private String nmUser;
	private String emailUser;

	private String tempPassword;
	
	@Column(name="CREATE_TIME")
	private Date createTime;
	  

	public User() {
	}

	public User(int idUser, String userNm, String password) {
		this.idUser = idUser;
		this.userNm = userNm;
		this.password = password;
	}

	public User(int idUser, String userNm, String email, String password,
			Date createTime) {
		this.idUser = idUser;
		this.userNm = userNm;
		this.email = email;
		this.password = password;
		this.createTime = createTime;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUserNm() {
		return this.userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNmUser() {
		return nmUser;
	}

	public void setNmUser(String nmUser) {
		this.nmUser = nmUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
