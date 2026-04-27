import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementUC2Test {

    @Test
    void testFeet_SameValue() {
        assertTrue(QuantityMeasurementUC2.compareFeet(1.0, 1.0));
    }

    @Test
    void testFeet_DifferentValue() {
        assertFalse(QuantityMeasurementUC2.compareFeet(1.0, 2.0));
    }

    @Test
    void testInches_SameValue() {
        assertTrue(QuantityMeasurementUC2.compareInches(1.0, 1.0));
    }

    @Test
    void testInches_DifferentValue() {
        assertFalse(QuantityMeasurementUC2.compareInches(1.0, 2.0));
    }

    @Test
    void testNullComparison() {
        QuantityMeasurementUC2.Feet f = new QuantityMeasurementUC2.Feet(1.0);
        assertFalse(f.equals(null));
    }

    @Test
    void testSameReference() {
        QuantityMeasurementUC2.Inches i = new QuantityMeasurementUC2.Inches(1.0);
        assertTrue(i.equals(i));
    }
}