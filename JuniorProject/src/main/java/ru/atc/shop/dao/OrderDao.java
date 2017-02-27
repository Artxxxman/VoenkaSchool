package ru.atc.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.atc.shop.db.Entity.Order;

public interface OrderDao extends JpaRepository<Order,Long> {
    Order findByid(Long orderId);
}
