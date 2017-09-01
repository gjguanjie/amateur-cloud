package com.cloud.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RuleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RuleService.class);

    public void test(){
        LOGGER.info("测试drools全部变量");
    }
}
