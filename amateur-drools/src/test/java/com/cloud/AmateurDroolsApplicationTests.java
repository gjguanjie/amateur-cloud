package com.cloud;

import com.cloud.domain.Message;
import com.cloud.domain.Person;
import com.cloud.service.RuleService;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.io.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmateurDroolsApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(AmateurDroolsApplicationTests.class);

    private static final String RULES_PATH = "rules";

    @Autowired
    private KieSession kieSession;

    @Autowired
    private StatelessKieSession statelessKieSession;

    @Autowired
    private RuleService ruleService;

    /**
     * 有状态测试
     */
    @Test
    public void contextLoads() {

		/*
        Message msg = new Message();
		msg.setMessage("Hello World");
		msg.setStatus(Message.HELLO);
		//将实体类插入执行规则
		kieSession.insert(msg);
		kieSession.fireAllRules();
		LOGGER.info("输出msg值：" + msg.getMessage());*/
        StopWatch sw = new StopWatch("state");
        sw.start();
        for (int ii = 0; ii < 100000; ii++) {
            Person person = new Person();
            person.setType("YOUNG");
            person.setAge(50);
            person.setValue(ii);
            kieSession.setGlobal("ruleService", ruleService);
            kieSession.insert(person);
            kieSession.fireAllRules();
            LOGGER.info("执行完结果第" + ii + " 值：" + person.getName());
        }
        sw.stop();
        LOGGER.info("用时：" + sw.getTotalTimeSeconds());

    }


    /**
     * 无状态测试
     */
    @Test
    public void test() {

        StopWatch sw = new StopWatch("stateless");
        sw.start();
        for (int ii = 0; ii < 100000; ii++) {
            Person person = new Person();
            person.setType("YOUNG");
            person.setAge(50);
            person.setValue(ii);
            kieSession.setGlobal("ruleService", ruleService);
            statelessKieSession.setGlobal("ruleService", ruleService);
            statelessKieSession.execute(person);
            LOGGER.info("执行完结果：" + person.getName());
        }
        sw.stop();
        LOGGER.info("用时：" + sw.getTotalTimeSeconds());


    }

}
