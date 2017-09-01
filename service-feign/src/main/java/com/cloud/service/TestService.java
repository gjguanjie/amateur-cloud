package com.cloud.service;

import com.cloud.controller.TestCtrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class TestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestCtrl.class);

    @Autowired
    private TestClient testClient;


    @RequestMapping(value="/test/{name}", method = RequestMethod.GET)
    public String test(@PathVariable("name") String name){
        LOGGER.info("进入测试方法区：");
        return testClient.test(name);
    }
}
