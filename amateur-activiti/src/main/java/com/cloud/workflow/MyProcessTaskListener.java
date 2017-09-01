package com.cloud.workflow;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyProcessTaskListener implements TaskListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyProcessTaskListener.class);
    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setVariable("auditOpinion",true);
        LOGGER.info("任务执行中：" + delegateTask.getTaskDefinitionKey());
    }
}
