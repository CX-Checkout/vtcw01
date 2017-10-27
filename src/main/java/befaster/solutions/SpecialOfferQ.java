package befaster.solutions;

import java.util.Map;

public class SpecialOfferQ implements SpecialOfferResolver{

    @Override
    public int resolve(Map<Character, Integer> productsCount) {

        int productCount = productsCount.get('Q');
        int totalPrice = 0;
        while(productCount >= 3){
            productCount -= 3;
            totalPrice +=  80;
        }

        productsCount.put('Q', productCount);
        return totalPrice;
    }
}
