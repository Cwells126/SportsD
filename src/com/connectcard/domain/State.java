package com.connectcard.domain;

public class State {
	
	private String state;
	
	private int stateId; 
	
	private String stateCode;
	

	public State(int stateId) {
		this.stateId = stateId;
	}
	
	
	public State() {
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getStateId() {
		return stateId;
	}


	public void setStateId(int stateId) {
		this.stateId = stateId;
	}


	public String getStateCode() {
		return stateCode;
	}


	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	
	
	
	

}
