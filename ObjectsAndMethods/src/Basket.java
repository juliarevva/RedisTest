public class Basket {

    private static int count = 0;
    private static int totalPriceInAllBaskets;
    private static int totalItemsInAllBaskets;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;


    public Basket() {
        increaseCount(1);
        items = "Product list:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }


    public static int getCount() {
        return count;
    }

    private static int getTotalPriceInAllBaskets() {
        return totalPriceInAllBaskets;
    }

    private static int getTotalItemsInAllBaskets() {
        return totalItemsInAllBaskets;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    private static int averageItemPrice() {
        return getTotalPriceInAllBaskets() / getTotalItemsInAllBaskets();
    }

    private static int averageBasketPrice() {
        return getTotalPriceInAllBaskets() / getCount();
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " pcs - " + price + "$";
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + weight * count;
        totalPriceInAllBaskets = totalPriceInAllBaskets + count * price;
        totalItemsInAllBaskets = totalItemsInAllBaskets + count;

    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println("\n" + title);
        if (items.isEmpty()) {
            System.out.println("Your items is full");
        } else {
            System.out.println(items);
            System.out.println("Total Price " + totalPrice + "$" + "\n" + "Total Weight " + totalWeight +" gr");
            System.out.println("\t" + "Total Price In All Baskets: " + totalPriceInAllBaskets + "$" +
                    "\n" + "\t" + "Total Items In All Baskets: " + totalItemsInAllBaskets +
                    "\n" + "\t" + "Count of Baskets: " + getCount() +
                    "\n" + "\t" + "Average Item Price: " + averageItemPrice() + "$" +
                    "\n" + "\t" + "Average Basket Price: " + averageBasketPrice() + "$");
        }
    }
}
