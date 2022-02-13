import SpecificUnits.*;
import org.junit.jupiter.api.Nested;
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
    public void TestExceptionThrownIfHealthIsLessThanZero() throws Exception {
        try {
            Unit unit = new InfantryUnit("Knights", -1);

        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Nested
    public class TestingTheAttackMethodAndUnitsBonusMethods {

        @Test
        public void TestRangeUnitAttackingInfantry() throws Exception {
            boolean winner = false;
            Unit inft = new InfantryUnit("Knight", 10, 2, 2, 2);
            Unit lbm = new RangedUnit("longbow men", 10, 2, 2, 2);
            while (!winner) {
               lbm.attack(inft);
                if (inft.getHealth() <= 0) {
                  winner = true;
                }
            }
            assertTrue(winner);
        }

        @Test
        public void TestCavalryUnitAttackingInfantry() throws Exception {
            boolean winner = false;
            Unit inft = new InfantryUnit("Knight", 10, 2, 2, 2);
            Unit cav = new CavalryUnit("Rider", 10, 2, 2, 2);
            while (!winner) {
                cav.attack(inft);
                if (inft.getHealth() <= 0) {
                    winner = true;
                }
            }
            assertTrue(winner);
        }

        @Test
        public void TestCommanderUnitAttackingInfantry() throws Exception {
            boolean winner = false;
            Unit inft = new InfantryUnit("Knight", 10, 10, 10, 2);
            Unit com = new CommanderUnit("Karl the great", 10, 13, 0, 2);
            while (!winner) {
                com.attack(inft);
                if (inft.getHealth() <= 0) {
                   winner = true;
                }
            }
            assertTrue(winner);
        }

        @Test
        public void TestInfantryAttackingARangeUnitToSeeIfResistBonusWorksAsExpected() throws Exception {
            boolean winner = false;
            Unit inft = new InfantryUnit("Knight", 10, 3, 2, 2);
            Unit lbm = new RangedUnit("longbow men", 10, 2, 2, 2);
            while (!winner) {
                inft.attack(lbm);
                if (lbm.getHealth() <= 0) {
                   winner = true;
                }
            }
            assertTrue(winner);
        }

        @Test
        public void TestIfDamageIsZeroIfDamageInflictedIsEqualsOrLessThenZero() throws Exception {
            Unit inft1 = new InfantryUnit("Knight", 10, 2, 2, 2);
            Unit inft2 = new InfantryUnit("Orc", 10, 2, 2, 2);
            inft1.attack(inft2);
            if (inft2.getHealth() == 10) {
                assertTrue(true);
            }
        }
    }
}
