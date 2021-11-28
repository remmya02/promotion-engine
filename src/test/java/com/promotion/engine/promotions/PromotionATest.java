package com.promotion.engine.promotions;

import com.promotion.engine.product.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PromotionATest {

    @Test
    public void testApplyPromotion1ForUniqueProduct(){
        Product product = new Product("A", 50);
        Promotion promotion = new PromotionA(product, 3, 130);
        List<String> products = new ArrayList<>();
        products.add("A");
        products.add("B");
        products.add("C");
        int total = promotion.apply(products);

        assertEquals(50, total);

    }

    @Test
    public void testApplyPromotion1ForDuplicateProduct(){
        Product product = new Product("A", 50);
        Promotion promotion = new PromotionA(product, 3, 130);
        List<String> products = new ArrayList<>();
        products.add("A");
        products.add("A");
        products.add("A");
        products.add("A");
        products.add("A");
        int total = promotion.apply(products);

        assertEquals(230, total);

    }

    @Test
    public void testApplyPromotion2(){
        Product product = new Product("B", 30);
        Promotion promotion = new PromotionA(product, 2, 45);
        List<String> products = new ArrayList<>();
        products.add("A");
        products.add("B");
        products.add("C");
        int total = promotion.apply(products);

        assertEquals(30, total);

    }

    @Test
    public void testApplyPromotion2ForDuplicateProduct(){
        Product product = new Product("B", 30);
        Promotion promotion = new PromotionA(product, 2, 45);
        List<String> products = new ArrayList<>();
        products.add("B");
        products.add("B");
        products.add("B");
        products.add("B");
        products.add("B");
        int total = promotion.apply(products);

        assertEquals(120, total);

    }
}
