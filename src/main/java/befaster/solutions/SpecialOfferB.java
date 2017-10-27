package befaster.solutions;

import java.util.Map;

public class SpecialOfferB implements SpecialOfferResolver {

    @Override
    public int resolve(Map<Character, Integer> productsCount) {

        int productCount = productsCount.get('B');
        int totalPrice = 0;

        while(productCount >= 2){
            productCount -= 2;
            totalPrice +=  45;
        }

        productsCount.put('B', productCount);
        return totalPrice;
    }
}
