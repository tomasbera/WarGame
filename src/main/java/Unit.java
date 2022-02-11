/**
 * Unit class that works as a blueprint for all future specific unitclasses
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

    /**
     * this is the constructor for all units
     * @param name
     * @param health
     * @param attack damage
     * @param armor protection
     * @throws Exception if health sett <0 thr exception
     */
    public Unit(String name, int health, int attack, int armor) throws Exception {
        this.name = name;

        if(health < 0){
            throw new Exception("Health of a unit cant be less then zero");
        }
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * this is a attack method that takes simulates a unit attacking the opponent
     * @param opponent the one this unit attacks
     */
    public void attack(Unit opponent){
        int newHealth = opponent.health - (this.attack + this.getAttackBonus()) + (opponent.armor + opponent.getResistBonus());
        opponent.setHealth(newHealth);
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
     * get method for attacking damage of the unit
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
     */
    abstract int getAttackBonus();

    /**
     * an abstract method for showing an armor bonus
     * <p>
     *     an abstract method which wil be declared,and further used in subclasses
     * </p>
     * @return armorBonus as an int
     */
    abstract int getResistBonus();


    /**
     * a to string method that print out a units statistics in an order
     * @return a string of all statistics
     */
    @Override
    public String toString() {
        return "\nThe statistics of unit: \n" +name+
                "\nHealth:\n" + health+
                "\nDamage/DP:\n" + attack+
                "\nArmor/AP \n" + armor;
    }
}
