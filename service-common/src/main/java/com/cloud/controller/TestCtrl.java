package com.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.cloud.domain.TestVO;
import com.cloud.mapper.TestMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestCtrl {

    @Autowired
    private TestMapper testMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestCtrl.class);

    @ApiOperation(value = "测试用例",notes = "测试" )
    @ApiImplicitParam(name = "name",value = "用户姓名",required = true,dataType = "String")
    @GetMapping(value="/test/{name}")
    public String test(@PathVariable("name") String name){
        return "Hello," + name;
    }

    @PostMapping(path = "test1")
    public String rest(@RequestBody Map<String,Object> param) {
        LOGGER.info("print input parameter:" + param.get("name"));
        return "8888";
    }

    @PostMapping(path = "test2")
    public String rest2(String name,Integer age) {
        LOGGER.info("print input parameter:" + name + " age:" + age);
        return "8888";
    }

    @PostMapping(path="test3")
    public String rest3(TestVO testVO){
        LOGGER.info("print input parameter,TestVO:"+ JSON.toJSONString(testVO));
        return JSON.toJSONString(testVO);
    }

    @GetMapping("testSql")
    public String findUser(String name){
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("name",name);
        TestVO user = testMapper.queryUser(paramMap);
        if (user == null) return "-9999";
        return JSON.toJSONString(user);
    }
}
