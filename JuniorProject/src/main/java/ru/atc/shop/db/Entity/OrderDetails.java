package ru.atc.shop.db.Entity;

import javax.persistence.*;

@Entity
@Table(name="shop_order_details")
@SequenceGenerator(name = "order_details_s", sequenceName = "shop_order_details_s")
public class OrderDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_details_s")

    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_quantity")
    private Long productQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long order_id) {
        this.orderId = order_id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long product_id) {
        this.productId = product_id;
    }

    public Long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Long product_quantity) {
        this.productQuantity = product_quantity;
    }


}
