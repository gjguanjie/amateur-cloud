package com.cloud.workflow;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

import java.io.Serializable;

public class ProcessEndExecutionListener implements ExecutionListener,Serializable {

    private static final long serialVersionUID = -39492958944586459L;

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {

    }
}
