public class QuantityMeasurementUC6 {

    // Enum (base = FEET)
    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CM(0.0328084);

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toBase(double value) {
            return value * toFeet;
        }

        public double fromBase(double feetValue) {
            return feetValue / toFeet;
        }
    }

    // Quantity class
    static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
            if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

            this.value = value;
            this.unit = unit;
        }

        // ADD METHOD (CORE UC6)
        public Quantity add(Quantity other) {
            if (other == null) throw new IllegalArgumentException("Other quantity is null");

            // convert both to base (feet)
            double thisFeet = this.unit.toBase(this.value);
            double otherFeet = other.unit.toBase(other.value);

            // add
            double sumFeet = thisFeet + otherFeet;

            // convert back to THIS unit
            double resultValue = this.unit.fromBase(sumFeet);

            return new Quantity(resultValue, this.unit);
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    public static void main(String[] args) {

        // Same unit
        System.out.println(
                new Quantity(1.0, LengthUnit.FEET)
                        .add(new Quantity(2.0, LengthUnit.FEET))
        );

        // Feet + Inches
        System.out.println(
                new Quantity(1.0, LengthUnit.FEET)
                        .add(new Quantity(12.0, LengthUnit.INCH))
        );

        // Inches + Feet
        System.out.println(
                new Quantity(12.0, LengthUnit.INCH)
                        .add(new Quantity(1.0, LengthUnit.FEET))
        );

        // Yard + Feet
        System.out.println(
                new Quantity(1.0, LengthUnit.YARD)
                        .add(new Quantity(3.0, LengthUnit.FEET))
        );

        // CM + Inch
        System.out.println(
                new Quantity(2.54, LengthUnit.CM)
                        .add(new Quantity(1.0, LengthUnit.INCH))
        );
    }
}
