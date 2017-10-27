package befaster.solutions;

import java.util.Map;

public class SpecialOfferH implements SpecialOfferResolver{

    @Override
    public int resolve(Map<Character, Integer> productsCount) {

        int productCount = productsCount.get('H');
        int totalPrice = 0;
        while(productCount >= 10){
            productCount -= 10;
            totalPrice +=  80;
        }

        while(productCount >= 5){
            productCount -= 5;
            totalPrice +=  45;
        }

        productsCount.put('H', productCount);
        return totalPrice;
    }
}
