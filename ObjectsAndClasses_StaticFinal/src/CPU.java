public class CPU {

    private final CPUVendor cpuVendor;
    private final int cores;
    private final double frequency;
    private final double cpuWeight;

    public double getCpuWeight() {
        return cpuWeight;
    }

    public CPU(double frequency, int cores, CPUVendor cpuVendor, double cpuWeight) {
        this.frequency = frequency;
        this.cores = cores;
        this.cpuVendor = cpuVendor;
        this.cpuWeight = cpuWeight;
    }


    public String toString() {
        return "\n" + "CPU" + "\n" + "\t" +
                "Vendor=" + cpuVendor +"\n" + "\t" +
                "Cores: " + cores +"\n" + "\t" +
                "Frequency: " + frequency + "Hz" + "\n" + "\t" +
                "Weight: " + cpuWeight + "kg";
    }
}
