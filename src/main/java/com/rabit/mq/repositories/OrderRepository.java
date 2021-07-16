package com.rabit.mq.repositories;

import com.rabit.mq.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
