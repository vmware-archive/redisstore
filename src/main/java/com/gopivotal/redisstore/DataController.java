package com.gopivotal.redisstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class DataController {

	 Logger logger = LoggerFactory.getLogger(DataController.class);
	 
	@Autowired
	private DataService dataservice;
	 
    private static final String template = "Key: %s";

    @RequestMapping("/store")
    public @ResponseBody String store(
            @RequestParam(value="name", required=false, defaultValue="name") String name,
            @RequestParam(value="value", required=false, defaultValue="value") String value) 
    {
    	dataservice.storeValue(name, value);
    	String returnValue = String.format(template, name);
    	logger.debug(returnValue);
    	logger.debug(System.getenv("VCAP_SERVICES"));
        return returnValue;
    }
}
