package SpecificUnits;

/**
 * Range class that represents all the variables and methods of a ranger unit
 */
public class RangedUnit extends Unit {

    private static String unitType;
    private int distanceDamage = 0;
    private int distanceResist = 0;

    /**
     * this is the constructor for all units
     * @param name
     * @param health
     * @param attack damage
     * @param armor  protection
     * @param melee melee damage
     * @throws IllegalArgumentException if health sett < 0 or name is empty thr exception
     */
    public RangedUnit(String name, int health, int attack, int armor, int melee) throws IllegalArgumentException {
        super(name, health, attack, armor, melee);
    }

    /**
     * an easier constructor with predefined attack and armor
     * @param name
     * @param health
     * @throws IllegalArgumentException if health sett < 0 or name is empty thr exception
     */
    public RangedUnit(String name, int health) throws IllegalArgumentException {
        this(name, health, 15, 8, 2);
    }

    /**
     * Range unit has a range attack bonus
     * @return because this unit is range, this unit gets +3 as AttackBonus
     * @param terrain
     */
    @Override
     int getAttackBonus(int terrain) {
        if (terrain == 1){
            if(distanceDamage >= 3){
                return this.getMelee() + 1;
            }
            distanceDamage++;
            return 4;
        } else if (terrain == 3) {
            return getMelee() + 1;
        } else {
            if(distanceDamage >= 3){
                return this.getMelee();
            }
            distanceDamage++;
            return 2;
        }
    }

    /**
     * Range units has an uniq resistantBonus that works as distance between him and his opponent
     * @return because of this the range unit returns a bonus based on the variable multiplier (distance)
     * @param terrain
     */
    @Override
    int getResistBonus(int terrain) {
        int resistBonus = 6 - 2 * distanceResist;
        if(resistBonus <= 2){
            resistBonus = 2;
        }
        distanceResist++;
        return resistBonus;
    }

    @Override
    public Unit deepCopyUnit(Unit u) {
        return new RangedUnit(u.getName(), u.getHealth(), u.getAttack(), u.getArmor(), u.getMelee());
    }

    public static String getUnitType() {
        unitType = "RangeUnit";
        return unitType;
    }
}
