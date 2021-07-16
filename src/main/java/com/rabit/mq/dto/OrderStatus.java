package com.rabit.mq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderStatus {

    private OrderDTO orderDTO;
    private String status;
    private String message;
}
