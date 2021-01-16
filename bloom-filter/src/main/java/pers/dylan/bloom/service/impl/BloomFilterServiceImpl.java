package pers.dylan.bloom.service.impl;

import com.google.common.hash.BloomFilter;
import org.redisson.api.RBloomFilter;
import org.springframework.stereotype.Service;
import pers.dylan.bloom.service.BloomFilterService;

import javax.annotation.Resource;

@Service
public class BloomFilterServiceImpl<T> implements BloomFilterService<T> {

    @Resource
    BloomFilter bloomFilter;

    @Resource
    RBloomFilter rBloomFilter;

    @Override
    public void add(T t) {
        bloomFilter.put(t);
    }

    @Override
    public Boolean contain(T t) {
        return bloomFilter.mightContain(t);
    }

    @Override
    public void redissonAdd(T t) {
        rBloomFilter.add(t);
    }

    @Override
    public Boolean redissonContain(T t) {
        return rBloomFilter.contains(t);
    }
}
