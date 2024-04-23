package it.baldilorenzo.springsecurity.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "private", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PrivateController {

    @GetMapping("/auth")
    public String checkAuth(){
        return "It's all good.";
    }

}
