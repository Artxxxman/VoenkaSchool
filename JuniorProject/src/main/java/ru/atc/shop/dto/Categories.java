package ru.atc.shop.dto;

import ru.atc.shop.db.Entity.PriceCategory;

import java.util.List;

public class Categories {
    private String name;

    public Categories(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
