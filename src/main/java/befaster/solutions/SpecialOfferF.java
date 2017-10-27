package befaster.solutions;

import java.util.Map;

public class SpecialOfferF implements SpecialOfferResolver{

    @Override
    public int resolve(Map<Character, Integer> productsCount) {

        int productCountF = productsCount.get('F');
        int totalPrice = 0;
        while(productCountF >= 3){
            productCountF = productCountF -3;
            totalPrice += 20;
        }

        productsCount.put('F', productCountF);
        return totalPrice;
    }
}
