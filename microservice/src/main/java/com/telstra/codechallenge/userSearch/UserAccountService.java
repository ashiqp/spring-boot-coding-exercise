package com.telstra.codechallenge.userSearch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserAccountService {

	@Value("${userAccounts.base.url}")
	private String accountsBaseUrl;

	private RestTemplate restTemplate;

	public UserAccountService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Account[] getOldNoFollowersAccounts(Long count) {

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(accountsBaseUrl).queryParam("q", "followers:0")
				.queryParam("sort", "joined").queryParam("order", "asc").queryParam("per_page", count);

		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		HttpEntity<UserSearchResponseDTO> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, UserSearchResponseDTO.class);

		return response.getBody().getAccounts();
	}
}
