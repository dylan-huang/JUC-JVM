package com.atguigu.stream;

import com.atguigu.Employee;
import com.atguigu.EmployeeData;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1、stream关注的是对数据的运算，与cpu交互
 *    集合关注的是数据的存储，与内存打交道
 *
 * 2、
 * stream自己不会存储元素
 * 不会改变源对象，相反，他们会返回一个持有结果的新的stream
 * 操作是延迟的，他们会等到需要结果时才执行
 *
 * 3、stream执行流程
 *
 * stream的实例化
 * 一系列的中间操作（过滤，映射）
 *  终止操作
 *
 * 4、说明
 * 一个中间操作链，对数据源对数据进行操作
 * 一旦执行终止操作，就执行中间操作链，产生结果。之后不会再次被使用。
 */
public class StreamAPITest {
    public static void main(String[] args) {
        test4();
    }

    //创建方式1 ： 通过集合
    public static void test1(){
        List<Employee> list = EmployeeData.getEmployee();
        //顺序流
        Stream<Employee> stream = list.stream();

        //并行流
        Stream<Employee> employeeStream = list.parallelStream();
    }
    //创建方式2 ： 通过数组
    public static void test2(){
        // 通过Arrays类的static<T> Stream<T> stream(T[] array) 返回一个流
        int[] arr = {1,2,3,4,5,6};
        IntStream stream = Arrays.stream(arr);

        Employee e1 =new Employee(1101,"tom");
        Employee e2 =new Employee(1102,"jerry");
        Employee[] employees = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(employees);

    }
    //创建方式3 ： 通过Stream的of
    public static void test3(){

//        Stream<? extends Serializable> s = Stream.of(1, 2, 3, "S");
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7);

    }
    //创建方式4 ： 创建无限流
    public static void test4(){
        //迭代
        //public static<T> Stream<T> iterate(final T seed,final UnaryOperator<T> f)
        Stream.iterate(0, t -> t+2).limit(10).forEach(System.out::println);

        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
