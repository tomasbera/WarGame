package BattleSimulation;
import SpecificUnits.Unit;
import java.util.Random;

public class Battle {

    Army attackingArmy;
    Army defendingArmy;
    Army armyOne;
    Army armyTwo;

    public Battle(Army armyOne, Army armyTwo) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

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

    @Override
    public String toString() {
        return "Battle{" +
                "armyOne=" + armyOne +
                "\n\narmyTwo=" + armyTwo +
                '}';
    }
}