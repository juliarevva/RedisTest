public class Hard {

    private final HardType hardType;
    private final int hardVolume;
    private final double hardWeight;

    public double getHardWeight() {
        return hardWeight;
    }

    public Hard(HardType hardType, int hardVolume, double hardWeight) {
        this.hardType = hardType;
        this.hardVolume = hardVolume;
        this.hardWeight = hardWeight;
    }

    public String toString() {
        return "\n" + "Hard" + "\n" + "\t" +
                "Type: " + hardType + "\n" + "\t" +
                "Volume: " + hardVolume + "GB" + "\n" + "\t" +
                "Weight: " + hardWeight + "kg";
    }


}
