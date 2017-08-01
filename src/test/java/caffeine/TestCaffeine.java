package com.simple.caffeine;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by songyigui on 2017/8/1.
 */
public class TestCaffeine {

    @Test
    public void testCacheManul() {
        String key = "key-123";
        String value = "value-123";
        Cache<String, String> cache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(10000)
                .build();
        cache.put(key, value);
        String value1 = cache.getIfPresent(key);
        System.out.println(value1);
        System.out.println(cache.get(key, k -> createExValue(key)));
        cache.invalidate(key);
        System.out.println(cache.get(key, k -> createExValue(key)));

    }

    private String createExValue(String key) {
        return "value-123";
    }

    @Test
    public void testCacheLoading() {
        String key0 = "key0-123";
        String key1 = "key1-123";
        String key2 = "key2-123";
        String value = "value-123";

        List<String> keys = new ArrayList<>();
        keys.add(key0);
        keys.add(key1);
        keys.add(key2);

        LoadingCache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build(key -> createExValue(key));
        System.out.println(cache.get(key0));
        System.out.println(cache.getAll(keys));
    }

    @Test
    public void testCacheAsyn() throws ExecutionException, InterruptedException {
        String key0 = "key0-123";
        String key1 = "key1-123";
        String key2 = "key2-123";
        String value = "value-123";

        List<String> keys = new ArrayList<>();
        keys.add(key0);
        keys.add(key1);
        keys.add(key2);

        AsyncLoadingCache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
//                .buildAsync(key -> createExValue(key));
                .buildAsync((key, executor) -> createExValueAsync(key, executor));

        CompletableFuture<String> value0 = cache.get(key0);
        System.out.println(value0.get());
        CompletableFuture<Map<String, String>> values = cache.getAll(keys);
        System.out.println(values.get());
    }

    private CompletableFuture<String> createExValueAsync(String key, Executor executor) {
        return CompletableFuture.supplyAsync(() -> createExValue(key), executor);
    }


}
