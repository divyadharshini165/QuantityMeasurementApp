public class QuantityMeasurementUC7 {

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

        // ✅ UC6 method (same as before)
        public Quantity add(Quantity other) {
            return add(other, this.unit); // default = first unit
        }

        // ✅ UC7 method (NEW FEATURE)
        public Quantity add(Quantity other, LengthUnit targetUnit) {
            if (other == null) throw new IllegalArgumentException("Other quantity is null");
            if (targetUnit == null) throw new IllegalArgumentException("Target unit is null");

            // convert both to base (feet)
            double thisFeet = this.unit.toBase(this.value);
            double otherFeet = other.unit.toBase(other.value);

            // add
            double sumFeet = thisFeet + otherFeet;

            // convert to TARGET unit
            double resultValue = targetUnit.fromBase(sumFeet);

            return new Quantity(resultValue, targetUnit);
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    public static void main(String[] args) {

        // FEET target
        System.out.println(
                new Quantity(1.0, LengthUnit.FEET)
                        .add(new Quantity(12.0, LengthUnit.INCH), LengthUnit.FEET)
        );

        // INCH target
        System.out.println(
                new Quantity(1.0, LengthUnit.FEET)
                        .add(new Quantity(12.0, LengthUnit.INCH), LengthUnit.INCH)
        );

        // YARD target
        System.out.println(
                new Quantity(1.0, LengthUnit.FEET)
                        .add(new Quantity(12.0, LengthUnit.INCH), LengthUnit.YARD)
        );

        // YARD + FEET → YARD
        System.out.println(
                new Quantity(1.0, LengthUnit.YARD)
                        .add(new Quantity(3.0, LengthUnit.FEET), LengthUnit.YARD)
        );

        // INCH + YARD → FEET
        System.out.println(
                new Quantity(36.0, LengthUnit.INCH)
                        .add(new Quantity(1.0, LengthUnit.YARD), LengthUnit.FEET)
        );

        // CM + INCH → CM
        System.out.println(
                new Quantity(2.54, LengthUnit.CM)
                        .add(new Quantity(1.0, LengthUnit.INCH), LengthUnit.CM)
        );
    }
}
