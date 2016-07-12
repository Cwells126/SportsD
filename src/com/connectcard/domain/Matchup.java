package com.connectcard.domain;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="MATCHUP")
public class Matchup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="GAME_ID")
	private Integer gameId;
	

	@Column(name="GAME_TIME", nullable=false)
	private Integer gameTime;
	
	@Column(name="HOME_TEAM", nullable=false)
	private Integer homeTeam;
	
	@Column(name="AWAY_TEAM", nullable=false)
	private Integer awayTeam;
	
	@Column(name="AWAY_NM", nullable=true)
	private String awayNm;
	
	@Column(name="HOME_NM", nullable=true)
	private String homeNm;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AWAY_TEAM", nullable = false, insertable = false, updatable = false)
	private Team awayTeamInfo;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "HOME_TEAM", nullable = false, insertable = false, updatable = false)
	private Team homeTeamInfo;
	
	
	
	
	public Integer getGameTime() {
		return gameTime;
	}


	public void setGameTime(Integer gameTime) {
		this.gameTime = gameTime;
	}


	public Bet getBet() {
		return bet;
	}


	public void setBet(Bet bet) {
		this.bet = bet;
	}


	public Integer getHomeTeam() {
	    return this.homeTeam;
	}
	
	
	public void setHomeTeam(Integer homeTeam) {
		this.homeTeam = homeTeam;
	}

	
	public Integer getAwayTeam() {
	    return this.awayTeam;
	}
	
	
	public void setAwayTeam(Integer awayTeam) {
		this.awayTeam = awayTeam;
	}
	
	
	public String getAwayNm() {
		return awayNm;
	}


	public void setAwayNm(String awayNm) {
		this.awayNm = awayNm;
	}


	public String getHomeNm() {
		return homeNm;
	}


	public void setHomeNm(String homeNm) {
		this.homeNm = homeNm;
	}


	public void setWeek(Short week) {
		this.week = week;
	}





	@Column(name="LINE", nullable=false)
	private Float line;
	
	@Column(name="GAME_DATE", nullable=true)
	private Calendar gameDate;
	
	@Column(name="HOME_SCORE", nullable=true)
	private Float homeScore;
	
	@Column(name="AWAY_SCORE", nullable=true)
	private Float awayScore;
	
	@Column(name="WEEK", nullable=false, columnDefinition = "int")
	private Short week;
	
	
	@OneToOne
    @JoinColumn(name="ID_MATCHUP")
	private Bet bet;
	
	public Matchup(Integer gameId, int homeTeam,int awayTeam, Float line, Calendar gameDate , Integer gameTime, short week, Bet bet) {
		super();
		this.gameId = gameId;
		this.awayTeam = awayTeam;
		this.line = line;
		this.gameDate = gameDate;
		this.week = week;
		this.bet = bet;
		this.gameTime = gameTime;
	}
	

	public Matchup() {}

	

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	
	
	public short getWeek() {
		return week;
	}

	public void setWeek(short week) {
		this.week = week;
	}

	

	
	public Float getLine() {
		return line;
	}

	public void setLine(Float line) {
		this.line = line;
	}

	public Calendar getGameDate() {
		return gameDate;
	} 	

	public void setGameDate(Calendar gameDate) {
		this.gameDate = gameDate;
	}
	
		public void setHomeScore(Float homeScore) {
		this.homeScore = homeScore;
	}
	

	public Float getHomeScore() {
		return homeScore;
	}
	
	public void setAwayScore(Float awayScore) {
		this.awayScore = awayScore;
	}
	
	public Float getAwayScore() {
		return awayScore;
	}
	
	

	public Team getAwayTeamInfo() {
		return this.awayTeamInfo;
	}


	public Team getHomeTeamInfo() {
		return homeTeamInfo;
	}


	public void setHomeTeamInfo(Team homeTeamInfo) {
		this.homeTeamInfo = homeTeamInfo;
	}


	public void setAwayTeamInfo(Team awayTeamInfo) {
		this.awayTeamInfo = awayTeamInfo;
	}
	
	


	
}
