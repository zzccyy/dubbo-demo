package com.ciitc.consumer.controller;

import com.ciitc.consumer.service.DemoServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消费者控制层
 * @author zhangchongying-JSB
 */
@RestController
public class ConsumerController {

    @Autowired
    private DemoServiceConsumer demoServiceConsumer;

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {

        System.out.println("****** democonsumer被访问 ******");
        return demoServiceConsumer.sayHello(name);
    }
}
