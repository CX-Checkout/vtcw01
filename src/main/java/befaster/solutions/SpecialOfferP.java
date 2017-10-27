package befaster.solutions;

import java.util.Map;

public class SpecialOfferP implements SpecialOfferResolver{

    @Override
    public int resolve(Map<Character, Integer> productsCount) {

        int productCount = productsCount.get('P');
        int totalPrice = 0;
        while(productCount >= 5){
            productCount -= 5;
            totalPrice +=  200;
        }

        productsCount.put('P', productCount);
        return totalPrice;
    }
}
