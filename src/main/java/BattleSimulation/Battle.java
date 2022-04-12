package BattleSimulation;
import SpecificUnits.Unit;
import java.util.Random;

/**
 * this class represents the simulation of a battle
 * the battle is going to be between two armies from the army class
 * this class consists of different methods and variables
 */
public class Battle {

    private Army attackingArmy;
    private Army defendingArmy;
    private Army armyOne;
    private Army armyTwo;
    private Terrain terrain;

    /**
     * this is a constructor for the battle class that takes two classes.
     * @param armyOne
     * @param armyTwo
     */
    public Battle(Army armyOne, Army armyTwo) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

    /**
     * this method is the simulation of the battle, two armies attack each other, and one wins
     * @return return the winning army as an Army object
     */
    public Army simulate(){
        Army winningArmy;

        Random random = new Random();
        boolean randomBool = random.nextBoolean();

        if (randomBool){
            attackingArmy = armyOne;
            defendingArmy = armyTwo;
        } else {
            attackingArmy = armyTwo;
            defendingArmy = armyOne;
        }

        boolean winner;
        while (armyOne.hasUnits() && armyTwo.hasUnits()){

            Unit attackingUnit = attackingArmy.getRandom();
            Unit defendingUnit = defendingArmy.getRandom();

            winner = false;
            while (!winner){
                attackingUnit.attack(defendingUnit, terrain.getTerrainNum());
                if (defendingUnit.getHealth() <= 0){
                    defendingArmy.remove(defendingUnit);
                    winner = true;
                }
                else {
                    defendingUnit.attack(attackingUnit, terrain.getTerrainNum());
                    if (attackingUnit.getHealth() <= 0){
                        attackingArmy.remove(attackingUnit);
                        winner = true;
                    }
                }
            }
        }
        if(armyOne.hasUnits()){
            winningArmy = armyOne;
        } else {
            winningArmy = armyTwo;
        }
        return winningArmy;
    }

    /**
     * the toString method that print out both armies
     * @return both armies units
     */
    @Override
    public String toString() {
        return armyOne.getName() +"\n"+ armyOne.getAllUnits() +
                "\n\n" + armyTwo.getName() +"\n"+ armyTwo.getAllUnits();
    }
}