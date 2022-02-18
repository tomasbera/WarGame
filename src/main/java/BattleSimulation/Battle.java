package BattleSimulation;
import SpecificUnits.Unit;
import java.util.Random;

/**
 * this class represents the simulation of a battle
 * the battle is going to be between two armies from the army class
 * this class consists of different methods and variables
 */
public class Battle {

    Army attackingArmy;
    Army defendingArmy;
    Army armyOne;
    Army armyTwo;

    /**
     * this is a construcrot for the battle class that takes two classes.
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
        boolean winner = false;

        while (armyTwo.hasUnits() && armyTwo.hasUnits()){
            Unit attackingUnit = attackingArmy.getRandom();
            Unit defendingUnit = defendingArmy.getRandom();

            while (!winner){
                attackingUnit.attack(defendingUnit);
                if (defendingUnit.getHealth() == 0){
                    defendingArmy.remove(defendingUnit);
                    winner = true;
                }

                defendingUnit.attack(attackingUnit);
                if (attackingUnit.getHealth() == 0){
                    attackingArmy.remove(attackingUnit);
                    winner = true;
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
     * this method chooses the starting/attacking and defending army
     */
    public void whoStarts(){
        Random random = new Random();
        int upperbound = 11;
        int randomNum = random.nextInt(upperbound);

        if (randomNum<5){
            attackingArmy = armyOne;
            defendingArmy = armyTwo;
        } else {
            attackingArmy = armyTwo;
            defendingArmy = armyOne;
        }
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