package ru.atc.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.atc.shop.dao.PriceListDao;
import ru.atc.shop.db.Entity.PriceList;

import java.util.List;

@Service("priceListService")
public class PriceListService {

    @Autowired
    private PriceListDao priceListDao;

    public List<PriceList> getProductofCategory(Long categoryId){
        return priceListDao.findBycategoryId(categoryId);
    }
}
