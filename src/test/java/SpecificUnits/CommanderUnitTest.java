package SpecificUnits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommanderUnitTest {
    @Test
    void attack() {
        Unit test1 = new CommanderUnit("Commander",10,1,1,2);
        Unit test2 = new InfantryUnit("Knight",10,1,1,1);

        test1.attack(test2);

        assertEquals(6, test2.getHealth());
    }

    @Test
    void getName() {
        Unit test = new CommanderUnit("Commander",10);
        assertEquals("Commander",test.getName());
    }

    @Test
    void getHealth() {
        Unit test = new CommanderUnit("Commander",1);
        assertEquals(1,test.getHealth());
    }

    @Test
    void getAttack() {
        Unit test = new CommanderUnit("Commander",1,2,3,4);
        assertEquals(2,test.getAttack());
    }

    @Test
    void getArmor() {
        Unit test = new CavalryUnit("Rider",1,2,3,4);
        assertEquals(3,test.getArmor());
    }

    @Test
    void getMelee() {
        Unit test = new CommanderUnit("Commander",1,2,3,4);
        assertEquals(4,test.getMelee());
    }

    @Test
    void setHealth() {
        Unit test = new CommanderUnit("Commander",1,2,3,4);
        test.setHealth(2);
        assertEquals(2,test.getHealth());
    }

    @Test
    void testToString() {
        Unit test = new CommanderUnit("Commander",1,2,3,4);
        assertEquals("\n"+ """
                The statistics of unit:\s
                Commander
                Health:
                1
                Damage/DP:
                2
                Armor/AP\s
                3""",test.toString());
    }

    @Test
    void getAttackBonus() {
        Unit test1 = new CommanderUnit("Commander",0,2,0,2);
        Unit test2 = new InfantryUnit("Knight",20,0,0,0);

        test1.attack(test2);
        test1.attack(test2);
        test1.attack(test2);


        assertEquals(8, test2.getHealth());
    }

    @Test
    void getResistBonus() {
        Unit test1 = new CommanderUnit("Commander",10,0,0,0);
        Unit test2 = new InfantryUnit("Knight",0,2,0,2);

        test2.attack(test1);
        test2.attack(test1);

        assertEquals(8, test1.getHealth());

    }
}