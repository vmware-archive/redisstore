package com.gopivotal.redisstore;

import javax.sql.DataSource;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.cloud.service.messaging.RabbitConnectionFactoryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@ServiceScan
public class CloudConfig extends AbstractCloudConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return connectionFactory().redisConnectionFactory();
    }

    @Bean
    public RedisTemplate redisTemplate() {
        return new StringRedisTemplate(redisConnectionFactory());
    }
    
    @Bean
    public StringRedisTemplate stringRedisTemplate() {
    	return new StringRedisTemplate(redisConnectionFactory());
    }

    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        return connectionFactory().rabbitConnectionFactory();
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(rabbitConnectionFactory());
    }

    @Bean
    public Queue rabbitQueue() {
    	return new Queue(Constants.queueName);
    }

    @Bean
    public TopicExchange exchange() {
		return new TopicExchange(Constants.exchangeName);
    }

    @Bean
    public Binding binding() {
    	return BindingBuilder.bind(rabbitQueue()).to(exchange()).with(Constants.queueName);
    }
    
//    @Bean
//    public DataSource inventoryDataSource() {
//      return connectionFactory().dataSource();
//   }
    
//	@Bean
//	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames(queueName);
//		container.setMessageListener(listenerAdapter);
//		return container;
//	}

//    @Bean
//    Receiver receiver() {
//        return new Receiver();
//    }
//
//	@Bean
//	MessageListenerAdapter listenerAdapter(Receiver receiver) {
//		return new MessageListenerAdapter(receiver, "receiveMessage");
//	}

}