package BattleSimulation;

import SpecificUnits.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {

    public Army armyTest;

    @BeforeEach
    void Initiate_army_with_units(){
        String testName = "Human Army";
        armyTest = new Army(testName);

        List<Unit> listTest = new ArrayList<>();
        Unit infantryTest = new InfantryUnit("Knight", 10);
        Unit RangeTest = new RangedUnit("Bowmen", 10);
        Unit CavalryTest = new CavalryUnit("Rider", 10);
        Unit CommanderUnit = new CommanderUnit("Commander", 10);

        listTest.add(infantryTest);
        listTest.add(RangeTest);
        listTest.add(CavalryTest);
        listTest.add(CommanderUnit);

        armyTest.addAll(listTest);

    }

    @Test
    void Test_if_constructor_Works_as_expected(){
        Army armyTest = new Army("Human Army");
        assertEquals("Human Army", armyTest.getName());
    }

    @Test
    void Test_to_see_if_other_constructor_also_works(){
        ArrayList<Unit> unitList = new ArrayList<>();
        unitList.add(new InfantryUnit("name",1,1,1,1));
        Army armyTest = new Army("Human Army", unitList);
        assertEquals(unitList.get(0), armyTest.getUnits().get(0));
    }

    @Test
    void getName() {
        assertEquals("Human Army", armyTest.getName());
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
        assertEquals(3, armyTest.getUnits().size());
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
        assertTrue(armyTest.hasUnits());
    }

    @Test
    void getAllUnits() {
        assertEquals(2, armyTest.getAllUnits().size());
    }

    @Test
    void getRandom() {
        assertNotNull(armyTest.getRandom());
    }

    @Nested
    public class Test_for_GetMethods_for_different_object_from_one_list {

        @Test
        public void Test_if_getInfantry_units_only_has_all_infantry_units_in_a_army(){
            assertTrue(armyTest.getInfantryUnits().get(0) instanceof InfantryUnit);
        }

        @Test
        public void Test_if_getRange_units_only_has_all_range_units_in_a_army(){
            assertTrue(armyTest.getRangeUnits().get(0) instanceof RangedUnit);
        }

        @Test
        public void Test_if_getCavalry_units_only_has_all_cavalry_units_in_a_army(){
            assertTrue(armyTest.getCavalryUnits().get(0) instanceof CavalryUnit);
        }

        @Test
        public void Test_if_getCommander_units_only_has_all_commander_units_in_a_army(){
           assertTrue(armyTest.getCommanderUnits().get(0) instanceof CommanderUnit);
        }

        @Test
        public void Test_to_see_if_commander_unit_can_be_accessed_from_getCavalryUnits(){
           assertNotEquals(2, armyTest.getCavalryUnits().size());
        }
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