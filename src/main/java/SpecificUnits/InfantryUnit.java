package SpecificUnits;

/**
 * Infantry class that represents all the variables and methods of an infantry unit
 */
public class InfantryUnit extends Unit{

    /**
     * this is the constructor for all units
     * @param name
     * @param health
     * @param attack damage
     * @param armor  protection
     * @param melee melee damage
     * @throws IllegalArgumentException if health sett < 0 or name is empty thr exception
     */
    public InfantryUnit(String name, int health, int attack, int armor, int melee) throws IllegalArgumentException {
        super(name, health, attack, armor, melee);
    }

    /**
     * a constructor with predefined attack and armor
     * @param name
     * @param health
     * @throws IllegalArgumentException if health sett < 0 or name is empty thr exception
     */
    public InfantryUnit(String name, int health) throws IllegalArgumentException {
        this(name, health, 15, 10, 2);
    }

    /**
     * this unit is a melee unit
     * @return which means that it gets a +2 as a AttackBonus
     */
    @Override
     int getAttackBonus() {
        return this.getMelee();
    }

    /**
     * infantry unit has only a small armor bonus
     * @return because of small armor bonus add 1 as a ResistBonus
     */
    @Override
    int getResistBonus() {
        return 1;
    }
}
