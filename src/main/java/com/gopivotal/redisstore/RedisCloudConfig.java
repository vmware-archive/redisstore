package com.gopivotal.redisstore;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@ServiceScan
public class RedisCloudConfig extends AbstractCloudConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return connectionFactory().redisConnectionFactory();
    }

    
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        CloudEnvironment cloudEnvironment = new CloudEnvironment();
//        RedisServiceInfo serviceInfo = cloudEnvironment.getServiceInfo("my-redis", RedisServiceInfo.class);
//        RedisServiceCreator serviceCreator = new RedisServiceCreator();
//        return serviceCreator.createService(serviceInfo);
//    }

    @Bean
    public RedisTemplate redisTemplate() {
        return new StringRedisTemplate(redisConnectionFactory());
    }
    
    @Bean
    public StringRedisTemplate stringRedisTemplate() {
    	return new StringRedisTemplate(redisConnectionFactory());
    }

}