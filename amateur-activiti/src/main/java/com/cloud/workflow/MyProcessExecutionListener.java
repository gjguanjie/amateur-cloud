package com.cloud.workflow;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyProcessExecutionListener implements ExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyProcessExecutionListener.class);
    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info(" 获取流程变量:"+delegateExecution.getVariable("auditOpinion"));
    }
}
