package com.promotion.engine.promotions;

import com.promotion.engine.product.Product;

import java.util.Iterator;
import java.util.List;

public class PromotionB implements Promotion{
    Product product1;
    Product product2;
    int fixedPrice;

    public PromotionB(Product product1, Product product2, int fixedPrice) {
        this.product1 = product1;
        this.product2 = product2;
        this.fixedPrice = fixedPrice;
    }

    @Override
    public Integer apply(List<String> products) {
        int product1Occurence = 0;
        int product2Occurence = 0;
        int total = 0;
        Iterator<String> iter = products.iterator();
        while (iter.hasNext()) {
            String product = iter.next();
            if(product.equalsIgnoreCase(product1.getProductId())){
                product1Occurence = product1Occurence + 1;
                iter.remove();
            } else if(product.equalsIgnoreCase(product2.getProductId())) {
                product2Occurence = product2Occurence + 1;
                iter.remove();
            }
        }
        if(product1Occurence == 0 && product2Occurence == 0)
            return 0;
        if(product1Occurence > 0 && product2Occurence == 0)
            return product1Occurence * product1.getUnitPrice();
        if(product2Occurence > 0 && product1Occurence == 0)
            return product2Occurence * product2.getUnitPrice();

        int count = Math.min(product1Occurence, product2Occurence);
        total = total + (count * fixedPrice);

        if(product1Occurence - count > 0)
            total = total + (product1Occurence - count) * product1.getUnitPrice();
        else if(product2Occurence - count > 0)
            total = total + (product2Occurence - count) * product2.getUnitPrice();

        return total;
    }
}
