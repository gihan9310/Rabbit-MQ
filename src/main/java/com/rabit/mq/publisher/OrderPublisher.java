package com.rabit.mq.publisher;

import com.rabit.mq.config.MessagingConfig;
import com.rabit.mq.dto.OrderDTO;
import com.rabit.mq.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@RestController
@RequestMapping("/orders")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping(value = "/{resturentName}")
    public String bookOrder(@RequestBody OrderDTO orderDTO, @PathVariable("resturentName") String resturentName){

      orderDTO.setOrderId(UUID.randomUUID().toString());
      OrderStatus orderStatus = new OrderStatus(orderDTO,"PROCESSING","Order placed successfully.");
      rabbitTemplate.convertAndSend(MessagingConfig.MY_EXCHANGE,MessagingConfig.MY_ROUTING_KEY,orderStatus);
      return "Success.";

    }
}
