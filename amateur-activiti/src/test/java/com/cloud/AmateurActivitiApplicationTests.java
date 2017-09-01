package com.cloud;

import com.cloud.entity.ProcessEO;
import com.cloud.service.ActivitiService;
import com.cloud.service.ProcessService;
import com.cloud.workflow.MyBean;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmateurActivitiApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(AmateurActivitiApplicationTests.class);

	@Autowired
	private ActivitiService activitiService;

	@Autowired
	private IdentityService identityService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private ProcessService processService;

	@Test
	public void contextLoads() {
		LOGGER.info("流程执行开始");
		MyBean myBean = new MyBean();
		Map<String,Object> param = new HashMap<>();
		param.put("myBean",myBean);
		param.put("name","zhangsan");
		identityService.setAuthenticatedUserId("张小三");
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("learn",param);
		LOGGER.info(" 开始者:" + runtimeService.getVariable(processInstance.getId(),"authVariable"));
		Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
		LOGGER.info("获取流程启动人：" + taskService.getVariable(task.getId(),"authVariable"));
		String setByTask  = (String) taskService.getVariable(task.getId(),"setByTask");
		LOGGER.info("setByTask :" + setByTask);
		//activitiService.startProcess("learn",param);
		LOGGER.info("流程执行结束");
	}


	@Test
	public void testMyProcess(){
		LOGGER.info("流程执行开始");
		Map<String,Object> param = new HashMap<>();
		param.put("startDate",new Date());
		param.put("endDate",new Date());
		param.put("reason","请假");
		runtimeService.startProcessInstanceByKey("myProcess",param);
		Task task = taskService.createTaskQuery().taskCandidateGroup("leader").singleResult();
		taskService.claim(task.getId(),"zhangsan");
		Task tasks = taskService.createTaskQuery().taskAssignee("zhangsan").singleResult();
		LOGGER.info("张三执行任务：" + tasks.getName());
		//param.put("auditOpinion",true);
		taskService.complete(task.getId());
		LOGGER.info("流程执行结束");
	}

	@Test
	public void testProcess(){
		ProcessEO process = new ProcessEO();
		process.setOpDate(new Date());
		process.setName("aaa");
		processService.saveProcess(process);
	}

}
