package ru.atc.shop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.atc.shop.dao.OrderDao;
import ru.atc.shop.dao.OrderDetailsDao;
import ru.atc.shop.dao.PriceListDao;
import ru.atc.shop.db.Entity.Order;
import ru.atc.shop.db.Entity.OrderDetails;
import ru.atc.shop.db.Entity.PriceList;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private PriceListDao priceListDao;

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Transactional
    public Order addOrder (Order order){
        Order saveOrder = orderDao.save(order);
        return saveOrder;
    }

    @Transactional
    public void removeOrder(Long id){
        orderDao.delete(id);
        List<OrderDetails> orderDetailss = orderDetailsDao.findByOrderId(id);
        for(OrderDetails orderDetails : orderDetailss){
            orderDetailsDao.delete(orderDetails);
        }
    }

    @Transactional
    public OrderDetails addPosition(Order order,PriceList priceList,Long quantity){
        if(orderDetailsDao.findByProductIdAndOrderId(priceList.getId(),order.getId())==null){
        OrderDetails orderDetails =new OrderDetails();
        orderDetails.setOrderId(order.getId());
        orderDetails.setProductId(priceList.getId());
        orderDetails.setProductQuantity(quantity);
        order.setOrderPrice(order.getOrderPrice()+priceList.getPrice()*quantity);
        orderDao.save(order);
        return orderDetailsDao.save(orderDetails);
        }
        else{
            OrderDetails orderDetails = orderDetailsDao.findByProductIdAndOrderId(priceList.getId(),order.getId());
            orderDetails.setProductQuantity(orderDetails.getProductQuantity()+quantity);
            order.setOrderPrice(order.getOrderPrice()+priceList.getPrice()*quantity);
            orderDao.save(order);
            return orderDetailsDao.save(orderDetails);
        }
    }

    @Transactional
    public OrderDetails removePosition(Order order,PriceList priceList,Long quantity){
        OrderDetails orderDetails = orderDetailsDao.findByProductIdAndOrderId(priceList.getId(),order.getId());
        if(orderDetails.getProductQuantity()<=quantity){
            orderDetailsDao.delete(orderDetails);
            return null;
        }
        else  {
            orderDetails.setProductQuantity(orderDetails.getProductQuantity()-quantity);
            return orderDetailsDao.save(orderDetails);
        }
    }

    public Double getOrderTotal(Long orderId){
        return orderDao.findByid(orderId).getOrderPrice();
    }

    public Double getPositionTotal(Long productId,Long orderId){
        Double price = priceListDao.findByid(productId).getPrice();
        Long quantity = orderDetailsDao.findByProductIdAndOrderId(productId,orderId).getProductQuantity();
        return price*quantity;
    }
}
