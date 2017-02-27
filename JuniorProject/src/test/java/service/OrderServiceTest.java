package service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.atc.shop.dao.OrderDao;
import ru.atc.shop.dao.PriceListDao;
import ru.atc.shop.db.Entity.Order;
import ru.atc.shop.db.Entity.PriceList;
import ru.atc.shop.service.OrderService;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/app-config.xml"})
public class OrderServiceTest{


    @Autowired
    private OrderService orderService;

    @Autowired
    private PriceListDao priceListDao;

    @Test
    public void testOrderService() throws Exception{
        Order order = new Order();
        order.setFullname("Bla");
        order.setOrderPrice(796.0);
        order.setProductNum(13);
        orderService.addOrder(order) ;
        orderService.addPosition(order,priceListDao.findByid(1l),5l);
        orderService.removePosition(order,priceListDao.findByid(1l),3l);
    }
}