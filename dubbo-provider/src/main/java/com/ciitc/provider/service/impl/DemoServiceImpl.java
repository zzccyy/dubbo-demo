package com.ciitc.provider.service.impl;

import com.ciitc.api.service.DemoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * 服务提供类
 * @author zhangchongying-JSB
 */

//Service一定要使用apache.dubbo的注解，alibaba和sprig的都不要用
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        System.out.println("****** demoprovider被访问 ******");
        return "Hello, " + name + " (from Spring Boot)";
    }
}
