import SpecificUnits.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A unit test class that tests all war units, and the unit blueprint
 */

public class UnitTest{

    @Test
    public void Test_Exception_Thrown_IfName_Is_Blank() {
        try {
            Unit unit = new InfantryUnit("", 12);
            fail("This constructor should throw an IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void Test_Exception_Thrown_If_Health_Is_Less_Than_Zero() {
        try {
            Unit unit = new InfantryUnit("Knights", -1);

        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
