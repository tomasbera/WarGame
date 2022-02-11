package SpecificUnits;

public class RangedUnit extends Unit {

    /**
     * this is the constructor for all units
     * @param name
     * @param health
     * @param attack damage
     * @param armor  protection
     * @throws Exception if health sett < 0 or name is empty thr exception
     */
    public RangedUnit(String name, int health, int attack, int armor) throws Exception {
        super(name, health, attack, armor);
    }

    /**
     * an easier constructor with predefined attack and armor
     * @param name
     * @param health
     * @throws Exception if health sett < 0 thr exception
     */
    public RangedUnit(String name, int health) throws Exception {
        super(name, health, 15, 8);
    }

    /**
     *
     * @return
     */
    @Override
    int getAttackBonus() {
        return 0;
    }

    /**
     *
     * @return
     */
    @Override
    int getResistBonus() {
        return 0;
    }
}
