package com.connectcard.domain;
 import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.connectcard.domain.StadiumDetails;
 @Entity
 @Table(name="SCHEDULE")
public class Schdule {
	

	    @OneToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "STADIUM_DETAILS", nullable = false, insertable = false, updatable = false)
	private StadiumDetails StadiumDetails;
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="ID_SCHEDULE")
		private int idSchedule;
    
		
		
		
		public int getIdSchedule() {
			return idSchedule;
		}
		public void setIdSchedule(int idSchedule) {
			this.idSchedule = idSchedule;
		}
		public Calendar getCalendar() {
			return Calendar;
		}
		public void setCalendar(Calendar calendar) {
			Calendar = calendar;
		}
		public void setStadiumDetails(int stadiumDetails) {
			this.stadiumDetails = stadiumDetails;
		}
		@Column(name="GAME_KEY")
		private int GameKey;
    
		@Column(name="STADIUM_DETAILS", nullable=true)
		private int stadiumDetails;
		
		@Column(name="SEASON_TYPE", nullable=true)
		private String SeasonType;
		@Column(name="SEASON",
				nullable=true)	
		private String Season;
		
		@Column(name="WEEK", nullable=true)	
		private String Week;
		
		@Column(name="GAME_DATE", nullable=true)	
    private Calendar Calendar;
		@Column(name="AWAY_TEAM", nullable=false)
    	private String AwayTeam;
		@Column(name="HOME_TEAM", nullable=false)
		private String HomeTeam;
		@Column(name="CHANNEL", nullable=true)
		private String Channel;
		@Column(name="FORCAST_TEMP_LOW", nullable=true)
    private String ForecastTempLow;
		@Column(name="FORCAST_TEMP_HIGH", nullable=true)
    private String ForecastTempHigh;
		@Column(name="FORCAST_DESCRIPTON", nullable=true)
    private String ForecastDescription;
		@Column(name="FORCAST_WIND_CHILL", nullable=true)
    private String ForecastWindChill;

	    @Column(name="FORCAST_WIND_SPEED", nullable=true)
    private String ForecastWindSpeed;
    @Column(name="AWAY_TEAM_MONEY_LINE", nullable =true)
    private String AwayTeamMoneyLine;
    @Column(name="HOME_TEAM_MONEY_LINE", nullable =true)
    private String HomeTeamMoneyLine;
    @Column(name="OVER_UNDER", nullable =true)
    private String OverUnder;
    @Column(name="STADIUM_ID", nullable =true)
    private int StadiumId;
    @Column(name="GEO_LAT", nullable =true)
    private String GeoLat;
    @Column(name="GEO_LONG", nullable =true)
    private String GeoLong;
    

	public StadiumDetails getStadiumDetails() {
		return StadiumDetails;
	}
	public void setStadiumDetails(StadiumDetails stadiumDetails) {
		StadiumDetails = stadiumDetails;
	}
	public long getGameKey() {
		return GameKey;
	}
	public void setGameKey(int gameKey) {
		GameKey = gameKey;
	}
	public String getSeasonType() {
		return SeasonType;
	}
	public void setSeasonType(String seasonType) {
		SeasonType = seasonType;
	}
	public String getSeason() {
		return Season;
	}
	public void setSeason(String season) {
		Season = season;
	}
	public String getWeek() {
		return Week;
	}
	public void setWeek(String week) {
		Week = week;
	}
	public Calendar getDate() {
		return Calendar;
	}
	public void setDate(Calendar cal) {
		Calendar = cal;
	}
	public String getAwayTeam() {
		return AwayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		AwayTeam = awayTeam;
	}
	public String getHomeTeam() {
		return HomeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		HomeTeam = homeTeam;
	}
	public String getChannel() {
		return Channel;
	}
	public void setChannel(String channel) {
		Channel = channel;
	}
	public String getForecastTempLow() {
		return ForecastTempLow;
	}
	public void setForecastTempLow(String forecastTempLow) {
		ForecastTempLow = forecastTempLow;
	}
	public String getForecastTempHigh() {
		return ForecastTempHigh;
	}
	public void setForecastTempHigh(String forecastTempHigh) {
		ForecastTempHigh = forecastTempHigh;
	}
	public String getForecastDescription() {
		return ForecastDescription;
	}
	public void setForecastDescription(String forecastDescription) {
		ForecastDescription = forecastDescription;
	}
	public String getForecastWindChill() {
		return ForecastWindChill;
	}
	public void setForecastWindChill(String forecastWindChill) {
		ForecastWindChill = forecastWindChill;
	}
	public String getForecastWindSpeed() {
		return ForecastWindSpeed;
	}
	public void setForecastWindSpeed(String forecastWindSpeed) {
		ForecastWindSpeed = forecastWindSpeed;
	}
	public String getAwayTeamMoneyLine() {
		return AwayTeamMoneyLine;
	}
	public void setAwayTeamMoneyLine(String awayTeamMoneyLine) {
		AwayTeamMoneyLine = awayTeamMoneyLine;
	}
	public String getHomeTeamMoneyLine() {
		return HomeTeamMoneyLine;
	}
	public void setHomeTeamMoneyLine(String homeTeamMoneyLine) {
		HomeTeamMoneyLine = homeTeamMoneyLine;
	}
	public String getOverUnder() {
		return OverUnder;
	}
	public void setOverUnder(String overUnder) {
		OverUnder = overUnder;
	}
	public int getStadiumId() {
		return StadiumId;
	}
	public void setStadiumId(int stadiumId) {
		StadiumId = stadiumId;
	}
	public String getGeoLat() {
		return GeoLat;
	}
	public void setGeoLat(String geoLat) {
		GeoLat = geoLat;
	}
	public String getGeoLong() {
		return GeoLong;
	}
	public void setGeoLong(String geoLong) {
		GeoLong = geoLong;
	}
    
    
    
    
    
}
