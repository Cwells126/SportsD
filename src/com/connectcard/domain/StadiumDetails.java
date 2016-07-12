package com.connectcard.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="STADIUM_DETAILS")
public class StadiumDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STADIUM_ID")
        private int stadiumID;
		@Column(name="NAME")
        private String name;
		@Column(name="CITY")
        private String city;
		
		@Column(name="STATE")
        private String state;
		@Column(name="COUNTRY")
        private String country;
		@Column(name="PLAYING_SURFACE")
        private String PlayingSurface;
        
		@Column(name="GEO_LAT")
		private String GeoLat;
		
		@Column(name="GEO_LONG")
        private String GeoLong;
        

        public enum Status {
                CREATED, ASSIGNED, CANCELED, COMPLETED
        }

        public StadiumDetails(int id) {
         
        }

        
        public long getStadiumID() {
			return stadiumID;
		}


		public void setStadiumID(int stadiumID) {
			this.stadiumID = stadiumID;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getCity() {
			return city;
		}


		public void setCity(String city) {
			this.city = city;
		}


		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}


		public String getCountry() {
			return country;
		}


		public void setCountry(String country) {
			this.country = country;
		}


		public String getPlayingSurfaxce() {
			return PlayingSurface;
		}


		public void setPlayingSurfaxce(String playingSurfaxce) {
			PlayingSurface = playingSurfaxce;
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


		@Override
        public String toString() {
//                return "Task [id=" + id + ", summary=" + summary + ", description=" + description + ", status=" + status
//                                + ", priority=" + priority + "]";
			return "";
        }

}
