package com.xsu.server.api.controller.demo;

import com.xsu.server.biz.DemoBiz;
import com.xsu.server.sdk.demo.DemoDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoBiz demoBiz;

    @RequestMapping("/demo")
    public String demo(){
        DemoDomain domain=demoBiz.demoShow("controller");
        return "Greetings from Spring Boot demo!";
    }
}
