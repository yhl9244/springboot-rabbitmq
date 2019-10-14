package com.example.springbootrabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private Sender sender;
    @Autowired
    private MessageProducer messageProducer;

    @RequestMapping("/hello")
    public String helloTest() {
        sender.send();
        return "success";
    }

    /**
     * 发送对象消息
     * @return
     */
    @GetMapping("/sendEmployeeMessage")
    public String sendEmployeeMessage(){
        Employee employee = new Employee();
        employee.setAge(23);
        employee.setEmpno("007");
        employee.setName("jike");
        messageProducer.sendMessage(employee);
        return "success";
    }
}
