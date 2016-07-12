package com.connectcard.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TEAM")
public class Team implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7421855346691766864L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID_TEAM")
	private int idTeam;
	
	@Column(name="TEAM_NM")
	private String teamNm;
	
	@Column(name="LOGO_URL")
	private String logoUrl;
	
	
	
	

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public int getIdTeam() {
		return this.idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}

	public String getTeamNm() {
		return this.teamNm;
	}

	public void setTeamNm(String teamNm) {

		this.teamNm = teamNm;
	}


}
