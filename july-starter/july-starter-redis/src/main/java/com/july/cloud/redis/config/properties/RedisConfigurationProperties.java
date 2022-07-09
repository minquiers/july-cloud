package com.july.cloud.redis.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfigurationProperties {
    private Boolean enabled = false;
    private String host;
    private Integer port;
    private Boolean ssl = false;
    private String password;
    private Long timeOut = 2000L;
    private Pool pool;
    private Integer database = 0;
    private Cluster cluster;
    private Sentinel sentinel;

    @Data
    public static class Pool {
        private Integer minIdle;
        private Integer maxIdle;
        private Integer maxActive;
        private Long maxWait;
    }

    @Data
    public static class Cluster {
        private List<String> nodes;
        private Integer commandTimeout;
    }

    @Data
    public static class Sentinel {
        private String master;
        private List<String> nodes;
        private String password;
    }
}

