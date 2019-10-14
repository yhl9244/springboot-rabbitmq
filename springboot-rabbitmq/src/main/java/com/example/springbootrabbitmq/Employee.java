package com.example.springbootrabbitmq;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Employee {

    private String name;
    private Integer age;
    private String empno;
}
