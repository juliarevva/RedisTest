public class Cargo {

    private final Dimensions dimensions;
    private final int weight;
    private final String deliveryAddress;
    private final boolean canBeFlipped;
    private final String regNumber;
    private final boolean fragile;

    public Cargo(Dimensions dimensions, int weight,
                 String deliveryAddress, boolean canBeFlipped,
                 String regNumber, boolean fragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.canBeFlipped = canBeFlipped;
        this.regNumber = regNumber;
        this.fragile = fragile;
    }

    public Cargo setDimensions (Dimensions dimensions) {
        return new Cargo(dimensions, weight, deliveryAddress, canBeFlipped, regNumber, fragile);
    }

    public Cargo setWeight (int weight) {
        return new Cargo(dimensions, weight, deliveryAddress, canBeFlipped, regNumber, fragile);
    }

    public Cargo setDeliveryAddress (String deliveryAddress) {
        return new Cargo(dimensions, weight, deliveryAddress, canBeFlipped, regNumber, fragile);
    }


    public String toString () {
        return "RegNumber: " + regNumber + "\n" +
                "Dimensions: " + dimensions + "\n" +
                "Address: " + deliveryAddress + "\n" +
                "Flipped/Fragile: " + canBeFlipped + "/" + fragile + "\n" +
                "Weight: " + weight;

    }


}
