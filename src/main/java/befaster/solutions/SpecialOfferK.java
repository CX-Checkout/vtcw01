package befaster.solutions;

import java.util.Map;

public class SpecialOfferK implements SpecialOfferResolver{

    @Override
    public int resolve(Map<Character, Integer> productsCount) {

        int productCount = productsCount.get('K');
        int totalPrice = 0;
        while(productCount >= 2){
            productCount -= 2;
            totalPrice +=  120;
        }

        productsCount.put('K', productCount);
        return totalPrice;
    }
}
