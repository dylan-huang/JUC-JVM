package pers.dylan.bloom.config;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;

@Configuration
public class DataConfig<T> {

    @Bean
    public BloomFilter initBloomFilter() {
        return BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()),100);
    }

    @Bean
    public RBloomFilter initRedissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379").setDatabase(0);
        RedissonClient client = Redisson.create(config);
        RBloomFilter<T> filter = client.getBloomFilter("filter");
        filter.tryInit(10000000L,0.03);
        return filter;
    }
}
