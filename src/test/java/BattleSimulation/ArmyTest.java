package BattleSimulation;

import SpecificUnits.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {

    @Test
    void getName() {
        String testName = "Human Army";
        Army armies = new Army(testName);

        assertEquals("Human Army", armies.getName());
    }

    @Test
    void add() {
        String testName = "Human Army";
        Army armies = new Army(testName);

        Unit infantryTest = new InfantryUnit("Knight", 10);
        armies.add(infantryTest);

        assertEquals(infantryTest,armies.getUnits().get(0));

    }

    @Test
    void addAll() {
        String testName = "Human Army";
        Army armies = new Army(testName);

        List<Unit> listTest = new ArrayList<>();
        Unit infantryTest = new InfantryUnit("Knight", 10);
        Unit RangeTest = new RangedUnit("Bowmen", 10);
        Unit CavalryTest = new CavalryUnit("Rider", 10);

        listTest.add(infantryTest);
        listTest.add(RangeTest);
        listTest.add(CavalryTest);

        armies.addAll(listTest);

        assertEquals(3, armies.getUnits().size());

    }

    @Test
    void remove() {
        String testName = "Human Army";
        Army armies = new Army(testName);

        Unit infantryTest = new InfantryUnit("Knight", 10);
        armies.add(infantryTest);

        armies.remove(infantryTest);

        assertEquals(0,armies.getUnits().size());

    }

    @Test
    void hasUnits() {
        String testName1 = "Human Army";
        Army armyTest1 = new Army(testName1);
        Unit testUnit = new InfantryUnit("Knight", 10);

        assertTrue(armyTest1.hasUnits());

        armyTest1.add(testUnit);
        assertFalse(armyTest1.hasUnits());
    }

    @Test
    void getAllUnits() {
        String testName = "Human Army";
        Army armyTest = new Army(testName);

        List<Unit> listTest = new ArrayList<>();
        Unit infantryTest = new InfantryUnit("Knight", 10);
        Unit RangeTest = new RangedUnit("Bowmen", 10);

        listTest.add(infantryTest);
        listTest.add(RangeTest);
        armyTest.addAll(listTest);

        assertEquals(2, armyTest.getAllUnits().size());

    }

    @Test
    void getRandom() {
        String testName = "Human Army";
        Army armies = new Army(testName);

        List<Unit> listTest = new ArrayList<>();
        Unit infantryTest = new InfantryUnit("Knight", 10);
        Unit RangeTest = new RangedUnit("Bowmen", 10);
        Unit CavalryTest = new CavalryUnit("Rider", 10);

        listTest.add(infantryTest);
        listTest.add(RangeTest);
        listTest.add(CavalryTest);

        armies.addAll(listTest);

        assertNotNull(armies.getRandom());

    }

    @Test
    void testEquals() {
        String testName1 = "Human Army";
        String testName2 = "Orc Army";

        Army armyTest1 = new Army(testName1);
        Army armyTest2 = new Army(testName2);
        Army armyTest3 = armyTest1;
        Army armyTest4 = new Army(testName1);

        assertNotEquals(armyTest1, armyTest2);
        assertTrue(armyTest1.equals(armyTest3));
        assertTrue(armyTest1.equals(armyTest4));

    }

    @Test
    void testHashCode() {
        String testName1 = "Human Army";
        String testName2 = "Orc Army";

        Army armyTest1 = new Army(testName1);
        Army armyTest2 = new Army(testName2);
        Army armyTest3 = armyTest1;

        assertNotEquals(armyTest1.hashCode(), armyTest2.hashCode());
        assertEquals(armyTest1.hashCode(), armyTest3.hashCode());
    }

    @Test
    void testToString() {
        String testName1 = "Human Army";
        Army armyTest1 = new Army(testName1);

        assertEquals("Human Army\nunits=[]", armyTest1.toString());
    }
}