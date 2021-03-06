package com.microservice.controller;

import com.microservice.common.model.Student;
import com.microservice.service.ConsumerClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {
    //使用Feign
    @Autowired
    private ConsumerClientService consumerClientService;

    @RequestMapping("/consumer/get/all")
    public List<Student> getAll() {
        return consumerClientService.getAllStudents();
    }

    @RequestMapping("/consumer/get/{id}")
    public Student queryById(@PathVariable("id") String id) {
        return consumerClientService.queryById(id);
    }

    /**
     * 以下是原来的逻辑
     */
    //    private static final String REST_URL_PREFIX="http://localhost:9001";
//    private static final String REST_URL_PREFIX="http://MICROSERVICE-PROVIDER";
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @RequestMapping("/consumer/hello/discovery")
//    public Object disCovery()
//    {
//        return restTemplate.getForObject(REST_URL_PREFIX+"/hello/discovery",Object.class);
//    }
//
//    @RequestMapping("/consumer/get/all")
//    public List<Object> getAll()
//    {
//        return restTemplate.getForObject(REST_URL_PREFIX+"/provider/all",List.class);
//    }
}
