package com.cloud.service;

import org.activiti.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ActivitiService {



    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private FormService formService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private HistoryService historyService;


    public void startProcess(String procId, Map<String,Object> param){
        runtimeService.startProcessInstanceByKey(procId,param);
    }


}
