package ru.atc.shop.db.Entity;

import javax.persistence.*;

@Entity
@Table(name="shop_order")
@SequenceGenerator(name = "order_s", sequenceName = "shop_order_s")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_s")
    private Long id;

    @Column(name = "order_number")
    private Integer productNum;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "order_total")
    private Double order_price;

    public Long getId() {
        return id;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public String getFullname() {
        return fullname;
    }

    public Double getOrderPrice() {
        return order_price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductNum(Integer product_num) {
        this.productNum = product_num;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setOrderPrice(Double order_price) {
        this.order_price = order_price;
    }
}