package com.rabit.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Configuration
public class MessagingConfig {

    public static final String MY_EXCHANGE = "My_Exchange";
    public static final String MY_QUE = "My_Que";
    public static final String MY_ROUTING_KEY = "My_Routing_Key";

    @Bean
    public Queue queue(){
      return  new Queue(MY_QUE);
    }
    @Bean
    public TopicExchange  exchange(){
        return new TopicExchange(MY_EXCHANGE);
    }
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(MY_ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter(){
        return  new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){

       final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
       rabbitTemplate.setMessageConverter(messageConverter());
       return rabbitTemplate;
    }

}
