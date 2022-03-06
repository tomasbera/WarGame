import SpecificUnits.*;
import org.junit.jupiter.api.Nested;
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

    @Test
    public void Test_If_Constructor_works_For_Infantry () {
        Unit InfantryTest = new InfantryUnit("Test",1,1,1,1);
        assertNotNull(InfantryTest);
    }


    @Test
    public void Test_If_Constructor_works_For_Range () {
        Unit RangeTest = new RangedUnit("Test",1,1,1,1);
        assertNotNull(RangeTest);
    }

    @Test
    public void Test_If_Constructor_works_For_Cavalry () {
        Unit CavalryTest = new CavalryUnit("Test",1,1,1,1);
        assertNotNull(CavalryTest);
    }

    @Test
    public void Test_If_Constructor_works_For_Commander () {
        Unit CommanderTest = new CommanderUnit("Test",1,1,1,1);
        assertNotNull(CommanderTest);
    }

    @Test
    public void Test_If_Constructor_works_For_Infantry_Easier_Constructor () {
        Unit InfantryTest = new InfantryUnit("Test",1);
        assertNotNull(InfantryTest);
    }

    @Test
    public void Test_If_Constructor_works_For_Range_Easier_Constructor () {
        Unit RangeTest = new RangedUnit("Test",1);
        assertNotNull(RangeTest);
    }
    @Test
    public void Test_If_Constructor_works_For_Cavalry_Easier_Constructor () {
        Unit CavalryTest = new CavalryUnit("Test",1);
        assertNotNull(CavalryTest);
    }

    @Test
    public void Test_If_Constructor_works_For_Commander_Easier_Constructor () {
        Unit CommanderTest = new CommanderUnit("Test",1,1,1,1);
        assertNotNull(CommanderTest);
    }
}
