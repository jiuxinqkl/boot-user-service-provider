package com.yang.yun.config;

import com.alibaba.dubbo.config.*;
import com.yang.yun.impl.UserServiceImpl;
import com.yang.yun.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yhy
 * @Date: 2018/8/30 17:15
 * @Version 1.0
 */
@Configuration
public class MyDubboConfig {


    /* <dubbo:application name="boot-user-service-provider"/>*/
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig appConfig = new ApplicationConfig();
        appConfig.setName("boot-user-service-provider");
        return appConfig;
    }
    /*<dubbo:registry address="zookeeper://127.0.0.1:2181" timeout="1200000"/>*/
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }

    /*<!--3.指定通信规则-->
    <dubbo:protocol name="dubbo" port="20880"/>*/
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    /*<!--暴露那个服务 ref：是服务的真正的实现-->
    <dubbo:service interface="com.yang.yun.service.UserService" ref="userService"/>*/
    @Bean
    public ServiceConfig<UserService> serviceConfig(UserService userService) {
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(12000);
        List<MethodConfig> lists = new ArrayList<>();
        lists.add(methodConfig);
        serviceConfig.setMethods(lists);
        serviceConfig.setRef(userService);
        return serviceConfig;
    }






}
