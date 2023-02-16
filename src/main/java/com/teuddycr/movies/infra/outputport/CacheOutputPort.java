package com.teuddycr.movies.infra.outputport;

import java.util.Map;

import com.teuddycr.movies.domain.CacheData;

public interface CacheOutputPort {

    // save cache data
    void save(CacheData entity);

    // get one cache data
    CacheData get(String id);

    // uodate a cached data
    void update(String id);

    // return all cached data
    Map<String, CacheData> getAllCacheData();

    // delete a cacheddata
    void deleteEmployee(String id);

    // save bulk
    void saveAllEmployees(Map<Integer, CacheData> map);
}
