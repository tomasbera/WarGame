package SpecificUnits;
public class RangedUnit extends Unit {
    private int distance = 0;

    /**
     * this is the constructor for all units
     * @param name
     * @param health
     * @param attack damage
     * @param armor  protection
     * @throws Exception if health sett < 0 or name is empty thr exception
     */
    public RangedUnit(String name, int health, int attack, int armor, int melee) throws Exception {
        super(name, health, attack, armor, melee);
    }

    /**
     * an easier constructor with predefined attack and armor
     * @param name
     * @param health
     * @throws Exception if health sett < 0 thr exception
     */
    public RangedUnit(String name, int health) throws Exception {
        super(name, health, 15, 8, 2);
    }

    /**
     * Range unit has a range attack bonus
     * @return because this unit is range, this unit gets +3 as AttackBonus
     */
    @Override
    int getAttackBonus() {
        int range = 3;
        if(distance == 3){
            return this.getMelee();
        }
        return range;
    }

    /**
     * Range units has an uniq resistantBonus that works as distance between him and his opponent
     * @return because of this the range unit returns a bonus based on the variable multiplier (distance)
     *
     */
    @Override
    int getResistBonus() {
        int damageDistance = 6 - 2 * distance;
        if(damageDistance <= 2){
            damageDistance = 2;
        }
        distance ++;
        return damageDistance;
    }
}
