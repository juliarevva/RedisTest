public class Main {
    public static void main(String[] args) {
        Arithmetic arithmetic = new Arithmetic(3,4);

        arithmetic.sum();
        arithmetic.mult();
        arithmetic.max();
        arithmetic.min();

        System.out.println(arithmetic.sum());
        System.out.println(arithmetic.mult());
        System.out.println(arithmetic.max());
        System.out.println(arithmetic.min());
    }
}
