package com.yang.yun;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

/**
 * 第一种的配置方式 //@EnableDubbo  @Service  com.alibaba.dubbo.config.annotation.Service
 *第二种的配置方式 @ImportResource(locations = "classpath:provider.xml")
 * 第三种的配置方式 MyDubboConfig  @EnableDubbo(scanBasePackages = "com.yang.yun")  @Service com.alibaba.dubbo.config.annotation.Service
 */

@SpringBootApplication
//@EnableDubbo
//@ImportResource(locations = "classpath:provider.xml")
@EnableDubbo(scanBasePackages = "com.yang.yun")
@EnableHystrix
public class BootUserServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootUserServiceProviderApplication.class, args);
	}
}
