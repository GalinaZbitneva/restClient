package me.restApi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import me.restApi.services.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;


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
    public String formPost(Model model, ServerWebExchange serverWebExchange){
        //MultiValueMap — это структура данных (интерфейс в Spring, расширяющий Map<K, List<V>>),
        // которая позволяет сопоставить одному ключу несколько значений,
        // в отличие от обычной карты, где ключ уникален.
        MultiValueMap<String,String> map = serverWebExchange.getFormData().block();
        Integer limit;
        limit = Integer.valueOf((map.get("limit").get(0)));

        //log.debug("Received Limit value: " + limit);
        //default if null or zero
        if(limit == null || limit == 0){
            //log.debug("Setting limit to default of 5");
            limit = 5;
        }

        model.addAttribute("users", apiService.getUsers(limit));

        return "userlist";

    }

}
