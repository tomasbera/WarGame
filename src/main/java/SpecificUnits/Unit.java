package SpecificUnits;

/**
 * SpecificUnits.Unit class that works as a blueprint for all future specific unitclasses
 * <p>
 *     has variables as name, health, DP and CP and to abstract methods
 *     which talks about bonus Damage or Armor
 * </p>
 */
public abstract class Unit {
    private String name;
    private int health;
    private int attack;
    private int armor;
    private int melee;


    /**
     * this is the constructor for all units
     * @param name
     * @param health
     * @param attack damage
     * @param armor protection
     * @param melee this is implemented as all my units will be using this melee variable
     * @throws IllegalArgumentException if health sett < 0 thr or name is empty exception
     */
    public Unit(String name, int health, int attack, int armor, int melee) throws IllegalArgumentException {
        if(name.isBlank()){
            throw new IllegalArgumentException("Name no blank bad");
        }
        this.name = name;

        if(health < 0){
            throw new IllegalArgumentException("health less zero bad");
        }
        this.health = health;

        //I think that attack and armor can be < 0 because in a war something can go wrong or very well
        // Eg: a catapult can malfunction, or a units armor can ble less and less efficient
        this.attack = attack;
        this.armor = armor;
        this.melee = melee;
    }

    /**
     * this is a attack method that takes simulates a unit attacking the opponent
     * @param opponent the one this unit attacks
     */
    public void attack(Unit opponent, int terrain){
        int newHealth = opponent.health - (this.attack + this.getAttackBonus(terrain)) +
                (opponent.armor + opponent.getResistBonus(terrain));
        if(newHealth < opponent.getHealth()){
            opponent.setHealth(newHealth);
        }
    }

    /**
     * get method for name of the unit
     * @return the name of this unit
     */
    public String getName() {
        return name;
    }

    /**
     * get method for health of the unit
     * @return the health of this unit
     */
    public int getHealth() {
        return health;
    }

    /**
     * get method for attacking damage of this unit
     * @return the damage or DP of this unit
     */
    public int getAttack() {
        return attack;
    }

    /**
     * get method for armor protection of the unit
     * @return the protection or AP of this unit
     */
    public int getArmor() {
        return armor;
    }

    /**
     * get method for when a unit changes to melee combat
     * @return the bonus of using melee
     */
    public int getMelee() {
        return melee;
    }

    /**
     * set method that changes the health of a unit if it gets damaged
     * @param newHealth the newhealth of this unit after it gets damaged
     */
    public void setHealth(int newHealth) {
        this.health = newHealth;
    }

    /**
     * an abstract method for showing an attacking bonus
     * <p>
     *     an abstract method which wil be declared,and further used in subclasses
     * </p>
     * @return attackBonus as an int
     * @param terrain
     */
     abstract int getAttackBonus(int terrain);

    /**
     * an abstract method for showing an armor bonus
     * <p>
     *     an abstract method which wil be declared,and further used in subclasses
     * </p>
     * @return ResistBonus as an int
     * @param terrain
     */
     abstract int getResistBonus(int terrain);


    /**
     * a to string method that print out a units statistics in an order
     * @return a string of all statistics
     */
    @Override
    public String toString() {
        return "\n\nThe statistics of unit: \n" +name+
                "\nHealth:\n" + health+
                "\nDamage/DP:\n" + attack+
                "\nArmor/AP \n" + armor;
    }

    public abstract Unit deepCopyUnit(Unit unit);

    public static String getUnitType() {
        return Unit.class.getTypeName();
    }
}
