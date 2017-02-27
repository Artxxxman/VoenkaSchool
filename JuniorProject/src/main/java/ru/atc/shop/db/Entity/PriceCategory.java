package ru.atc.shop.db.Entity;

import javax.persistence.*;

@Entity
@Table(name="shop_price_category")
@SequenceGenerator(name = "price_category_s", sequenceName = "shop_price_category_s")
public class PriceCategory {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "price_category_s")

    private Long id;

    @Column(name = "name")
    private String name;

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
