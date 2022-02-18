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
     */
    @Override
     int getAttackBonus() {
        int charge = 3;
       if(firstCharge){
           firstCharge = false;
           return this.getMelee() + charge;
       }

       return this.getMelee();
    }

    /**
     * this unit has a better protection than basic infantry, and has a bonus of +3 to resistance
     * @return bonus of 3 as resistance
     */
    @Override
    int getResistBonus() {
        int cavalry = 3;
        return cavalry;
    }
}
