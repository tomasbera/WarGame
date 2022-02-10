public abstract class Unit {
    private String name;
    private int health;
    private int attack;
    private int armor;

    public Unit(String name, int health, int attack, int armor) throws Exception {
        this.name = name;

        if(health < 0){
            throw new Exception("Health of a unit cant be less then zero");
        }
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    public void attack(Unit opponent){
        int newHealth = opponent.health - (this.attack + this.getAttackBonus()) + (opponent.armor + opponent.getResistBonus());
        opponent.setHealth(newHealth);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    abstract int getAttackBonus();

    abstract int getResistBonus();


    @Override
    public String toString() {
        return "\nThe statistics of unit: \n" +name+
                "\nHealth:\n" + health+
                "\nDamage/DP:\n" + attack+
                "\nArmor/AP \n" + armor;
    }
}
