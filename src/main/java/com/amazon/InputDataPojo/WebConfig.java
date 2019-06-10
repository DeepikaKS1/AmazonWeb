package com.amazon.InputDataPojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"ValidLogin"})
public class WebConfig {
	
	@JsonProperty("ValidLogin")
	private List<ValidLogin> validLogin = null;
	
	@JsonProperty("ValidLogin")
	public List<ValidLogin> getValidLogin(){
		return validLogin;
	}
	
	@JsonProperty("ValidLogin")
    public void setValidLogin(List<ValidLogin> validLogin) {
        this.validLogin = validLogin;
    }
}
