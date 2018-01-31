package com.xsu.server.api.controller.demo;

import com.xsu.server.biz.DemoBiz;
import com.xsu.server.sdk.demo.DemoDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoBiz demoBiz;

    @RequestMapping("/demo")
    public String demo(){
        logger.info("this is demoController‘s logger");
        DemoDomain domain=demoBiz.demoShow("controller");
        System.out.println(domain);


        DemoDomain domain2=new DemoDomain();
        domain2.setDemoId(1L);
        domain2.setDemoName("demoName2");

        return domain2.toString();
    }
}
