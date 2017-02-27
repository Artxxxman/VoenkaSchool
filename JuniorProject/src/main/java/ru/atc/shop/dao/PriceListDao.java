package ru.atc.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.atc.shop.db.Entity.PriceList;

import java.util.List;

public interface PriceListDao extends JpaRepository<PriceList, Long> {
    PriceList findByid(Long productId);
    List<PriceList> findBycategoryId(Long categoryId);
}
