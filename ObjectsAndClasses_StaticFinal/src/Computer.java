public class Computer {

        private final ComputerVendor computerVendor;
        private final String computerName;
        private CPU cpu;
        private Hard hard;
        private RAM ram;
        private Screen screen;
        private Keyboard keyboard;

        public Computer(ComputerVendor computerVendor, String computerName,
                        CPU cpu, Hard hard, RAM ram, Screen screen, Keyboard keyboard) {
            this.computerVendor = computerVendor;
            this.computerName = computerName;
            this.cpu = cpu;
            this.hard = hard;
            this.ram = ram;
            this.screen = screen;
            this.keyboard = keyboard;
        }


        public ComputerVendor getComputerVendor() { return computerVendor; }

        public String getComputerName() { return computerName; }

        public CPU getCpu() { return cpu; }

        public Hard getHard() { return hard; }

        public RAM getRam() { return ram; }

        public Screen getScreen() { return screen; }

        public Keyboard getKeyboard() { return keyboard; }


        public void setCpu(CPU cpu) {
            this.cpu = cpu;
        }

        public void setHard(Hard hard) {
            this.hard = hard;
        }

        public void setRam(RAM ram) {
            this.ram = ram;
        }

        public void setScreen(Screen screen) {
            this.screen = screen;
        }

        public void setKeyboard(Keyboard keyboard) {
            this.keyboard = keyboard;
        }

        public double totalWeight () {
            return cpu.getCpuWeight() + hard.getHardWeight() + ram.getRamWeight() + screen.getScreenWeight() + keyboard.getKeyboardWeight();

        }



        public String toString() {
            return  "Computer" + "\n" + "Vendor: " + getComputerVendor()
                    + "\n" + "Name: " + getComputerName() +
                    getCpu() + getHard() + getRam() + getScreen() + getKeyboard() +
                    "\n" + "Total Weight: " + totalWeight() + "kg";
        }



}
