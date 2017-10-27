package befaster.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperMarket {

    private final Map<Character, Integer> standardPrice;
    private final List<SpecialOfferResolver> specialOfferResolvers;

    public SuperMarket(){

        standardPrice = initPriceTable();

        specialOfferResolvers = new ArrayList<>();

        specialOfferResolvers.add(new SpecialOfferE());
        specialOfferResolvers.add(new SpecialOfferF());
        specialOfferResolvers.add(new SpecialOfferN());
        specialOfferResolvers.add(new SpecialOfferR());
        specialOfferResolvers.add(new SpecialOfferU());
        specialOfferResolvers.add(new SpecialOfferE());
        specialOfferResolvers.add(new SpecialOfferN());
        specialOfferResolvers.add(new SpecialOfferA());
        specialOfferResolvers.add(new SpecialOfferB());
        specialOfferResolvers.add(new SpecialOfferH());
        specialOfferResolvers.add(new SpecialOfferV());
        specialOfferResolvers.add(new SpecialOfferK());
        specialOfferResolvers.add(new SpecialOfferP());
        specialOfferResolvers.add(new SpecialOfferQ());


    }

            /*| Item | Price | Special offers         |
            +------+-------+------------------------+
            | A    | 50    | 3A for 130, 5A for 200 | ok
            | B    | 30    | 2B for 45              | ok
            | C    | 20    |                        | ok
            | D    | 15    |                        | ok
            | E    | 40    | 2E get one B free      | ok
            | F    | 10    | 2F get one F free      | ok
            | G    | 20    |                        | ok
            | H    | 10    | 5H for 45, 10H for 80  | ok
            | I    | 35    |                        | ok
            | J    | 60    |                        | ok
            | K    | 80    | 2K for 150             | ok
            | L    | 90    |                        | ok
            | M    | 15    |                        | ok
            | N    | 40    | 3N get one M free      | ok
            | O    | 10    |                        | ok
            | P    | 50    | 5P for 200             | ok
            | Q    | 30    | 3Q for 80              | ok
            | R    | 50    | 3R get one Q free      | ok
            | S    | 30    |                        | ok
            | T    | 20    |                        | ok
            | U    | 40    | 3U get one U free      | ok
            | V    | 50    | 2V for 90, 3V for 130  | ok
            | W    | 20    |                        | ok
            | X    | 90    |                        | ok
            | Y    | 10    |                        | ok
            | Z    | 50    |                        | ok
            +------+-------+------------------------+*/

    private Map<Character, Integer> initPriceTable(){

        Map<Character, Integer> standardPrice;
        standardPrice = new HashMap<>();

        standardPrice.put('A', 50);
        standardPrice.put('B', 30);
        standardPrice.put('C', 20);
        standardPrice.put('D', 15);
        standardPrice.put('E', 40);
        standardPrice.put('F', 10);
        standardPrice.put('G', 20);
        standardPrice.put('H', 10);
        standardPrice.put('I', 35);
        standardPrice.put('J', 60);
        standardPrice.put('K', 80);
        standardPrice.put('L', 90);
        standardPrice.put('M', 15);
        standardPrice.put('N', 40);
        standardPrice.put('O', 10);
        standardPrice.put('P', 50);
        standardPrice.put('Q', 30);
        standardPrice.put('R', 50);
        standardPrice.put('S', 30);
        standardPrice.put('T', 20);
        standardPrice.put('U', 40);
        standardPrice.put('V', 50);
        standardPrice.put('W', 20);
        standardPrice.put('X', 90);
        standardPrice.put('Y', 10);
        standardPrice.put('Z', 50);

        return standardPrice;
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
        for(SpecialOfferResolver specialOfferResolver : specialOfferResolvers){
            totalPrice += specialOfferResolver.resolve(productsCount);
        }

        for(Character product : productsCount.keySet()){
            int productCount = productsCount.get(product);
                totalPrice += standardPrice.get(product) * productCount;
        }
        return totalPrice;
    }

}
