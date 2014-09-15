package com.gopivotal.redisstore.service;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gopivotal.redisstore.domain.NameValue;
import com.gopivotal.redisstore.domain.NameValueRepository;

@Component("DataSourceService")
public class DataSourceService {

	private static final String NO_VALUE = "Not set.";

	Logger logger = LoggerFactory.getLogger(DataSourceService.class);

	@Autowired
	NameValueRepository nameValueRepository;
	  
	private final static String template = "Key: %s Value: %s";
	private final static String viewTemplate = "Key: %s";

	public String retrieveValue(String keyName) {
		logger.error(String.format(viewTemplate, keyName));
		
		List<NameValue> nameValues = nameValueRepository.findByName(keyName);
		
		if(nameValues == null || nameValues.size() <= 0) {
			return NO_VALUE;
		}
		return nameValues.get(0).getValue();
	} 
	
	public void storeValue(String keyName, String value) {
		logger.info(String.format(template, keyName,value));
		NameValue nameValue = new NameValue(keyName, value);
		nameValueRepository.save(nameValue);
	}
}
