package com.teuddycr.movies.infra.outputadapter;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import com.teuddycr.movies.domain.CacheData;
import com.teuddycr.movies.infra.outputport.CacheOutputPort;

import jakarta.annotation.Resource;

@Repository
public class RedisCacheOutputAdapter implements CacheOutputPort {

    private final String hashReference = "CacheData";

    @Resource(name = "redisTemplate") // 'redisTemplate' is defined as a Bean in AppConfig.java
    // la clave, el tipo de datos de la clave y el valor ue es cache data
    private HashOperations<String, String, CacheData> hashOperations;

    @Override
    public void save(CacheData entity) {
        hashOperations.putIfAbsent(hashReference, entity.getKey(), entity);
    }

    @Override
    public CacheData get(String id) {
        return hashOperations.get(hashReference, id);
    }

    @Override
    public void update(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public Map<String, CacheData> getAllCacheData() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteEmployee(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveAllEmployees(Map<Integer, CacheData> map) {
        // TODO Auto-generated method stub

    }

}
