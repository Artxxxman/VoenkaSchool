package ru.atc.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.atc.shop.dao.PriceCategoryDao;
import ru.atc.shop.db.Entity.PriceCategory;

import java.util.ArrayList;
import java.util.List;

@Service("priceCategoryService")
public class PriceCategoryService {

    @Autowired
    private PriceCategoryDao priceCategoryDao;

    public List<String> getCategories(){
        List<String> listNameCategory= new ArrayList<String>();
        List<PriceCategory> listCategorys = priceCategoryDao.findAll();
        for(PriceCategory priceCategory : listCategorys){
            listNameCategory.add(priceCategory.getName());
        }
        return listNameCategory;
    }
}
