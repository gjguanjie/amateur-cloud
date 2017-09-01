package com.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-common",fallback = TestHystrix.class)
public interface TestClient {

    @RequestMapping(value="/test/{name}", method = RequestMethod.GET)
    public String test(@PathVariable("name") String name);
}
