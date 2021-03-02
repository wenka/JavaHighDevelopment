package com.wenka.activiti.demo;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;

import java.util.*;

/**
 * Created with IDEA
 *
 * @author wenka wkwenka@gmail.com
 * @date 2021/02/23  下午 04:47
 * @description:
 */
public class IdentityClient {

    static ProcessEngine processEngine = null;
    static Map<String, List<String>> users = new HashMap<>();

    static {

        users.put("aGroup", Arrays.asList("a1", "a2"));
        users.put("bGroup", Arrays.asList("b1", "b2"));
        users.put("cGroup", Arrays.asList("c1", "c2"));
        users.put("company", Arrays.asList("wenka"));
    }

    public static void main(String[] args) {
        buildProcessEngine();
        IdentityService identityService = processEngine.getIdentityService();
//        Group aGroup = identityService.newGroup("aGroup");
//        aGroup.setName("aGroup");
//        identityService.saveGroup(aGroup);
//        Group bGroup = identityService.newGroup("bGroup");
//        aGroup.setName("bGroup");
//        identityService.saveGroup(bGroup);
//
//        Group cGroup = identityService.newGroup("cGroup");
//        aGroup.setName("cGroup");
//        identityService.saveGroup(cGroup);

        users.values().stream().flatMap(Collection::stream).sorted().forEach(name -> {
            User u = identityService.newUser(name);
            u.setFirstName(name);
            u.setLastName(name);
            u.setPassword(name);
            identityService.saveUser(u);
        });

        users.keySet().forEach(group -> {
            List<String> names = users.get(group);
            names.forEach(name -> {
                identityService.createMembership(name, group);
            });
        });
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
