package ru.atc.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.atc.shop.db.Entity.PriceCategory;
import ru.atc.shop.db.Entity.PriceList;
import ru.atc.shop.dto.Categories;
import ru.atc.shop.dto.Product;
import ru.atc.shop.service.PriceCategoryService;
import ru.atc.shop.service.PriceListService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Controller
public class HelloController {



    @RequestMapping(value="/")
    public String printWelcome(Model model) {
        return "Hello";
    }

//    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
//    @ResponseBody
//    public List<String> getCategory() {
//        List<String> categories = new ArrayList<String>();
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:app-config.xml");
//        ctx.refresh();
//        PriceCategoryService priceCategoryService = ctx.getBean("priceCategoryService",PriceCategoryService.class);
//        for(String str :priceCategoryService.getCategories()){
//            categories.add(str);
//        }
//        return categories;
//    }
//    @RequestMapping(value = "/loadproducts", method = RequestMethod.GET)
//    @ResponseBody
//    public List<PriceList> getProducts(@RequestParam(value = "categoryId") String categoryId) {
//        List<PriceList> products = new ArrayList<PriceList>();
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("classpath:app-config.xml");
//        ctx.refresh();
//        PriceListService priceListService = ctx.getBean("priceListService",PriceListService.class);
//        products = priceListService.getProductofCategory(Long.valueOf(categoryId));
//        return products;
//    }
}
