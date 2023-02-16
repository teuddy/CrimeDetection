package com.teuddycr.movies.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@AllArgsConstructor
@Getter
@Accessors(chain = true)
@RedisHash("cacheData")
public class CacheData implements Serializable {
    private static final long serialVersionUID = -7817224776021728682L;
    @Id
    private String key;

    @Indexed
    private String value;
}

// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// //No @Entity concept here
// public class CacheData implements Serializable {

// private static final long serialVersionUID = -7817224776021728682L;

// private Integer empId;
// private String empName;
// private Double empSalary;
// }