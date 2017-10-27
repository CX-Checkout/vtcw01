package befaster.solutions;

import java.util.HashMap;
import java.util.Map;

public class SuperMarket {

    private final Map<Character, SpecialOffer> specialOffers;
    private final Map<Character, Integer> standardPrice;

    public SuperMarket(){

        standardPrice = new HashMap<>();
        standardPrice.put('A', 50);
        standardPrice.put('B', 30);
        standardPrice.put('C', 20);
        standardPrice.put('D', 15);

        final SpecialOffer specialOfferA = new SpecialOffer('A', 3, 130);
        final SpecialOffer specialOfferB = new SpecialOffer('B', 2, 45);
        specialOffers = new HashMap<>();
        specialOffers.put('A', specialOfferA);
        specialOffers.put('B', specialOfferB);

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

        for(Character product : productsCount.keySet()){
            int productCount = productsCount.get(product);

            if(specialOffers.containsKey(product)){
                final SpecialOffer specialOffer = specialOffers.get(product);
                final int specialOfferCount = specialOffer.getCount();

                while(productCount >= specialOfferCount){
                    productCount -= specialOfferCount;
                    totalPrice +=  specialOffer.getPrice();
                }
                totalPrice += standardPrice.get(product) * productCount;

            } else {
                totalPrice += standardPrice.get(product) * productCount;
            }

        }

        return totalPrice;
    }

}
