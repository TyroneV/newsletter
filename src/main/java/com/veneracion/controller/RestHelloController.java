package com.veneracion.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class RestHelloController {

    @RequestMapping("/hello")
    public String index() {
        return "Hello World!!!!";
    }

}
