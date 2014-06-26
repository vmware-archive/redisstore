package com.gopivotal.redisstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataService {

	Logger logger = LoggerFactory.getLogger(DataService.class);

	@Autowired
	 private RedisConnectionFactory redisConnectionFactory;
	
	@Autowired
	StringRedisTemplate redisTemplate;

	 
	private final static String template = "Key: %s Value: %s";
	private final static String viewTemplate = "Key: %s";

	public String retrieveValue(String keyName) {
		logger.error(String.format(viewTemplate, keyName));
		
		return redisTemplate.opsForValue().get(keyName);
	} 
	
	public void storeValue(String keyName, String value) {
		logger.info(String.format(template, keyName,value));
		redisTemplate.opsForValue().set(keyName, value);
	}
}
