package pers.dylan.stream;

import pers.dylan.Employee;
import pers.dylan.EmployeeData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试stream中间操作
 */
public class StreamAPITest1 {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    public static void test1() {

        List<Employee> list = EmployeeData.getEmployee();
        //薪资大于6000
        list.stream().filter(employee -> employee.getSalary() > 6000).forEach(System.out::println);
        System.out.println();
        //截断
        list.stream().limit(4).forEach(System.out::println);
        System.out.println();
        //跳过
        list.stream().skip(4).forEach(System.out::println);
        System.out.println();
        //去重
        list.stream().distinct().forEach(System.out::println);

    }

    //映射
    public static void test2() {

        Arrays.asList("aa", "bb", "cc", "dd").stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        EmployeeData.getEmployee().stream().map(Employee::getName).filter(s -> s.length() > 3).forEach(System.out::println);

        Arrays.asList("aa", "bb", "cc", "dd").stream().flatMap(StreamAPITest1::fromStringToStream).forEach(System.out::println);

    }

    public static Stream<Character> fromStringToStream(String string) {

        ArrayList<Character> list = new ArrayList<>();
        for (char c : string.toCharArray()) {
            list.add(c);
        }
        return list.stream();


    }

    public static void test3() {
        //自然排序
        List<Integer> list = Arrays.asList(43, 34, 65, 3, 34, 86, -1, 54, 92, -89);
        list.stream().sorted().forEach(System.out::println);

        List<Employee> list1 = EmployeeData.getEmployee();
        //抛出异常， 原因：没有实现Comparable接口
//        list1.stream().sorted().forEach(System.out::println);

        list1.stream().sorted((e1, e2) -> {
                    int compare = Integer.compare(e1.getAge(), e2.getAge());
                    if (compare != 0) {
                        return compare;
                    } else {
                        return Double.compare(e1.getSalary(), e2.getSalary());
                    }
                }

        ).forEach(System.out::println);

    }


}
