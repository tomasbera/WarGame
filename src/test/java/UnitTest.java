import SpecificUnits.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A unit test class that tests all war units, and the unit blueprint
 */

public class UnitTest{

    @Test
    public void TestExceptionThrownIfNameIsBlank() {
        try {
            Unit unit = new InfantryUnit("", 12);
            fail("This constructor should throw an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void TestExceptionThrownIfHealthIsLessThanZero() throws Exception {
        try {
            Unit unit = new InfantryUnit("Knights", -1);

        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
