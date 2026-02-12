package me.restApi;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class RestTemplateExamples {
    public static final String API_ROOT = "https://api.predic8.de:443/shop";

    //получить список покупателей
    @Test
    public void getCustomers(){
        String apiUrl = API_ROOT + "/customers/";

        RestTemplate restTemplate = new RestTemplate();
        JsonNode jsonNode = restTemplate.getForObject(apiUrl, JsonNode.class);
        System.out.println("Response");
        System.out.println(jsonNode.toString());
    }

    @Test
    public void getProducts(){
        String apiUrl = API_ROOT + "/products";

        RestTemplate restTemplate = new RestTemplate();
        JsonNode jsonNode = restTemplate.getForObject(apiUrl, JsonNode.class);
        System.out.println("Response");
        System.out.println(jsonNode.toString());
    }


    //создать нового покупателя
    @Test
    public void createCustomer(){
        String apiUrl = API_ROOT + "/customers/";
        RestTemplate restTemplate = new RestTemplate();

        //Java object to parse to JSON
        Map<String,Object> postMap = new HashMap<>();
        postMap.put("firstName", "Joe");
        postMap.put("lastName", "Buck");

        //"Method POST is not allowed"  currently

        JsonNode jsonNode = restTemplate.postForObject(apiUrl,postMap,JsonNode.class);
        System.out.println("Response");
        System.out.println(jsonNode.toString());


    }


}
