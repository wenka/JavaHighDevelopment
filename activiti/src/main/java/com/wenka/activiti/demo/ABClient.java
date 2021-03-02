package com.wenka.activiti.demo;

import org.activiti.engine.*;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2021/02/23  上午 10:32
 * @description:
 */
public class ABClient {
    static ProcessEngine processEngine = null;

    static TaskService taskService = null;

    public static void main(String[] args) {
        buildProcessEngine();

//        processDeploy();
        List<ProcessDefinition> list = processEngine.getRepositoryService().createProcessDefinitionQuery().list();
        list.stream().forEach(processDefinition -> {
            String deploymentId = processDefinition.getDeploymentId();
            String id = processDefinition.getId();
            String key = processDefinition.getKey();
            String name = processDefinition.getName();
            int version = processDefinition.getVersion();
            System.out.println(String.format("ProcessDefinition[deploymentId=%s,id=%s,key=%s,name=%s,version=%s]", deploymentId, id, key, name, version));
        });

        String bizId = "88888888"; // 业务ID
        // 启动流程
        startProcess(bizId);

        // 查询任务
        taskService = processEngine.getTaskService();
        quertTask();

        // 执行任务 --> 填报节点提交
        Map<String, Object> vars = new HashMap<>();
        vars.put("aGroupFirst", "aRole");
        vars.put("bGroupFirst", "bRole");
        taskService.complete("40006", vars);
        quertTask();

        // a组初审执行
//        vars.put("aUserSecond", "aSecond");
//        taskService.complete("5007", vars);
//        quertTask();

        // b组初审执行
//        vars.put("bUserSecond", "bSecond");
//        taskService.complete("5010", vars);
//        quertTask();

        // a组复审执行
//        vars.put("applicant", "wenka");
//        taskService.complete("7503", vars);
//        quertTask();

        // b组复审执行
//        vars.put("applicant", "wenka");
//        taskService.complete("10003", vars);
//        quertTask();

        // 确认节点执行
//        taskService.complete("15003");
//        quertTask();
    }

    public static void quertTask() {
        queryMyTask("wenka");
        queryMyTask("aRole");
        queryMyTask("bRole");
        queryMyTask("aSecond");
        queryMyTask("bSecond");
    }

    private static void queryMyTask(String name) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(name).list();
        System.out.println(String.format("%s 的任务数：%s", name, tasks.size()));
        tasks.stream().forEach(task -> {
            String id = task.getId();
            String processInstanceId = task.getProcessInstanceId();
            String taskName = task.getName();
            System.out.println(String.format("Task[id=%s,taskName=%s,processInstanceId=%s,taskDefinitionKey=%s]", id, taskName, processInstanceId, task.getTaskDefinitionKey()));
        });

        // 1. Task[id=2506,processInstanceId=2501]
    }

    private static void startProcess(String bizId) {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String, Object> vars = new HashMap<>();
        vars.put("bizId", bizId);
        vars.put("applicant", "wenka");
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess", vars);
        String processInstanceId = processInstance.getProcessInstanceId();
        String activityId = processInstance.getActivityId();
        String id = processInstance.getId();
        String processDefinitionId = processInstance.getProcessDefinitionId();
        //ProcessInstance[processInstanceId=2501,activityId=usertask1,id=2501,processDefinitionId=myProcess:1:4]
        System.out.println(String.format("ProcessInstance[processInstanceId=%s,activityId=%s,id=%s,processDefinitionId=%s]", processInstanceId, activityId, id, processDefinitionId));
    }

    /**
     * 流程部署
     */
    private static void processDeploy() {
        // 流程部署
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("ab.bpmn")
                .name("ab双线双审核流程")
                .category("")
                .deploy();
    }


    private static void buildProcessEngine() {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:h2:E:\\workspaces\\IdeaProjects\\java-dev\\activiti\\activiti;DB_CLOSE_DELAY=1000")
                .setJdbcUsername("sa")
                .setJdbcPassword("")
                .setJdbcDriver("org.h2.Driver")
                .setJobExecutorActivate(true)
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE);

        processEngine = cfg.buildProcessEngine();
        String name = processEngine.getName();
        String version = ProcessEngine.VERSION;
        System.out.println(String.format("ProcessEngine[name=%s,version=%s]", name, version));
    }
}
