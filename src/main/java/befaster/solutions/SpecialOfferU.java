package befaster.solutions;

import java.util.Map;

public class SpecialOfferU implements SpecialOfferResolver{

    @Override
    public int resolve(Map<Character, Integer> productsCount) {

        int productCountU = productsCount.get('U');
        int totalPrice = 0;
        while(productCountU >= 4){
            productCountU = productCountU -4;
            totalPrice += 120;
        }

        productsCount.put('U', productCountU);
        return totalPrice;
    }
}
