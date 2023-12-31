package com.optimagrowth.license.service.client;

import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.optimagrowth.license.model.Organization;


@Component
public class OrganizationRestTemplateClient {
    private final RestTemplate restTemplate;

    public OrganizationRestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Organization getOrganization(String organizationId) {
        ResponseEntity<Organization> restExchange =
                restTemplate.exchange(
                        "http://organization-service/v1/organization/{organizationId}",
                        HttpMethod.GET,
                        null,
                        Organization.class,
                        organizationId
                );
        return restExchange.getBody();
    }
}
