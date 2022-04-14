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
     * @param terrain
     */
    @Override
     int getAttackBonus(int terrain) {
        if(terrain == 3) return this.getMelee() + 1;
        else return this.getMelee();
    }

    /**
     * infantry unit has only a small armor bonus
     * @return because of small armor bonus add 1 as a ResistBonus
     * @param terrain
     */
    @Override
    int getResistBonus(int terrain) {
        if(terrain == 3) return  2;
        else return 1;
    }

    @Override
    public Unit deepCopyUnit(Unit u) {
        return new InfantryUnit(u.getName(), u.getHealth(), u.getAttack(), u.getArmor(), u.getMelee());
    }
}
