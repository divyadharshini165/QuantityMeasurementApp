
public class QuantityMeasurementUC8 {

    static class Quantity {
        private final double value;
        private final LengthUnit unit;

        public Quantity(double value, LengthUnit unit) {
            if (unit == null) throw new IllegalArgumentException("Unit cannot be null");
            if (!Double.isFinite(value)) throw new IllegalArgumentException("Invalid value");

            this.value = value;
            this.unit = unit;
        }

        // ✅ Equality (UC1–UC4)
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            Quantity other = (Quantity) obj;

            double thisFeet = unit.toBase(value);
            double otherFeet = other.unit.toBase(other.value);

            return Double.compare(thisFeet, otherFeet) == 0;
        }

        // ✅ Conversion (UC5)
        public Quantity convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) throw new IllegalArgumentException("Target unit null");

            double base = unit.toBase(value);
            double result = targetUnit.fromBase(base);

            return new Quantity(result, targetUnit);
        }

        // ✅ Addition UC6
        public Quantity add(Quantity other) {
            return add(other, this.unit);
        }

        // ✅ Addition UC7
        public Quantity add(Quantity other, LengthUnit targetUnit) {
            if (other == null) throw new IllegalArgumentException("Other null");
            if (targetUnit == null) throw new IllegalArgumentException("Target null");

            double sum = unit.toBase(value) + other.unit.toBase(other.value);
            double result = targetUnit.fromBase(sum);

            return new Quantity(result, targetUnit);
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    public static void main(String[] args) {

        // Conversion
        System.out.println(new Quantity(1.0, LengthUnit.FEET).convertTo(LengthUnit.INCH));

        // Addition
        System.out.println(
                new Quantity(1.0, LengthUnit.FEET)
                        .add(new Quantity(12.0, LengthUnit.INCH), LengthUnit.FEET)
        );

        // Equality
        System.out.println(
                new Quantity(36.0, LengthUnit.INCH)
                        .equals(new Quantity(1.0, LengthUnit.YARD))
        );

        // More tests
        System.out.println(
                new Quantity(2.54, LengthUnit.CM)
                        .convertTo(LengthUnit.INCH)
        );
    }
}