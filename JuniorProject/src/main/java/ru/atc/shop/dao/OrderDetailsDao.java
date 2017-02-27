package ru.atc.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.atc.shop.db.Entity.OrderDetails;

import java.util.List;

public interface OrderDetailsDao extends JpaRepository<OrderDetails,Long> {
    OrderDetails findByProductIdAndOrderId(Long product_id,Long order_id);
    List<OrderDetails> findByOrderId(Long order_id);
    List<OrderDetails> findByproductId(Long order_id);
}
