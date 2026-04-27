import org.junit.Test;
import static org.junit.Assert.*;

public class QuantityMeasurementUC11Test {

    @Test
    public void testLitreToMillilitreEquality() {
        Quantity<VolumeUnit_UC11> v1 = new Quantity<>(1.0, VolumeUnit_UC11.LITRE);
        Quantity<VolumeUnit_UC11> v2 = new Quantity<>(1000.0, VolumeUnit_UC11.MILLILITRE);

        assertTrue(v1.equals(v2));
    }

    @Test
    public void testGallonToLitreConversion() {
        Quantity<VolumeUnit_UC11> v = new Quantity<>(1.0, VolumeUnit_UC11.GALLON);

        Quantity<VolumeUnit_UC11> result = v.convertTo(VolumeUnit_UC11.LITRE);

        assertEquals(3.78541, result.getValue(), 0.01);
    }

    @Test
    public void testAddition() {
        Quantity<VolumeUnit_UC11> v1 = new Quantity<>(1.0, VolumeUnit_UC11.LITRE);
        Quantity<VolumeUnit_UC11> v2 = new Quantity<>(1000.0, VolumeUnit_UC11.MILLILITRE);

        Quantity<VolumeUnit_UC11> result = v1.add(v2);

        assertEquals(2.0, result.getValue(), 0.01);
    }
}