package com.gopivotal.redisstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	Logger logger = LoggerFactory.getLogger(MessageService.class);

	@Autowired
	private ConnectionFactory rabbitConnectionFactory;
	
	@Autowired
	RabbitTemplate rabbitTemplate;
 
	private final static String viewTemplate = "Message: %s";

	//  rabbitTemplate.convertAndSend(queueName, "Hello from RabbitMQ!");
	// TODO: change error levels in cf
	public void sendMessage(String message) {
		logger.error(String.format(viewTemplate, message));
		rabbitTemplate.convertAndSend(Constants.queueName, message);
		
	}
}
