package ru.atc.shop.db.Entity;

import javax.persistence.*;

@Entity
@Table(name="shop_price_list")
@SequenceGenerator(name = "price_list_s", sequenceName = "shop_price_list_s")
public class PriceList {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "price_list_s")
    @SequenceGenerator(name = "price_list_s", sequenceName = "shop_price_list_s")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "price")
    private Double price;

    @Column(name = "url_picture")
    private String urlPicture;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryId(Long category_id) {
        this.categoryId = category_id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setUrlPicture(String url_picture) {
        this.urlPicture = url_picture;
    }
}
