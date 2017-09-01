package com.cloud.workflow;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class MyBean implements Serializable {
    private static final long serialVersionUID = 5746072282781906830L;

    public void print(){
        System.out.println("print content by print()");
    }

    public String print(String name){
        System.out.println("print content by print(name) ,value is:" + name);
        return name += " added by print(String name)";
    }

    public void invokeTask(DelegateTask task) {
        System.out.println();
        task.setVariable("setByTask","I'm setted by DelegatedTask:" + task.getVariable("name"));
    }

    public String printByKey(DelegateExecution execution){
        String processBusinessKey = execution.getProcessBusinessKey();
        System.out.println("process instance Id :" + execution.getProcessInstanceId() + " business key:" + execution.getProcessBusinessKey());
        return processBusinessKey;
    }
}
