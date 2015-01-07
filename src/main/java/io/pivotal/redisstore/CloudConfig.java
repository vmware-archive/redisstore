package io.pivotal.redisstore;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
@Configuration
@EnableAutoConfiguration() 
public class CloudConfig extends AbstractCloudConfig {
		
    @Bean 
    public RedisConnectionFactory redisConnectionFactory() {
        return connectionFactory().redisConnectionFactory();
    } 
    
    @Bean
    public StringRedisTemplate stringRedisTemplate() {
    	return new StringRedisTemplate(redisConnectionFactory());
    }
}
