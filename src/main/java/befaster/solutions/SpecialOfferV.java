package befaster.solutions;

import java.util.Map;

public class SpecialOfferV implements SpecialOfferResolver{

    @Override
    public int resolve(Map<Character, Integer> productsCount) {

        int productCount = productsCount.get('V');
        int totalPrice = 0;
        while(productCount >= 3){
            productCount -= 3;
            totalPrice +=  130;
        }

        while(productCount >= 2){
            productCount -= 2;
            totalPrice +=  90;
        }

        productsCount.put('V', productCount);
        return totalPrice;
    }
}
