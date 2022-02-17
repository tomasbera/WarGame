package BattleSimulation;

import SpecificUnits.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class BattleTest {

    @Test
    void simulate() {
        Army armyTest1 = new Army("A");
        Army armyTest2 = new Army("B");
        Battle battle = new Battle(armyTest1, armyTest2);

        List<Unit> listTest1 = new ArrayList<>();
        Unit infantryTest1 = new InfantryUnit("Knight", 10);
        Unit RangeTest1 = new RangedUnit("Bowmen", 10);
        Unit CavalryTest1 = new CavalryUnit("Rider", 10);

        listTest1.add(infantryTest1);
        listTest1.add(RangeTest1);
        listTest1.add(CavalryTest1);

        List<Unit> listTest2 = new ArrayList<>();
        Unit infantryTest2 = new InfantryUnit("Orc", 10);
        Unit RangeTest2 = new RangedUnit("Orc crossbow", 10);
        Unit CavalryTest2 = new CavalryUnit("Wolf rider", 10);

        listTest2.add(infantryTest2);
        listTest2.add(RangeTest2);
        listTest2.add(CavalryTest2);


        armyTest1.addAll(listTest1);
        armyTest2.addAll(listTest2);
        battle.whoStarts();

        System.out.println(battle.simulate().toString());


    }

    @Test
    void whoStarts() {
        Army test1 = new Army("A");
        Army test2 = new Army("B");
        Battle battle = new Battle(test1, test2);
        battle.whoStarts();

        assertNotNull(battle.attackingArmy);
        assertNotNull(battle.defendingArmy);

    }

    @Test
    void testToString() {
        Army test1 = new Army("A");
        Army test2 = new Army("B");
        Battle battle = new Battle(test1, test2);
        battle.whoStarts();

        assertEquals("A\n[]\n\nB\n[]", battle.toString());
    }
}

