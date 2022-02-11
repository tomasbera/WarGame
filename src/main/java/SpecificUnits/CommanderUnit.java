package SpecificUnits;

public class CommanderUnit extends CavalryUnit{

    /**
     * this is the constructor for all units
     * @param name
     * @param health
     * @param attack damage
     * @param armor  protection
     * @throws Exception if health sett < 0 or name is empty thr exception
     */
    public CommanderUnit(String name, int health, int attack, int armor, int melee) throws Exception {
        super(name, health, attack, armor, melee);
    }

    /**
     * an easier constructor with predefined attack and armor
     * @param name
     * @param health
     * @throws Exception if health sett < 0 thr exception
     */
    public CommanderUnit(String name, int health) throws Exception {
        super(name, health, 25, 15, 2);
    }

    /**
     *this method represents the attackBonuses of a cavalry unit
     * the first attack of this unit will it will get a charge bonus +3
     * later on it will only have the melee attack as main attackBonus
     * @return ether +5 or +2 as a attackBonus, depends on the firstCharge bonus
     */
    @Override
    int getAttackBonus() {
        return super.getAttackBonus();
    }

    /**
     * this unit has a better protection than basic infantry, and has a bonus of +3 to resistance
     * @return bonus of 3 as resistance
     */
    @Override
    int getResistBonus() {
        return super.getResistBonus();
    }
}
