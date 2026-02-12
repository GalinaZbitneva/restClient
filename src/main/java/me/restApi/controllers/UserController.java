package me.restApi.controllers;

import lombok.extern.slf4j.Slf4j;
import me.api.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import me.restApi.services.ApiService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import tools.jackson.databind.JsonNode;

import java.util.List;


@Slf4j
@Controller
public class UserController {
    private ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }
    @GetMapping({"","/", "/index"})
    public String index(){
        return "index";
    }

    @PostMapping("/users/")
    public String getUsers(Model model){
        model.addAttribute("users",  apiService.getUsers(10));
        List<User> userList = apiService.getUsers(10);
        //System.out.println("Response");
        //System.out.println(userList.toString());

        return "userlist";


    }






}
