package com.telstra.codechallenge.userSearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSearchResponseDTO {

	@JsonProperty("items")
	private Account[] accounts;

}
