package com.promotion.engine.promotions;

import com.promotion.engine.product.Product;

import java.util.Iterator;
import java.util.List;

public class PromotionA implements Promotion{
    Product product;
    int count;
    int fixedPrice;

    public PromotionA(Product product, int count, int fixedPrice) {
        this.product = product;
        this.count = count;
        this.fixedPrice = fixedPrice;
    }

    @Override
    public Integer apply(List<String> products) {
        int occurence = 0;
        int total = 0;
        Iterator<String> iter = products.iterator();
        while(iter.hasNext()){
            String currentProduct = iter.next();
            if(currentProduct.equalsIgnoreCase(product.getProductId())){
                occurence = occurence + 1;
                iter.remove();
            }
        }
        if(occurence < count){
            return occurence * product.getUnitPrice();
        }
        while (occurence >=count){
            total = total + fixedPrice;
            occurence = occurence - count;
        }
        if(occurence > 0){
            total = total + (occurence * product.getUnitPrice());
        }
        return total;
    }
}
