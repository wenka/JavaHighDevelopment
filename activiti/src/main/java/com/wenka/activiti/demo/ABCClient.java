package com.wenka.activiti.demo;

import org.activiti.engine.*;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2021/02/23  上午 10:32
 * @description:
 */
public class ABCClient {
    static ProcessEngine processEngine = null;

    static TaskService taskService = null;

    static Map<String, List<String>> users = new HashMap<>();

    static {

        users.put("aGroup", Arrays.asList("a1", "a2"));
        users.put("bGroup", Arrays.asList("b1", "b2"));
        users.put("cGroup", Arrays.asList("c1", "c2"));
        users.put("company", Arrays.asList("wenka"));
    }

    public static void main(String[] args) throws InterruptedException {
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
        // 查询任务
        taskService = processEngine.getTaskService();
//        queryTask();

        // 启动流程
//        startProcess(bizId);
//        queryTask();

        // 执行任务 --> 初审节点提交
        Map<String, Object> vars = new HashMap<>();
//        vars.put("aUserSecond", "a2");
//        vars.put("bUserSecond", "b2");
//        vars.put("cUserSecond", "c2");
//        taskService.complete("100007", vars);
//        taskService.complete("100011", vars);
//        taskService.complete("100015", vars);
//        queryTask();

//        processEngine.getRuntimeService().deleteProcessInstance("40001", "作废");
//        queryTask();

        // 复核不通过
//        vars.put("operate","FAIL");
//        vars.put("bUserFirst","b2");
//        taskService.complete("75008",vars);
//        queryTask();

        // 复审通过
//        vars.put("operate", "PASS");
//        vars.put("confirmed", false);// (未进行确认)
//        vars.put("confirmed", true);// (未进行确认)
//        vars.put("applicant", users.get("company").stream().findAny().get());
//        taskService.complete("102502", vars);
//        taskService.complete("102504", vars);
//        taskService.complete("102506", vars);
//        queryTask();


        // 确认节点执行
//        vars.put("operate","FAIL");
//        vars.put("aUserFirst", "a1");
//        vars.put("bUserFirst", "b1");
//        vars.put("cUserFirst", "c1");
//        taskService.complete("97507",vars);
//        queryTask();
    }

    public static void queryTask() {
        users.values().stream().flatMap(Collection::stream).sorted().forEach(name -> {
            queryMyTask(name);
        });

        queryGroupTask();
    }

    private static void queryMyTask(String name) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(name).list();
        System.out.println(String.format("------------ %s 的任务数：%s ------------", name, tasks.size()));
        tasks.stream().forEach(task -> {
            String id = task.getId();
            String processInstanceId = task.getProcessInstanceId();
            String taskName = task.getName();
            String taskDefinitionKey = task.getTaskDefinitionKey();
            System.out.println(String.format("Task[id=%s,taskName=%s,processInstanceId=%s,taskDefinitionKey=%s]", id, taskName, processInstanceId, taskDefinitionKey));
        });
        System.out.println("----------------------------------------");
        // 1. Task[id=2506,processInstanceId=2501]
    }

    private static void queryGroupTask() {
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroupIn(users.keySet().stream().collect(Collectors.toList())).list();
        tasks.stream().forEach(task -> {
            String id = task.getId();
            String processInstanceId = task.getProcessInstanceId();
            String taskName = task.getName();
            String taskDefinitionKey = task.getTaskDefinitionKey();
            System.out.println(String.format("Task[id=%s,taskName=%s,processInstanceId=%s,taskDefinitionKey=%s]", id, taskName, processInstanceId, taskDefinitionKey));
        });
        System.out.println("----------------------------------------");
        // 1. Task[id=2506,processInstanceId=2501]
    }

    private static void startProcess(String bizId) {
        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String, Object> vars = new HashMap<>();
        vars.put("bizId", bizId);
        vars.put("aGroupFirst", "aGroup");
        vars.put("aUserFirst", null);
        vars.put("bGroupFirst", "bGroup");
        vars.put("bUserFirst", null);
        vars.put("cGroupFirst", "cGroup");
        vars.put("cUserFirst", null);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("abc", vars);
        String processInstanceId = processInstance.getProcessInstanceId();
        String activityId = processInstance.getActivityId();
        String id = processInstance.getId();
        String processDefinitionId = processInstance.getProcessDefinitionId();
        System.out.println(String.format("ProcessInstance[processInstanceId=%s,activityId=%s,id=%s,processDefinitionId=%s]", processInstanceId, activityId, id, processDefinitionId));
    }

    /**
     * 流程部署
     */
    private static void processDeploy() {
        // 流程部署
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("abc.bpmn")
                .name("abc三线审核流程")
                .category("abc")
                .deploy();

        System.out.println("流程部署成功！");
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
