public class UC9_QuantityMeasurementApp {

    public static void main(String[] args) {

        UC9_QuantityWeight w1 = new UC9_QuantityWeight(1.0, UC9_WeightUnit.KILOGRAM);
        UC9_QuantityWeight w2 = new UC9_QuantityWeight(1000.0, UC9_WeightUnit.GRAM);

        System.out.println("Equality: " + w1.equals(w2));

        UC9_QuantityWeight w3 = new UC9_QuantityWeight(2.0, UC9_WeightUnit.POUND);
        System.out.println("Convert to KG: " + w3.convertTo(UC9_WeightUnit.KILOGRAM));

        System.out.println("Addition: " + w1.add(w2));

        System.out.println("Addition in GRAM: " + w1.add(w2, UC9_WeightUnit.GRAM));
    }
}