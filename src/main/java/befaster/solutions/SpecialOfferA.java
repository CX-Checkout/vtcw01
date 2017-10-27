package befaster.solutions;

import java.util.Map;

public class SpecialOfferA implements SpecialOfferResolver {

    @Override
    public int resolve(Map<Character, Integer> productsCount) {

        int productCount = productsCount.get('A');
        int totalPrice = 0;

        while(productCount >= 5){
            productCount -= 5;
            totalPrice +=  200;
        }
        while(productCount >= 3){
            productCount -= 3;
            totalPrice +=  130;
        }

        productsCount.put('A', productCount);
        return totalPrice;
    }
}
