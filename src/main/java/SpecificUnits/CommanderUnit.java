package SpecificUnits;

/**
 *  Commander class that represents all the variables and methods of a commander unit
 */
public class CommanderUnit extends CavalryUnit{

    /**
     * this is the constructor for all units
     * @param name
     * @param health
     * @param attack damage
     * @param armor  protection
     * @param melee melee damage
     * @throws IllegalArgumentException if health sett < 0 or name is empty thr exception
     */
    public CommanderUnit(String name, int health, int attack, int armor, int melee) throws IllegalArgumentException {
        super(name, health, attack, armor, melee);
    }

    /**
     * an easier constructor with predefined attack and armor
     * @param name
     * @param health
     * @throws IllegalArgumentException if health sett < 0 or name is empty thr exception
     */
    public CommanderUnit(String name, int health) throws IllegalArgumentException {
        this(name, health, 25, 15, 2);
    }

    /**
     *this method represents the attackBonuses of a cavalry unit
     * the first attack of this unit will it will get a charge bonus +3
     * later on it will only have the melee attack as main attackBonus
     * @return ether +5 or +2 as a attackBonus, depends on the firstCharge bonus
     * @param terrain
     */
    @Override
     int getAttackBonus(int terrain) {
        return super.getAttackBonus(terrain);
    }

    /**
     * this unit has a better protection than basic infantry, and has a bonus of +3 to resistance
     * @return bonus of 3 as resistance
     * @param terrain
     */
    @Override
    int getResistBonus(int terrain) {
        return super.getResistBonus(terrain);
    }

    @Override
    public Unit deepCopyUnit(Unit u) {
        return new CommanderUnit(u.getName(), u.getHealth(), u.getAttack(), u.getArmor(), u.getMelee());
    }
}
