import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementUC1Test {

    @Test
    void testEquality_SameValue() {
        QuantityMeasurementUC1.Feet f1 = new QuantityMeasurementUC1.Feet(1.0);
        QuantityMeasurementUC1.Feet f2 = new QuantityMeasurementUC1.Feet(1.0);

        assertTrue(f1.equals(f2));
    }

    @Test
    void testEquality_DifferentValue() {
        QuantityMeasurementUC1.Feet f1 = new QuantityMeasurementUC1.Feet(1.0);
        QuantityMeasurementUC1.Feet f2 = new QuantityMeasurementUC1.Feet(2.0);

        assertFalse(f1.equals(f2));
    }
}