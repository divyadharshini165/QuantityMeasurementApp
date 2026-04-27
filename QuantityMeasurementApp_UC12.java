public class QuantityMeasurementApp_UC12 {

    public static void main(String[] args) {

        // LENGTH
        Quantity<LengthUnit> l1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> l2 = new Quantity<>(6.0, LengthUnit.INCHES);

        System.out.println("Subtraction (Length): " + l1.subtract(l2));
        System.out.println("Division (Length): " + l1.divide(l2));

        // WEIGHT
        Quantity<WeightUnit> w1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(5000.0, WeightUnit.GRAM);

        System.out.println("Subtraction (Weight): " + w1.subtract(w2));
        System.out.println("Division (Weight): " + w1.divide(w2));

        // VOLUME
        Quantity<VolumeUnit> v1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        System.out.println("Subtraction (Volume): " + v1.subtract(v2));
        System.out.println("Division (Volume): " + v1.divide(v2));
    }
}