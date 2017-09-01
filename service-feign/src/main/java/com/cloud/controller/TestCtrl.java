package com.cloud.controller;

import com.cloud.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCtrl {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestCtrl.class);

    @Autowired
    private TestService testService;


    @RequestMapping(value="/test/{name}", method = RequestMethod.GET)
    public String test(@PathVariable("name") String name){
        LOGGER.info("进入测试方法区：");
        return testService.test(name);
    }

}
