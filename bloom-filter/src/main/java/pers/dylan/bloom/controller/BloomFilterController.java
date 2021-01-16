package pers.dylan.bloom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.dylan.bloom.service.BloomFilterService;

import javax.annotation.Resource;

@RestController
public class BloomFilterController {

    @Resource
    private BloomFilterService bloomFilterService;
    @GetMapping("/add")
    public String add() {
        int count =0;
        for (int i = 0; i < 10000; i++) {
            boolean contain = bloomFilterService.contain("book:" + i);
            if (!contain) {
                bloomFilterService.add("book:" + i);
                System.out.println("值__book:" + i + "不存在");
                count++;
            }
        }

        return count+"";
    }
    @GetMapping("/redissonAdd")
    public String redissonAdd() {
        int count =0;
        for (int i = 0; i < 10000; i++) {
            boolean contain = bloomFilterService.redissonContain("book:" + i);
            if (!contain) {
                bloomFilterService.redissonAdd("book:" + i);
                System.out.println("值__book:" + i + "不存在");
                count++;
            }
        }

        return count+"";
    }
    @GetMapping("/get")
    public String contain(@RequestParam("value") String value) {
        if (bloomFilterService.contain(value)) {
            System.out.println("查找的值存在");
            return value + "存在";
        } else {
            System.out.println("查找的值不存在");
            return value + "不存在";
        }
    }

    @GetMapping("/query")
    public String query() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            boolean contain = bloomFilterService.contain("book:" + i);
            if (!contain) {
                System.out.println("值__" + "book:" + i + "不存在");
                count++;
            }

        }
        System.out.println("统计不存在的值:" + count);
        return count + "";
    }
    @GetMapping("/redissonQuery")
    public String redissonQuery() {
        int count = 0;
        for (int i = 8000; i < 11000; i++) {
            boolean contain = bloomFilterService.contain("book:" + i);
            if (!contain) {
                System.out.println("值__" + "book:" + i + "不存在");
                count++;
            }

        }
        System.out.println("统计不存在的值:" + count);
        return count + "";
    }

}
