package com.cloud.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Source.class)
public class ProviderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProviderService.class);

    @Autowired
    private Source source;

    public void sendMessage(String msg){
        try {
            LOGGER.info(" message:" + msg);
            source.output().send(MessageBuilder.withPayload(msg).build());
        } catch (Exception e) {
            LOGGER.error("provider occur exception");
        }
    }
}
