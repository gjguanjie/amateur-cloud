package com.cloud.service;

import org.springframework.stereotype.Component;

@Component
public class TestHystrix implements TestClient {
    @Override
    public String test(String name) {
        return "-9999";
    }
}
