public class Screen {

    private final ScreenType screenType;
    private final int diagonal;
    private final double screenWeight;

    public double getScreenWeight() {
        return screenWeight;
    }

    public Screen(ScreenType screenType, int diagonal, double screenWeight) {
        this.screenType = screenType;
        this.diagonal = diagonal;
        this.screenWeight = screenWeight;
    }

    public String toString() {
        return "\n" + "Screen" + "\n" + "\t" +
                "Type: " + screenType + "\n" + "\t" +
                "Diagonal: " + diagonal + "inch" + "\n" + "\t" +
                "Weight: " + screenWeight + "kg";
    }
}
