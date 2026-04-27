public enum LengthUnit {

    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0),
    CM(0.0328084);

    private final double toFeet;

    LengthUnit(double toFeet) {
        this.toFeet = toFeet;
    }

    // convert TO base (feet)
    public double toBase(double value) {
        return value * toFeet;
    }

    // convert FROM base (feet)
    public double fromBase(double baseValue) {
        return baseValue / toFeet;
    }
}
