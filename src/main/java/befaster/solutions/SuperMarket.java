package befaster.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperMarket {

    private final Map<Character, Integer> standardPrice;
    private final List<SpecialOfferResolver> specialOfferResolvers;

    public SuperMarket(){

        standardPrice = new HashMap<>();
        standardPrice.put('A', 50);
        standardPrice.put('B', 30);
        standardPrice.put('C', 20);
        standardPrice.put('D', 15);
        standardPrice.put('E', 40);

        specialOfferResolvers = new ArrayList<>();

        specialOfferResolvers.add(new SpecialOfferE());
        specialOfferResolvers.add(new SpecialOfferA());
        specialOfferResolvers.add(new SpecialOfferB());

    }

    public int checkout(String skus){
        if(skus == null || skus.isEmpty()){
            return 0;
        }

        final Map<Character, Integer> productsCount = new HashMap<>();
        for (Character character : standardPrice.keySet()){
            productsCount.put(character, 0);
        }

        for(char c : skus.toCharArray()){
            if(!productsCount.containsKey(c)){
                return -1;
            } else {
                productsCount.put(c, productsCount.get(c) + 1);
            }


        }

        return calculatePrice(productsCount);
    }


    private int calculatePrice(final Map<Character, Integer> productsCount){
        int totalPrice = 0;
        for(SpecialOfferResolver specialOfferResolver : specialOfferResolvers) {
            totalPrice += specialOfferResolver.resolve(productsCount);
        }

        for(Character product : productsCount.keySet()){
            int productCount = productsCount.get(product);
            totalPrice += standardPrice.get(product) * productCount;
        }

        return totalPrice;
    }

}
