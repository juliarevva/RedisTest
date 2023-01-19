public class Keyboard {

    private final KeyboardType keyboardType;
    private final boolean keyboardBacklight;
    private final double keyboardWeight;

    public double getKeyboardWeight() {
        return keyboardWeight;
    }

    public Keyboard(KeyboardType keyboardType, boolean keyboardBacklight, double keyboardWeight) {
        this.keyboardType = keyboardType;
        this.keyboardBacklight = keyboardBacklight;
        this.keyboardWeight = keyboardWeight;
    }

    public String toString() {
        return "\n" + "Keyboard" + "\n" + "\t" +
                "Type: " + keyboardType + "\n" + "\t" +
                "Backlight: " + keyboardBacklight + "\n" + "\t" +
                "Weight: " + keyboardWeight + "kg";
    }
}
