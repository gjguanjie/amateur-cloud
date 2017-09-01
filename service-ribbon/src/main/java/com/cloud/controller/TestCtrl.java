package com.cloud.controller;


import com.cloud.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCtrl {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestCtrl.class);

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String test(){
        return testService.test();
    }

    @RequestMapping("/test2")
    public String test2(){
       return testService.test2();
    }

    @RequestMapping("/test3/{name}")
    public String test3(@PathVariable("name") String name){
        return testService.test3(name);
    }


}
