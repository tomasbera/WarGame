package BattleSimulation;

import SpecificUnits.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This is a Unit Factory class that creates different types of a unit
 * @Tomas Beranek
 */
public class UnitFactory {
    Unit newUnit = null;

    /**
     * this method is used for creating a specific type of unit with different variables
     * @param type type of unit
     * @param name unit name
     * @param health unit health
     * @return a new unit
     */
    public Unit newUnitFactory(String type, String name, int health){
        if (Objects.equals(type, "InfantryUnit")){
            newUnit = new InfantryUnit(name, health);
        } else if(Objects.equals(type, "RangedUnit")){
            newUnit = new RangedUnit(name, health);
        } else if(Objects.equals(type, "CavalryUnit")){
            newUnit = new CavalryUnit(name, health);
        } else if(Objects.equals(type, "CommanderUnit")){
            newUnit = new CommanderUnit(name, health);
        } else {
            throw new NullPointerException("No unit such type");
        }
        return newUnit;
    }

    /**
     * this method is used for creating a specific unit n number of times
     * @param type unit type
     * @param name unit name
     * @param health unit health
     * @param numOfUnits number of that new unit
     * @return arraylist with all units
     */
    //this method will be added when a GUI is implemented
    public ArrayList<Unit> newNumberOfUnits(String type, String name, int health, int numOfUnits){
        ArrayList<Unit> newUnits = new ArrayList<>();
        for (int i = 0; i < numOfUnits; i++) {
            newUnits.add(newUnitFactory(type, name, health));
        }
        return newUnits;
    }
}
