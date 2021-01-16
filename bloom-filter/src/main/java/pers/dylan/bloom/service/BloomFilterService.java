package pers.dylan.bloom.service;

public interface BloomFilterService<T> {

    /**
     * guava bloomFilter add
     * @param t
     */
    void add(T t);

    /**
     * guava bloomFilter contain
     * @param t
     */
    Boolean contain(T t);

    /**
     * redisson bloomFilter add
     * @param t
     */
    void redissonAdd(T t);

    /**
     * redisson bloomFilter contain
     * @param t
     */
    Boolean redissonContain(T t);

}
