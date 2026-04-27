public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // LENGTH
        Quantity<LengthUnit> q1 = new Quantity<>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> q2 = new Quantity<>(6.0, LengthUnit.INCHES);

        System.out.println("Length Subtraction: " + q1.subtract(q2));
        System.out.println("Length Division: " + q1.divide(q2));

        // WEIGHT
        Quantity<WeightUnit> w1 = new Quantity<>(10.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> w2 = new Quantity<>(5000.0, WeightUnit.GRAM);

        System.out.println("Weight Subtraction: " + w1.subtract(w2));
        System.out.println("Weight Division: " + w1.divide(w2));

        // VOLUME
        Quantity<VolumeUnit> v1 = new Quantity<>(5.0, VolumeUnit.LITRE);
        Quantity<VolumeUnit> v2 = new Quantity<>(500.0, VolumeUnit.MILLILITRE);

        System.out.println("Volume Subtraction: " + v1.subtract(v2));
        System.out.println("Volume Division: " + v1.divide(v2));
    }
}