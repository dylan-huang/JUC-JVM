package pers.dylan.bloom.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class BloomFilterServiceTest {

    @Resource
    BloomFilterService bloomFilterService;

    @Test
    public void bloomFilterServiceTest() {
        bloomFilterService.redissonAdd(10086);
        bloomFilterService.redissonAdd(10087);

        for (int i=1;i<1000;i++) {
            bloomFilterService.redissonAdd(i);
        }

    }
}
