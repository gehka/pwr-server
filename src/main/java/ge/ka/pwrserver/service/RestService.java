package ge.ka.pwrserver.service;

import ge.ka.pwrserver.model.Accelerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class RestService {

    @Value("${database.gateway.prefix}")
    private String dbPrefix;

    @Value("${baseURL}")
    private String baseURL;

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public String getPostsPlainJSON() {
        String url = "http://docker.cees.com.de:17005/" + this.dbPrefix + "acc";
        return this.restTemplate.getForObject(url, String.class);
    }

    public void doPost() {
        String url = this.baseURL + "accelerator";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Accelerator acc = new Accelerator(0, 21, 23, 42);
        HttpEntity<Accelerator> entity = new HttpEntity<>(acc, headers);
        this.restTemplate.postForObject(url, entity, Accelerator.class);
    }
}
