package com.promotion.engine.executor;

import com.promotion.engine.product.Product;
import com.promotion.engine.promotions.Promotion;

import java.util.List;
import java.util.Map;

public class PromotionExecutor {

    List<Promotion> promotions;
    Map<String, Product> allProducts;

    public PromotionExecutor(List<Promotion> promotions, Map<String, Product> allProducts) {
        this.promotions = promotions;
        this.allProducts = allProducts;
    }

    public Integer applyPromotions(List<String> products) {
        int sum = 0;
        for(Promotion promotion : promotions) {
            sum = sum + promotion.apply(products);
        }
        if(products.size() > 0){
            for(int i = 0; i<products.size(); i++){
                sum = sum + allProducts.get(products.get(i)).getUnitPrice();
            }
        }
        return sum;
    }
}
