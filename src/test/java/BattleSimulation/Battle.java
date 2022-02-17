package BattleSimulation;

public class Battle {

    Army armyOne;
    Army armyTwo;

    public Battle(Army armyOne, Army armyTwo) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

    public Army simulate(){
        return null;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "armyOne=" + armyOne +
                "\n\narmyTwo=" + armyTwo +
                '}';
    }
}
