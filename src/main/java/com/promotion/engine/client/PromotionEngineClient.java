package com.promotion.engine.client;

import com.promotion.engine.executor.PromotionExecutor;
import com.promotion.engine.product.Product;
import com.promotion.engine.promotions.Promotion;
import com.promotion.engine.promotions.PromotionA;
import com.promotion.engine.promotions.PromotionB;

import java.util.*;

public class PromotionEngineClient {

    public static void main(String[] args) {
        Product productA = new Product("A", 50);
        Product productB = new Product("B", 30);
        Product productC = new Product("C", 20);
        Product productD = new Product("D", 15);
        Map<String,Product> allProducts = new HashMap<String,Product>();
        allProducts.put("A", productA);
        allProducts.put("B", productB);
        allProducts.put("C", productC);
        allProducts.put("D", productD);
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
        List<Promotion> promotions = new ArrayList<>();
        promotions.add(new PromotionA(productA, 3, 130));
        promotions.add(new PromotionA(productB, 2, 45));
        promotions.add(new PromotionB(productC, productD, 30));
        PromotionExecutor promotionExecutor = new PromotionExecutor(promotions, allProducts);
        int total = promotionExecutor.applyPromotions(products);

        System.out.println(total);

    }
}
