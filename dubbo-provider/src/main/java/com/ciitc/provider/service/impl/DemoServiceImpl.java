package com.ciitc.provider.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ciitc.api.service.DemoService;
import org.apache.dubbo.config.annotation.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 服务提供类
 * Service一定要使用apache.dubbo的注解，alibaba和sprig的都不要用
 * @author zhangchongying-JSB
 */
@Service
public class DemoServiceImpl implements DemoService {

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String sayHello(String name) {
        System.out.println("****** demoprovider被访问 ******");
        return "Hello, " + name + " (from Spring Boot)";
    }

    @Override
    public Object listQuery(Object requestJson) {
        System.out.println("请求：" + requestJson.toString());

        JSONObject request = (JSONObject) requestJson;
        JSONObject content = request.getJSONObject("content");
        String tablename = content.getString("tablename");

        Object res = null;
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switch (tablename) {
            case "T_CONTRACT_MASTER":
                res = getT_CONTRACT_MASTER();
                break;
            case "T_CASH":
                res = getT_CASH();
                break;
            case "T_CONTRACT_PRODUCT":
                res = getT_CONTRACT_PRODUCT();
                break;
            default:
                res = null;
                break;
        }
        System.out.println("响应：" + res);
        return res;
    }

    private Object getT_CONTRACT_MASTER() {
        JSONObject res = new JSONObject();
        res.put("Code", "0");
        res.put("Message", "查询成功1");
        res.put("timestamp", df.format(new Date()));

        JSONObject content = new JSONObject();
        content.put("plattype", "L");
        content.put("tablename", "T_CONTRACT_MASTER");
        JSONArray businessdataList = new JSONArray();

        JSONObject businessdata1 = new JSONObject();
        businessdata1.put("POLICY_ID", "100001");
        businessdata1.put("POLICY_TYPE", "100002");
        businessdata1.put("POLICY_NO", "100003");
        businessdata1.put("PREMIUM", "100004");
        businessdataList.add(businessdata1);

        content.put("Businessdata", businessdataList);

        res.put("content", content);
        return res;
    }

    private Object getT_CASH() {
        JSONObject res = new JSONObject();
        res.put("Code", "0");
        res.put("Message", "查询成功2");
        res.put("timestamp", df.format(new Date()));

        JSONObject content = new JSONObject();
        content.put("plattype", "L");
        content.put("tablename", "T_CASH");
        JSONArray businessdataList = new JSONArray();

        JSONObject businessdata1 = new JSONObject();
        businessdata1.put("CASH_ID", "100011");
        businessdata1.put("INSURED_ID", "100012");
        businessdataList.add(businessdata1);

        JSONObject businessdata2 = new JSONObject();
        businessdata2.put("CASH_ID", "200011");
        businessdata2.put("INSURED_ID", "200012");
        businessdataList.add(businessdata2);

        content.put("Businessdata", businessdataList);
        res.put("content", content);
        return res;
    }

    private Object getT_CONTRACT_PRODUCT() {
        JSONObject res = new JSONObject();
        res.put("Code", "0");
        res.put("Message", "查询成功3");
        res.put("timestamp", df.format(new Date()));

        JSONObject content = new JSONObject();
        content.put("plattype", "L");
        content.put("tablename", "T_CONTRACT_PRODUCT");
        JSONArray businessdataList = new JSONArray();

        JSONObject businessdata1 = new JSONObject();
        businessdata1.put("ITEM_ID", "100031");
        businessdata1.put("MASTER_ID", "100032");
        businessdataList.add(businessdata1);

        JSONObject businessdata2 = new JSONObject();
        businessdata2.put("ITEM_ID", "200031");
        businessdata2.put("MASTER_ID", "200032");
        businessdataList.add(businessdata2);

        content.put("Businessdata", businessdataList);

        res.put("content", content);
        return res;
    }
}
