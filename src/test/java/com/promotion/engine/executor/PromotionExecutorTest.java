package com.promotion.engine.executor;

import com.promotion.engine.product.Product;
import com.promotion.engine.promotions.Promotion;
import com.promotion.engine.promotions.PromotionA;
import com.promotion.engine.promotions.PromotionB;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PromotionExecutorTest {

    static Map<String,Product> allProducts = new HashMap<String,Product>();
    static List<Promotion> promotions = new ArrayList<>();
    static PromotionExecutor promotionExecutor = null;

    @BeforeClass
    public static void setup(){
        Product productA = new Product("A", 50);
        Product productB = new Product("B", 30);
        Product productC = new Product("C", 20);
        Product productD = new Product("D", 15);
        allProducts.put("A", productA);
        allProducts.put("B", productB);
        allProducts.put("C", productC);
        allProducts.put("D", productD);
        promotions.add(new PromotionA(productA, 3, 130));
        promotions.add(new PromotionA(productB, 2, 45));
        promotions.add(new PromotionB(productC, productD, 30));
        promotionExecutor = new PromotionExecutor(promotions, allProducts);
    }
    @Test
    public void testApplyPromotionScenario1(){
        List<String> products = new ArrayList<>();
        products.add("A");
        products.add("B");
        products.add("C");
        int total = promotionExecutor.applyPromotions(products);

        assertEquals(100, total);
    }

    @Test
    public void testApplyPromotionScenario2(){
        List<String> products = new ArrayList<>();
        products.add("A");
        products.add("A");
        products.add("A");
        products.add("A");
        products.add("A");
        products.add("B");
        products.add("B");
        products.add("B");
        products.add("B");
        products.add("B");
        products.add("C");
        int total = promotionExecutor.applyPromotions(products);

        assertEquals(370, total);
    }

    @Test
    public void testApplyPromotionScenario3(){
        List<String> products = new ArrayList<>();
        products.add("A");
        products.add("A");
        products.add("A");
        products.add("B");
        products.add("B");
        products.add("B");
        products.add("B");
        products.add("B");
        products.add("C");
        products.add("D");
        int total = promotionExecutor.applyPromotions(products);

        assertEquals(280, total);
    }
}
