package BattleSimulation;
import SpecificUnits.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Army {

    private List<Unit> units;
    private String name;

    public Army(List<Unit> units, String name) {
        units = new ArrayList<Unit>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Unit unit){
        units.add(unit);
    }

    public void addAll(List<Unit> newUnits){
        units.addAll(newUnits);
    }

    public void remove(Unit unit){
        units.remove(unit);
    }

    public boolean hasUnits(){
        if(units.size()==0){
            return true;
        }
        return false;
    }

    public List<Unit> getAllUnits(){
        return units;
    }

    public Unit getRandom(){
        java.util.Random helRandom = new java.util.Random();
        int randomNum = helRandom.nextInt();
        return units.get(randomNum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Army)) return false;

        Army army = (Army) o;

        if (!Objects.equals(units, army.units)) return false;
        return getName() != null ? getName().equals(army.getName()) : army.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = units != null ? units.hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Army{" +
                "units=" + units +
                ", name='" + name + '\'' +
                '}';
    }
}
