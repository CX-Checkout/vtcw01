package befaster.solutions;

public class SpecialOffer {

    final Character name;
    final int count;
    final int price;

    public SpecialOffer(Character name, int count, int price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public Character getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }
}
