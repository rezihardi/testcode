package com.sml.testcode.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sml.testcode.model.DataNation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
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
//        headers.setAccept(Collections.singletonList(MediaType.parseMediaType("text/plain")));
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
        System.out.println(object.toString());
        String jsonString = object.toString();
        return objectMapper.readValue(jsonString, DataNation.class);
    }
}
