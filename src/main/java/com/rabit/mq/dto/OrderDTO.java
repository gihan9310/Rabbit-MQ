package com.rabit.mq.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rabit.mq.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDTO {

    private Long id;
    private String orderId;
    private String name;
    private int qty;
    private double price;

    @JsonIgnore
    public Order getEntity(){
        Order dto = new Order();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}
