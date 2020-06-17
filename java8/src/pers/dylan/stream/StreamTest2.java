package pers.dylan.stream;


import pers.dylan.Employee;
import pers.dylan.EmployeeData;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 测试stream的终止操作
 */
public class StreamTest2 {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    //匹配与查找
    public static  void test1(){
        List<Employee> list = EmployeeData.getEmployee();

        boolean match = list.stream().allMatch(employee -> employee.getAge() > 18);

        boolean b = list.stream().allMatch(employee -> employee.getSalary() > 10000);

        boolean b1 = list.stream().noneMatch(employee -> employee.getName().contains("dylan"));

        Optional<Employee> first = list.stream().findFirst();

        Optional<Employee> any = list.parallelStream().findAny();
        System.out.println(any);

        System.out.println(list.stream().filter(employee -> employee.getSalary() > 6000).count());

        System.out.println(list.stream().map(e -> e.getSalary()).max(Double::compare));

        System.out.println(list.stream().min((e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary())));

        //内部迭代
        list.stream().forEach(System.out::println);

    }
    //规约
    public static void test2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list.stream().reduce(0, Integer::sum));

        System.out.println(EmployeeData.getEmployee().stream().map(employee -> employee.getSalary()).reduce(Double::sum));
    }

    //收集
    public static void test3(){
        List<Employee> list = EmployeeData.getEmployee().stream().filter(employee -> employee.getSalary() > 6000).collect(Collectors.toList());
    }
}
