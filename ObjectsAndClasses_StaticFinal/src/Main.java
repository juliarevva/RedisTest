public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer(ComputerVendor.ACER, "Model 1",
                new CPU(3.0, 4, CPUVendor.AMD, 0.04),
                new Hard(HardType.HDD, 256, 0.2),
                new RAM(RAMType.DDR3, 16, 0.05),
                new Screen(ScreenType.TN, 15, 0.7),
                new Keyboard(KeyboardType.BLUETOOTH, true, 0.2));

        System.out.println(computer);
        computer.setHard(new Hard(HardType.SSD, 512, 0.05));
        System.out.println("\n");
        System.out.println(computer);

        Computer computer1 = new Computer(ComputerVendor.APPLE, "Macbook Air",
                new CPU(5.8, 8, CPUVendor.APPLE, 0.1),
                new Hard(HardType.SSD, 1024, 0.2),
                new RAM(RAMType.DDR5, 16, 0.2),
                new Screen(ScreenType.IPS, 13, 0.5),
                new Keyboard(KeyboardType.MEMBRANE, true, 0.2));
        System.out.println("\n");
        System.out.println(computer1);

    }
}
