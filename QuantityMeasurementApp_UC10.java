public class QuantityMeasurementApp_UC10 {

    public static <U extends IMeasurable_UC10> void demonstrateEquality(
            Quantity_UC10<U> q1, Quantity_UC10<U> q2) {

        System.out.println(q1 + " == " + q2 + " → " + q1.equals(q2));
    }

    public static <U extends IMeasurable_UC10> void demonstrateConversion(
            Quantity_UC10<U> q, U target) {

        System.out.println(q + " → " + q.convertTo(target));
    }

    public static <U extends IMeasurable_UC10> void demonstrateAddition(
            Quantity_UC10<U> q1, Quantity_UC10<U> q2, U target) {

        System.out.println(q1 + " + " + q2 + " → " + q1.add(q2, target));
    }

    public static void main(String[] args) {

        // Length
        Quantity_UC10<LengthUnit_UC10> l1 =
                new Quantity_UC10<>(1.0, LengthUnit_UC10.FEET);
        Quantity_UC10<LengthUnit_UC10> l2 =
                new Quantity_UC10<>(12.0, LengthUnit_UC10.INCHES);

        demonstrateEquality(l1, l2);
        demonstrateConversion(l1, LengthUnit_UC10.INCHES);
        demonstrateAddition(l1, l2, LengthUnit_UC10.FEET);

        // Weight
        Quantity_UC10<WeightUnit_UC10> w1 =
                new Quantity_UC10<>(1.0, WeightUnit_UC10.KILOGRAM);
        Quantity_UC10<WeightUnit_UC10> w2 =
                new Quantity_UC10<>(1000.0, WeightUnit_UC10.GRAM);

        demonstrateEquality(w1, w2);
        demonstrateConversion(w1, WeightUnit_UC10.GRAM);
        demonstrateAddition(w1, w2, WeightUnit_UC10.KILOGRAM);
    }
}