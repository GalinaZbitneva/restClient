package me.restApi.services;

import me.api.domain.User;
import me.api.domain.UserData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {
    //api.url установлен в application properties
    private RestTemplate restTemplate;

    private final String api_url;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
      //${api.url} позволяет взять параметр из файла application properties
        this.restTemplate = restTemplate;
        this.api_url = api_url;
    }

    @Override
    public List<User> getUsers(Integer limit) {
        List<User> userList = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users?_limit=", List.class);
        return userList;
    }


}
