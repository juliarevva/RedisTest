public class Main {
    public static void main(String[] args) {
//        Container container = new Container();
//        container.addCount(5672);
//        System.out.println(container.getCount());

        for (char a = 'А'; a <= 'Я'; a++) {
                System.out.println((int) a + "-" + a);
        }
        System.out.print("\n");

        for (char a = 'а'; a <= 'я'; a++) {
            System.out.println((int) a + "-" + a);
        }
        System.out.print("\n");

        char a = 'Ё';
        char b = 'ё';
        System.out.println((int) a + "-" + a +
                "\n" + (int) b + "-" + b);
    }
}
