package com.gopivotal.redisstore.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gopivotal.redisstore.service.DataService;
import com.gopivotal.redisstore.service.DataSourceService;

@Controller
@RestController
public class DataController {

	 Logger logger = LoggerFactory.getLogger(DataController.class);
	 
	@Autowired
	private DataService dataservice;

	@Autowired
	private DataSourceService dataSourceService;
	
//	@Autowired
//	private MessageService messageService;
	
    private static final String template = "Key: %s";
    private static final String templateView = template +  " Value: %s";

    @RequestMapping("/retrieve")
    public @ResponseBody String retrieve(
            @RequestParam(value="name", required=false, defaultValue="name") String name) 
    {
    	String value = dataservice.retrieveValue(name);
    	String returnValue = String.format(templateView, name, value);
    	logger.info(returnValue);
    	logger.error("DB RETRIEVE: " + dataSourceService.retrieveValue(name));
    	//logger.error(System.getenv("VCAP_SERVICES"));
        return value;
    }

    @RequestMapping("/store")
    public @ResponseBody String store(
            @RequestParam(value="name", required=false, defaultValue="name") String name,
            @RequestParam(value="value", required=false, defaultValue="value") String value) 
    {
    	dataservice.storeValue(name, value);
    	String returnValue = String.format(template, name);
    	logger.info(returnValue);
    	dataSourceService.storeValue(name, value);
    	return returnValue;
    }
}
