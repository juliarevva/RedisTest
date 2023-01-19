public class RAM {

    private final RAMType ramType;
    private final int ramVolume;
    private final double ramWeight;

    public double getRamWeight() {
        return ramWeight;
    }

    public RAM(RAMType ramType, int ramVolume, double ramWeight) {
        this.ramType = ramType;
        this.ramVolume = ramVolume;
        this.ramWeight = ramWeight;
    }

    public String toString() {
        return "\n" + "RAM" +  "\n" + "\t" +
                "Type: " + ramType + "\n" + "\t" +
                "Volume: " + ramVolume + "GB" + "\n" + "\t" +
                "Weight: " + ramWeight + "kg";
    }
}
