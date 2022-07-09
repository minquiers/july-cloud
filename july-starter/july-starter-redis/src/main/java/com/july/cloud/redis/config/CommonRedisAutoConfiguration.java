package com.july.cloud.redis.config;

import com.july.cloud.core.utils.StringUtils;
import com.july.cloud.redis.cache.RedisUtil;
import com.july.cloud.redis.config.properties.RedisConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties(RedisConfigurationProperties.class)
@AutoConfigureBefore({RedisAutoConfiguration.class})
public class CommonRedisAutoConfiguration {

    @Autowired
    RedisConfigurationProperties redisConfigurationProperties;

    @Bean(name = "redisTemplate")
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // key 序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public RedisUtil redisUtil(RedisTemplate<String, Object> redisTemplate) {
        return new RedisUtil(redisTemplate);
    }

    @Bean
    @ConditionalOnProperty(value = "spring.redis.enabled" , havingValue = "true")
    public RedisConnectionFactory connectionFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        if(null != redisConfigurationProperties.getPool()) {
            poolConfig.setMaxTotal(redisConfigurationProperties.getPool().getMaxActive());
            poolConfig.setMaxIdle(redisConfigurationProperties.getPool().getMaxIdle());
            poolConfig.setMaxWaitMillis(redisConfigurationProperties.getPool().getMaxWait());
            poolConfig.setMinIdle(redisConfigurationProperties.getPool().getMaxIdle());
        }
        poolConfig.setTestOnBorrow(true);
        poolConfig.setTestOnReturn(false);
        poolConfig.setTestWhileIdle(true);
        JedisClientConfiguration jedisClientConfiguration = null;

        if (redisConfigurationProperties.getSsl()) {
            jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().
                    poolConfig(poolConfig).and().
                    readTimeout(Duration.ofMillis(redisConfigurationProperties.getTimeOut())).useSsl()
                    .build();
        } else {
            jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().
                    poolConfig(poolConfig).and().
                    readTimeout(Duration.ofMillis(redisConfigurationProperties.getTimeOut())).build();
        }
        RedisConfigurationProperties.Cluster cluster = redisConfigurationProperties.getCluster();
        RedisConfigurationProperties.Sentinel sentinel = redisConfigurationProperties.getSentinel();
        JedisConnectionFactory factory = null;
        if (cluster != null && cluster.getNodes().size() > 0) {//cluster
            //spring.redis.cluster.nodes=127.0.0.1:23679,127.0.0.1:23680,127.0.0.1:23681
            RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(cluster.getNodes());
            redisClusterConfiguration.setMaxRedirects(3);
            redisClusterConfiguration.setPassword(redisConfigurationProperties.getPassword());
            factory = new JedisConnectionFactory(redisClusterConfiguration, jedisClientConfiguration);
        } else if (sentinel != null && StringUtils.isNotBlank(sentinel.getMaster())) {//sentinel
            //spring.redis.sentinel.nodes=127.0.0.1:26379,127.0.0.1:26479,127.0.0.1:26579
            RedisSentinelConfiguration redisSentinelConfiguration = new RedisSentinelConfiguration();
            redisSentinelConfiguration.setMaster(sentinel.getMaster());
            List<RedisNode> arrayList = new ArrayList<>();
            for (String address : sentinel.getNodes()) {
                String[] adds = address.split(":");
                RedisNode redisNode = new RedisNode(adds[0], Integer.valueOf(adds[1]));
                arrayList.add(redisNode);
            }
            redisSentinelConfiguration.setSentinels(arrayList);
            redisSentinelConfiguration.setDatabase(redisConfigurationProperties.getDatabase());
            factory = new JedisConnectionFactory(redisSentinelConfiguration, jedisClientConfiguration);
        } else {//stanalone
            RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
            redisStandaloneConfiguration.setPort(redisConfigurationProperties.getPort());
            redisStandaloneConfiguration.setPassword(RedisPassword.of(redisConfigurationProperties.getPassword()));
            redisStandaloneConfiguration.setHostName(redisConfigurationProperties.getHost());
            redisStandaloneConfiguration.setDatabase(redisConfigurationProperties.getDatabase());
            factory = new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
        }
        return factory;
    }
}
