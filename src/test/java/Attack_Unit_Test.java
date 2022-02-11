import SpecificUnits.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * A unit test class that tests all war units, and the unit blueprint
 */

public class Attack_Unit_Test {

    @Test
    public void TestExceptionThrownIfNameIsBlank() throws Exception {
        try {
            Unit unit = new InfantryUnit("", 12);

        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void TestExceptionThrownIfHealthIsLessThanZero() throws Exception{
        try{
            Unit unit = new InfantryUnit("Knights", -1);

        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void TestRangeUnitAttackingInfantry() throws Exception {
        Unit inft = new InfantryUnit("Knight", 10, 2, 2, 2);
        Unit lbm = new RangedUnit("longbow men", 10, 2, 2, 2);
        for (int i = 0; i < 5; i++) {
            lbm.attack(inft);
            System.out.println(inft.getHealth() +" " +"\n");
            }
        }

    @Test
    public void TestCavalryUnitAttackingInfantry() throws Exception {
        Unit inft = new InfantryUnit("Knight", 10, 2, 2, 2);
        Unit cav = new CavalryUnit("Rider", 10, 2, 2, 2);
        for (int i = 0; i < 5; i++) {
            cav.attack(inft);
            System.out.println(inft.getHealth() +" " +"\n");
        }
    }

    @Test
    public void TestCommanderUnitAttackingInfantry() throws Exception {
        Unit inft = new InfantryUnit("Knight", 10, 2, 2, 2);
        Unit com = new CommanderUnit("Karl the great", 10, 2, 2, 2);
        for (int i = 0; i < 5; i++) {
            com.attack(inft);
            System.out.println(inft.getHealth() +" " +"\n");
        }
    }
}
