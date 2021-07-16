package com.rabit.mq.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rabit.mq.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderId;
    private String name;
    private int qty;
    private double price;

    @JsonIgnore
    public OrderDTO getDto(){
        OrderDTO dto = new OrderDTO();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}
