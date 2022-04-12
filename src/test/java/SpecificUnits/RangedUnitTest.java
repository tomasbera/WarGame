package SpecificUnits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangedUnitTest {

    @Test
    void attack() {
        Unit test1 = new Unit("Bowman", 10, 1, 0, 0) {
            @Override
            int getAttackBonus(int terrain) {
                return 0;
            }

            @Override
            int getResistBonus(int terrain) {
                return 0;
            }
        };
        Unit test2 = new Unit("Knight", 10, 0, 0, 0) {
            @Override
            int getAttackBonus(int terrain) {
                return 0;
            }

            @Override
            int getResistBonus(int terrain) {
                return 0;
            }
        };

        test1.attack(test2);

        assertEquals(9, test2.getHealth());
    }

    @Test
    void getName() {
        Unit test = new RangedUnit("Bowmen",10);
        assertEquals("Bowmen",test.getName());
    }

    @Test
    void getHealth() {
        Unit test = new RangedUnit("Bowmen",1);
        assertEquals(1,test.getHealth());
    }

    @Test
    void getAttack() {
        Unit test = new RangedUnit("Bowmen",1,2,3,4);
        assertEquals(2,test.getAttack());
    }

    @Test
    void getArmor() {
        Unit test = new RangedUnit("Bowmen",1,2,3,4);
        assertEquals(3,test.getArmor());
    }

    @Test
    void getMelee() {
        Unit test = new RangedUnit("Bowmen",1,2,3,4);
        assertEquals(4,test.getMelee());
    }

    @Test
    void setHealth() {
        Unit test = new RangedUnit("Bowmen",1,2,3,4);
        test.setHealth(2);
        assertEquals(2,test.getHealth());
    }

    @Test
    void testToString() {
        Unit test = new RangedUnit("Bowmen",1,2,3,4);
        assertEquals("\n\n"+ """
                The statistics of unit:\s
                Bowmen
                Health:
                1
                Damage/DP:
                2
                Armor/AP\s
                3""",test.toString());
    }

    @Test
    void getAttackBonus() {
        Unit test1 = new RangedUnit("Bowman",10,2,1,1);
        Unit test2 = new InfantryUnit("Knight",20,1,1,1);

        test1.attack(test2);
        test1.attack(test2);
        test1.attack(test2);
        test1.attack(test2);
        test1.attack(test2);

        assertEquals(9, test2.getHealth());
    }

    @Test
    void getResistBonus() {
        Unit test1 = new RangedUnit("Bowman",15,0,0,0);
        Unit test2 = new InfantryUnit("Knight",0,3,0,2);

        test2.attack(test1);
        test2.attack(test1);
        test2.attack(test1);
        test2.attack(test1);
        test2.attack(test1);

        assertEquals(5, test1.getHealth());

    }
}