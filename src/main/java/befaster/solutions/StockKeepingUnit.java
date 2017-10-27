package befaster.solutions;

public class StockKeepingUnit {

    private final String name;
    private final int price;

    public StockKeepingUnit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
