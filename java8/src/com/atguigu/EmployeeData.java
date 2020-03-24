package com.atguigu;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {

    public static List<Employee> getEmployee(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001,"Tom",23,6000));
        list.add(new Employee(1002,"Jerry",24,4503));
        list.add(new Employee(1003,"Cynthia",34,8000));
        list.add(new Employee(1004,"Dylan",15,5306));
        list.add(new Employee(1005,"Edward",16,9876));
        list.add(new Employee(1006,"Frank",18,102032));
        list.add(new Employee(1007,"Gill",32,33535));
        list.add(new Employee(1008,"Hi",35,3000));
        list.add(new Employee(1009,"Ii",25,11000));

        return list;

    }

}
