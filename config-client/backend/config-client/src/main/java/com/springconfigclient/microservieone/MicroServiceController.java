package com.springconfigclient.microservieone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MicroServiceController {

    @Autowired
    GeneralSpringConfiguration generalSpringConfiguration;

    @GetMapping("/endpoint")
    public String retrieveLimits(){
     return null;
    }
}