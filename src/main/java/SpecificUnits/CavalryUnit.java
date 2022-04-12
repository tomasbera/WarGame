package SpecificUnits;

/**
 * Cavalry class that represents the cavalry unit with special features
 */
public class CavalryUnit extends Unit {
private boolean firstCharge = true;
    /**
     * this is the constructor for all units
     * @param name
     * @param health
     * @param attack damage
     * @param armor  protection
     * @param melee melee damage
     * @throws IllegalArgumentException if health sett < 0 or name is empty thr exception
     */
    public CavalryUnit(String name, int health, int attack, int armor,int melee) throws IllegalArgumentException {
        super(name, health, attack, armor, melee);
    }

    /**
     * an easier constructor with predefined attack and armor and melee
     * @param name
     * @param health
     * @throws IllegalArgumentException if health sett < 0 or name is empty thr exception
     */
    public CavalryUnit(String name, int health) throws IllegalArgumentException {
        this(name, health, 20, 12, 2);
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
        if (terrain == 2){
            if(firstCharge){
                firstCharge = false;
                return this.getMelee() + 5;
            }
            return this.getMelee();
        } else {
            if(firstCharge){
                firstCharge = false;
                return this.getMelee() + 3;
            }
            return this.getMelee();
        }
    }

    /**
     * this unit has a better protection than basic infantry, and has a bonus of +3 to resistance
     * @return bonus of 3 as resistance
     * @param terrain
     */
    @Override
    int getResistBonus(int terrain) {
        int cavalry = 3;
        if (terrain == 3){
            return 0;
        } else {
            return cavalry;
        }
    }
}
