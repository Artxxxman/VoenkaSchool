package ru.atc.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.atc.shop.db.Entity.PriceCategory;

import java.util.List;

public interface PriceCategoryDao extends JpaRepository<PriceCategory,Long> {
    List<PriceCategory> findAll();

}
