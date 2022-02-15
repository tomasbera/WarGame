package SpecificUnits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfantryUnitTest {

    @Test
    void attack() {
        Unit test1 = new InfantryUnit("knight",1,1,1,2);
        Unit test2 = new InfantryUnit("Orc",10,1,1,1);

        test1.attack(test2);

        assertEquals(9, test2.getHealth());

    }

    @Test
    void getName() {
        Unit test = new InfantryUnit("Knight",10);
        assertEquals("Knight",test.getName());
    }

    @Test
    void getHealth() {
        Unit test = new InfantryUnit("Knight", 10);
        assertEquals(10,test.getHealth());
    }

    @Test
    void getAttack() {
        Unit test = new InfantryUnit("knight",1,2,3,4);
        assertEquals(2,test.getAttack());
    }

    @Test
    void getArmor() {
        Unit test = new InfantryUnit("knight",1,2,3,4);
        assertEquals(3,test.getArmor());
    }

    @Test
    void getMelee() {
        Unit test = new InfantryUnit("knight",1,2,3,4);
        assertEquals(4,test.getMelee());
    }

    @Test
    void setHealth() {
        Unit test = new InfantryUnit("knight",1,2,3,4);
        test.setHealth(10);
        assertEquals(10,test.getHealth());
    }

    @Test
    void testToString() {
        Unit test = new InfantryUnit("knight",1,2,3,4);
        assertEquals("\n"+ """
                The statistics of unit:\s
                knight
                Health:
                1
                Damage/DP:
                2
                Armor/AP\s
                3""",test.toString());
    }

    @Test
    void getAttackBonus() {
        Unit test1 = new InfantryUnit("knight",1,0,0,2);
        Unit test2 = new InfantryUnit("Orc",10,0,0,0);

        test1.attack(test2);

        assertEquals(9, test2.getHealth());
    }

    @Test
    void getResistBonus() {
        Unit test1 = new InfantryUnit("knight",1,0,0,2);
        Unit test2 = new InfantryUnit("Orc",10,0,0,0);

        test1.attack(test2);

        assertEquals(9, test2.getHealth());
    }
}