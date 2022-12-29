import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Main {
//    public static void main(String[] args) {
//        Elevator elevator = new Elevator(-3, 26);
//        while (true) {
//            System.out.print("Введите номер этажа: ");
//            int floor = new Scanner(System.in).nextInt();
//            elevator.move(floor);
//        }
//    }

    public static void main(String[] args) {
        Cargo cargo = new Cargo(new Dimensions(5, 6, 7),500, "Moscow",
                true, "8U0TTT", true);

        System.out.println(cargo);

        Cargo copyCargo = cargo.setDimensions(new Dimensions(1, 1,
                1)).setWeight(100).setDeliveryAddress("Vereya");

        System.out.println("\n");
        System.out.println(copyCargo);
    }
}
