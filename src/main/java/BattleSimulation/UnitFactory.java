package BattleSimulation;

import SpecificUnits.*;

import java.util.Objects;

public class UnitFactory {
    Unit newUnit = null;

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
}
