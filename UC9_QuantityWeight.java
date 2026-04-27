public class UC9_QuantityWeight {

    private final double value;
    private final UC9_WeightUnit unit;
    private static final double EPSILON = 1e-6;

    public UC9_QuantityWeight(double value, UC9_WeightUnit unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    public UC9_QuantityWeight convertTo(UC9_WeightUnit targetUnit) {
        double base = unit.convertToBaseUnit(value);
        double result = targetUnit.convertFromBaseUnit(base);
        return new UC9_QuantityWeight(result, targetUnit);
    }

    public UC9_QuantityWeight add(UC9_QuantityWeight other) {
        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);
        double sum = base1 + base2;

        double result = unit.convertFromBaseUnit(sum);
        return new UC9_QuantityWeight(result, unit);
    }

    public UC9_QuantityWeight add(UC9_QuantityWeight other, UC9_WeightUnit targetUnit) {
        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);
        double sum = base1 + base2;

        double result = targetUnit.convertFromBaseUnit(sum);
        return new UC9_QuantityWeight(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UC9_QuantityWeight)) return false;

        UC9_QuantityWeight other = (UC9_QuantityWeight) obj;

        double base1 = unit.convertToBaseUnit(value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < EPSILON;
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}
