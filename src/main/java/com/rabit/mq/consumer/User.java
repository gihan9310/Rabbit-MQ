package com.rabit.mq.consumer;

import com.rabit.mq.config.MessagingConfig;
import com.rabit.mq.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rabit.mq.repositories.OrderRepository;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Component
public class User {

    @Autowired
    private OrderRepository orderRepository;

    @RabbitListener(queues = MessagingConfig.MY_QUE)
    public void consumeMessageFormQue(OrderStatus  orderStatus){
        System.out.println("My QUE--->> "+orderStatus);
        orderRepository.save(orderStatus.getOrderDTO().getEntity());
    }
}
