package SpecificUnits;

public class InfantryUnit extends Unit{

    /**
     * this is the constructor for all units
     * @param name
     * @param health
     * @param attack damage
     * @param armor  protection
     * @throws Exception if health sett < 0 or name is empty thr exception
     */
    public InfantryUnit(String name, int health, int attack, int armor, int melee) throws Exception {
        super(name, health, attack, armor, melee);
    }

    /**
     * a constructor with predefined attack and armor
     * @param name
     * @param health
     * @throws Exception if health sett < 0 thr exception
     */
    public InfantryUnit(String name, int health) throws Exception {
        super(name, health, 15, 10, 2);
    }

    /**
     * this unit is a melee unit
     * @return which means that it gets a +2 as a AttackBonus
     */
    @Override
    int getAttackBonus() {
        int meleeBonus = this.getMelee();
        return meleeBonus;
    }

    /**
     * infantry unit has only a small armor bonus
     * @return because of small armor bonus add 1 as a ResistBonus
     */
    @Override
    int getResistBonus() {
        int smallArmor = 1;
        return smallArmor;
    }
}
