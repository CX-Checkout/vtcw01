package befaster.solutions;

import java.util.Map;

public class SpecialOfferR implements SpecialOfferResolver{

    @Override
    public int resolve(Map<Character, Integer> productsCount) {

        int productCountR = productsCount.get('R');
        int productCountQ = productsCount.get('Q');
        int totalPrice = 0;
        while(productCountR >= 3 && productCountQ > 0){
            productCountQ = productCountQ -1;
            productCountR -= 3;
            totalPrice += 150;
        }

        productsCount.put('R', productCountR);
        productsCount.put('Q', productCountQ);
        return totalPrice;
    }
}
