package com.yang.yun.impl;

import com.alibaba.dubbo.config.annotation.Service;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yang.yun.bean.UserAddress;
import com.yang.yun.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yhy
 * @Date: 2018/8/29 18:03
 * @Version 1.0
 */
@Service //暴露端口
@Component
public class UserServiceImpl implements UserService {




    @HystrixCommand //交给hystric代理
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        List<UserAddress> list = new ArrayList<>();
        System.out.println("----------provider--------"+userId);
        UserAddress userAddress1 = new UserAddress(1,"新乡华兰大道东","5","俺不知道","157366","九年级二班");
        UserAddress userAddress2 = new UserAddress(2,"新乡华兰大道西","6","俺也不知道","157388","九年级三班");
        list.add(userAddress1);
        list.add(userAddress2);
        double random = Math.random();
        System.out.println("-------------:"+random);
        if (random >0.5) {
            throw new RuntimeException("群解散啦");
        }
        System.out.println("------Response------");
        return list;
    }
}
