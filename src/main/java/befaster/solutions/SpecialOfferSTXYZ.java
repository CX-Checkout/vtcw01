package befaster.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SpecialOfferSTXYZ implements SpecialOfferResolver{

    private final List<Character> stxyz;

    public SpecialOfferSTXYZ(Map<Character, Integer> standardPrice){
        stxyz = new ArrayList<>();
        stxyz.add('S');
        stxyz.add('T');
        stxyz.add('X');
        stxyz.add('Y');
        stxyz.add('Z');

        Collections.sort(stxyz, (o1, o2) -> {
            final Integer integer1 = standardPrice.get(o1);
            final Integer integer2 = standardPrice.get(o2);
            return integer1.compareTo(integer2);
        });
        Collections.reverse(stxyz);
    }

    @Override
    public int resolve(Map<Character, Integer> productsCount) {

        int totalPrice = 0;
        int productCount = getProductsCount(productsCount);

        while (productCount >= 3){
            productCount -= 3;
            totalPrice += 45;
            updateProductsCount(productsCount, 3);
        }

        return totalPrice;
    }

    private int getProductsCount(Map<Character, Integer> productsCount){
        int productCount = 0;
        for (Character character : stxyz){
            productCount += productsCount.get(character);
        }
        return  productCount;
    }

    private void updateProductsCount(Map<Character, Integer> productsCount, int count){

        for (Character character : stxyz){

            int productCount = productsCount.get(character);
            while(productCount > 0){
                productCount--;
                count--;
                productsCount.put(character, productCount);
                if(count == 0) {
                    return;
                }
            }
        }
    }

}
