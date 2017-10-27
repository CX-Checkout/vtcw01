package befaster.solutions;

import java.util.Map;

public class SpecialOfferE implements SpecialOfferResolver{

    @Override
    public int resolve(Map<Character, Integer> productsCount) {

        int productCountE = productsCount.get('E');
        int productCountB = productsCount.get('B');
        int totalPrice = 0;
        while(productCountE >= 2 && productCountB > 0){
            productCountB = productCountB -1;
            productCountE -= 2;
            totalPrice += 80;
        }

        productsCount.put('E', productCountE);
        productsCount.put('B', productCountB);

        return totalPrice;
    }
}
