public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("milk", 4, 1);
        basket.add("bread", 6, 1);
        basket.add("water", 10, 2);
        basket.print("Ann basket");

        Basket basket1 = new Basket();
        basket1.add("guitar", 1000, 1);
        basket1.print("Vitaly basket");

        Basket basket2 = new Basket();
        basket2.add("dress", 400, 1);
        basket2.add("water", 10, 1);
        basket2.print("Julia basket");
    }
}
