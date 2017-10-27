package befaster.solutions;

import java.util.Map;

public class SpecialOfferN implements SpecialOfferResolver{

    @Override
    public int resolve(Map<Character, Integer> productsCount) {

        int productCountN = productsCount.get('N');
        int productCountM = productsCount.get('M');
        int totalPrice = 0;
        while(productCountN >= 3 && productCountM > 0){
            productCountM = productCountM -1;
            productCountN -= 3;
            totalPrice += 120;
        }

        productsCount.put('N', productCountN);
        productsCount.put('M', productCountM);
        return totalPrice;
    }
}
