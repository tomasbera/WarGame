package SpecificUnits;

public class CommanderUnit extends CavalryUnit{

    /**
     * this is the constructor for all units
     * @param name
     * @param health
     * @param attack damage
     * @param armor  protection
     * @throws Exception if health sett < 0 thr exception
     */
    public CommanderUnit(String name, int health, int attack, int armor) throws Exception {
        super(name, health, attack, armor);
    }

    /**
     * an easier constructor with predefined attack and armor
     * @param name
     * @param health
     * @throws Exception if health sett < 0 thr exception
     */
    public CommanderUnit(String name, int health) throws Exception {
        super(name, health, 25, 15);
    }

    /**
     *
     * @return
     */
    @Override
    int getAttackBonus() {
        return super.getAttackBonus();
    }

    /**
     *
     * @return
     */
    @Override
    int getResistBonus() {
        return super.getResistBonus();
    }
}
