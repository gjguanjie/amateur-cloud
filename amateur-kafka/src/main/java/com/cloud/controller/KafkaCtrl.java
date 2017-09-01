package com.cloud.controller;


import com.cloud.consumer.ConsumerService;
import com.cloud.provider.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaCtrl {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaCtrl.class);


    @Autowired
    private ProviderService providerService;

    @Autowired
    private ConsumerService consumerService;


    @GetMapping("provider/{msg}")
    public void provide(@PathVariable("msg") String msg){
        providerService.sendMessage(msg);
    }


}

