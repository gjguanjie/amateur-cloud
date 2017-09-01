package com.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.lang.ArithmeticException;
import java.lang.Exception;

@RefreshScope
@Service
public class TestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);

    private static final String COMMON_SERVICE="http://service-common/";

    @Value("${aaa}")
    private String aaa;

    @Autowired
    private RestTemplate restTemplate;

    public String test(){
        if (null != aaa && !"".equals(aaa)){
            LOGGER.info("返回正常aaa值：" + aaa);
            return aaa;
        }
        LOGGER.info("返回非正常aaa值：-9999");
        return "-9999";
    }

    //方法级重试，Retryable，重试，最大重试次数为3，间隔1s后重试，当重试失败后根据异常类型调用类
    @Retryable(value = {ArithmeticException.class,Exception.class},maxAttempts = 3,backoff = @Backoff(value = 1000L))
    //@HystrixCommand(fallbackMethod = "testFallBack")
    public String test2(){
        int aa = 0 ,bb = 1;
        LOGGER.info("进入test2");
        try {
            int cc = bb/aa;
        } catch (ArithmeticException e){
            throw new ArithmeticException(e.getMessage());
        }

        return "0000";
    }


    public String test3(String name){
        return restTemplate.getForObject(COMMON_SERVICE + "/test/" + name, String.class);
    }


    //与@Retryable的异常类型对应
    @Recover
    public void recoverRuntimeException(ArithmeticException e){
        //LOGGER.error("********************"+e.getMessage());
        LOGGER.info("发生runtime exception");
    }

    @Recover
    public void recoverException(Exception e){
        LOGGER.info("发生exeception");
    }

    public String testFallBack(){
        LOGGER.info("进入融断方法");
        return "-9999";
    }


}
