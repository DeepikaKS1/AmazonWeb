package com.amazon.InputDataPojo;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//import com.fasterxml.jackson.annotation.JsonAnyGetter;
//import com.fasterxml.jackson.annotation.JsonAnySetter;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Email", "Password", })

public class ValidLogin {
	@JsonProperty("Email")
	private String email;
	@JsonProperty("Password")
	private String password;
	 @JsonIgnore
	    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	    @JsonProperty("Email")
	    public String getEmail() {
	        return email;
	    }

	    @JsonProperty("Email")
	    public void setEmail(String email) {
	        this.email = email;
	    }

	    @JsonProperty("Password")
	    public String getPassword() {
	        return password;
	    }

	    @JsonProperty("Password")
	    public void setPassword(String password) {
	        this.password = password;
	    }
	    
	    @JsonAnyGetter
	    public Map<String, Object> getAdditionalProperties() {
	        return this.additionalProperties;
	    }

	    @JsonAnySetter
	    public void setAdditionalProperty(String name, Object value) {
	        this.additionalProperties.put(name, value);
	    }
}
