package com.connectcard.domain;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BET")
public class Bet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3859244164395650937L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BET")
	private int bet;

	
	@Column(name="AMOUNT")
	private Float amount;
	
	@Column(name="BET_DT")
	private Date betDt;
	
	@OneToOne
    @JoinColumn(name="ID_MATCHUP")
	private Matchup matchup;
	
	@OneToOne
    @JoinColumn(name="USER1_PK")
	private Team user1Pk;
	
	@OneToOne
    @JoinColumn(name="USER2_PK")
	private Team user2Pk;
	


	public Bet() {
	}

	public Bet(int bet) {
		this.bet = bet;
	}

	public Bet(int bet,  Float amount, Date betDt) {
		this.bet = bet;
		this.amount = amount;
		this.betDt = betDt;
	}


	public int getBet() {
		return this.bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}
	
	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Date getBetDt() {
		return this.betDt;
	}

	public void setBetDt(Date betDt) {
		this.betDt = betDt;
	}

	public Matchup getMatchup() {
		return matchup;
	}

	public void setMatchup(Matchup matchup) {
		this.matchup = matchup;
	}

	public Team getUser1Pk() {
		return user1Pk;
	}

	public void setUser1Pk(Team user1Pk) {
		this.user1Pk = user1Pk;
	}

	public Team getUser2Pk() {
		return user2Pk;
	}

	public void setUser2Pk(Team user2Pk) {
		this.user2Pk = user2Pk;
	}
	

}
