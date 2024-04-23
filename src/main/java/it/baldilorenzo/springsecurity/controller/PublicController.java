package it.baldilorenzo.springsecurity.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "public", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PublicController {

    @GetMapping("/no-auth")
    public String checkNoAuth(){
        return "It's all good.";
    }

}
