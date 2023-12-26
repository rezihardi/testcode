package com.sml.testcode.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sml.testcode.model.DataNation;
import com.sml.testcode.model.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

@Service
public class KaryawanService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KaryawanService.class);
    RestTemplate restTemplate = new RestTemplate();
    public void testReactor(){
        Flux<String> flux = Flux.just("Hello", "World").map(s -> s.toUpperCase()).doOnNext(s -> System.out.println("Processing: " + s));

        flux.subscribe(s -> System.out.println("Subscriber 1: " + s));

        flux.subscribe(s -> System.out.println("Subscriber 2: " + s));
    }

    public Object getFile() {

        HttpHeaders headers = new HttpHeaders();
        String response = null;
        try {
            HttpEntity<?> entity = new HttpEntity<>(headers);
            response = restTemplate
                    .exchange("https://dummy.restapiexample.com/api/v1/employees", HttpMethod.GET, entity, String.class)
                    .getBody();
            System.out.println(response);
        } catch (Exception e) {
            LOGGER.info("Failed Hit", e);
        }
        return response;
    }

    public DataNation responseData (Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = object.toString();
        return objectMapper.readValue(jsonString, DataNation.class);
    }

    public void posterRestTemplate(Mail mail){
        String response;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-msisdn", "6281219703071");
            headers.setContentType(MediaType.APPLICATION_JSON);
            mail.setName(mail.getName());
            HttpEntity<?> entity = new HttpEntity<>(mail, headers);
            response = restTemplate
                    .exchange("https://httpbin.org/post", HttpMethod.POST, entity, String.class)
                    .getBody();
            System.out.println(response.getClass().getSimpleName());
            LOGGER.info("response template " + response);
        } catch (Exception e){
            LOGGER.info("Failed Hit", e);
        }
    }
}
