package com.ciitc.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.ciitc.consumer.service.DemoServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PostMapping("/listQuery")
    public Object listQuery(@RequestBody Map<String, Object> params) {
        System.out.println("1111111");
        Object a = JSONObject.toJSON(params);
        return demoServiceConsumer.listQuery(a);
    }
}
