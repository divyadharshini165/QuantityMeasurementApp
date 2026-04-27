public class QuantityMeasurementUC4 {

    // Enum with all units (base = FEET)
    enum LengthUnit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CM(0.0328084); // 1 cm = 0.0328084 feet

        private final double toFeet;

        LengthUnit(double toFeet) {
            this.toFeet = toFeet;
        }

        public double toBase(double value) {
            return value * toFeet;
        }
    }

    // Generic Quantity class
    static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            double thisInFeet = this.unit.toBase(this.value);
            double otherInFeet = other.unit.toBase(other.value);

            return Double.compare(thisInFeet, otherInFeet) == 0;
        }
    }

    public static void main(String[] args) {

        // Yard ↔ Feet
        System.out.println("1 yard == 3 feet ? " +
                new Quantity(1.0, LengthUnit.YARD)
                        .equals(new Quantity(3.0, LengthUnit.FEET)));

        // Yard ↔ Inches
        System.out.println("1 yard == 36 inches ? " +
                new Quantity(1.0, LengthUnit.YARD)
                        .equals(new Quantity(36.0, LengthUnit.INCH)));

        // Same unit
        System.out.println("2 yard == 2 yard ? " +
                new Quantity(2.0, LengthUnit.YARD)
                        .equals(new Quantity(2.0, LengthUnit.YARD)));

        // CM ↔ CM
        System.out.println("2 cm == 2 cm ? " +
                new Quantity(2.0, LengthUnit.CM)
                        .equals(new Quantity(2.0, LengthUnit.CM)));

        // CM ↔ Inches
        System.out.println("1 cm == 0.393701 inch ? " +
                new Quantity(1.0, LengthUnit.CM)
                        .equals(new Quantity(0.393701, LengthUnit.INCH)));
    }
}