package com.promotion.engine.promotions;

import com.promotion.engine.product.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PromotionBTest {

    @Test
    public void testApplyPromotion3WithOnlyFirstProduct(){
        Product product1 = new Product("C", 20);
        Product product2 = new Product("D", 15);
        Promotion promotion = new PromotionB(product1, product2, 30);
        List<String> products = new ArrayList<>();
        products.add("A");
        products.add("B");
        products.add("C");
        int total = promotion.apply(products);

        assertEquals(20, total);

    }

    @Test
    public void testApplyPromotion3WithOnlySecondProduct(){
        Product product1 = new Product("C", 20);
        Product product2 = new Product("D", 15);
        Promotion promotion = new PromotionB(product1, product2, 30);
        List<String> products = new ArrayList<>();
        products.add("A");
        products.add("B");
        products.add("D");
        int total = promotion.apply(products);

        assertEquals(15, total);

    }

    @Test
    public void testApplyPromotion3WithBothProducts(){
        Product product1 = new Product("C", 20);
        Product product2 = new Product("D", 15);
        Promotion promotion = new PromotionB(product1, product2, 30);
        List<String> products = new ArrayList<>();
        products.add("A");
        products.add("C");
        products.add("D");
        int total = promotion.apply(products);

        assertEquals(30, total);

    }

    @Test
    public void testApplyPromotion3WithNoProduct(){
        Product product1 = new Product("C", 20);
        Product product2 = new Product("D", 15);
        Promotion promotion = new PromotionB(product1, product2, 30);
        List<String> products = new ArrayList<>();
        products.add("A");
        products.add("B");
        int total = promotion.apply(products);

        assertEquals(0, total);

    }
}
