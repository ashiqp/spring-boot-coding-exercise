package com.telstra.codechallenge.userSearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

	private Long id;
	
	private String login;
	
	@JsonProperty("html_url")
	private String htmlUrl;
	
	
}
