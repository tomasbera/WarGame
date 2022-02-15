package BattleSimulation;
import SpecificUnits.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class representing a full army, with different methods for handling the mechanics of an army
 */
public class Army {

    private List<Unit> units;
    private String name;

    /**
     * A constructor with a list, and the name of that list
     * @param units list of an army
     * @param name same of the army
     */
    public Army(List<Unit> units, String name) {
        units = new ArrayList<Unit>();
        this.name = name;
    }

    /**
     * the get method for the name of the army
     * @return String with the name of the army
     */
    public String getName() {
        return name;
    }

    /**
     * method for adding a unit to the army
     * @param unit chosen unit to add to army
     */
    public void add(Unit unit){
        units.add(unit);
    }

    /**
     * method for adding multiple units at one
     * @param newUnits the list of the new units
     */
    public void addAll(List<Unit> newUnits){
        units.addAll(newUnits);
    }

    /**
     * method for removing a specific unit in the army
     * @param unit the unit to remove
     */
    public void remove(Unit unit){
        units.remove(unit);
    }

    /**
     * method that return true if a list is empty or not
     * @return true if the list is empty, false if it has units
     */
    public boolean hasUnits(){
        if(units.size()==0){
            return true;
        }
        return false;
    }

    /**
     * method for getting all units
     * @return a list of the unit
     */
    public List<Unit> getAllUnits(){
        return units;
    }

    /**
     * method for getting a random unit for a list
     * @return a random unit
     */
    public Unit getRandom(){
        java.util.Random random = new java.util.Random();
        int randomNum = random.nextInt();
        return units.get(randomNum);
    }

    /**
     * if a object is the same as a different unit
     * @param o object to check
     * @return true if the units are equal, false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Army)) return false;

        Army army = (Army) o;

        if (!Objects.equals(units, army.units)) return false;
        return getName() != null ? getName().equals(army.getName()) : army.getName() == null;
    }

    /**
     * method that makes a hashcode for an object
     * @return int as a hashcode for the different objects
     */
    @Override
    public int hashCode() {
        int result = units != null ? units.hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    /**
     * a toString method for printing a units list
     * @return a string of units
     */
    @Override
    public String toString() {
        return "Army{" +
                "units=" + units +
                ", name='" + name + '\'' +
                '}';
    }
}
