package BattleSimulation;

import SpecificUnits.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class armyFiles {

    public static String makeCSVString(Unit u){
        return u.getClass().getSimpleName() +","+ u.getName()+","+u.getHealth()+","+u.getAttack()+","+u.getArmor()
                +","+u.getMelee()+"\n";
    }

    public static File makeCSVFile(Army army) throws IOException {
        //makes a new file in the armyFile folder with the army name
        File armyFile = new File("src/main/resources/armyFiles/"+army.getName().trim());

        if(armyFile.exists() && !armyFile.isDirectory()) {
            throw new IllegalArgumentException("This ArmyFile is already in the registry");
        }

        Writer writer = new FileWriter(armyFile.getAbsolutePath());
        writer.write(armyFile.getName()+"\n");

        army.getUnits()
                .forEach(unit -> {
                    try {
                        writer.write(makeCSVString(unit));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        writer.close();
        return armyFile;
    }

    public static Army readFromCSV(String armyName) throws IOException {
        Path path = Path.of("src/main/resources/armyFiles/"+armyName);
        Army newArmy = new Army(armyName);
        ArrayList<Unit> newUnits = new ArrayList<>();
        Files.lines(path)
                .skip(1)
                .forEach(line -> {
                    checkForUnit(line, newUnits);
                });
        if (newUnits.size() == 0){
            throw new NullPointerException("This file doesnt contain any units");
        }

       newArmy.addAll(newUnits);
       return newArmy;
    }

    public static void checkForUnit(String line, ArrayList<Unit> newUnits){
        String[] column = line.split(",");
        String unitType = column[0];
        if(Objects.equals(unitType, "InfantryUnit")){
            newUnits.add(new InfantryUnit(column[1], Integer.parseInt(column[2]), Integer.parseInt(column[2])
                    ,Integer.parseInt(column[3]),Integer.parseInt(column[4])));
        } else if(Objects.equals(unitType, "RangedUnit")){
            newUnits.add(new RangedUnit(column[1], Integer.parseInt(column[2]), Integer.parseInt(column[2])
                    ,Integer.parseInt(column[3]),Integer.parseInt(column[4])));
        } else if(Objects.equals(unitType, "CavalryUnit")){
            newUnits.add(new CavalryUnit(column[1], Integer.parseInt(column[2]), Integer.parseInt(column[2])
                    ,Integer.parseInt(column[3]),Integer.parseInt(column[4])));
        }else if(Objects.equals(unitType, "CommanderUnit")){
            newUnits.add(new CommanderUnit(column[1], Integer.parseInt(column[2]), Integer.parseInt(column[2])
                    ,Integer.parseInt(column[3]),Integer.parseInt(column[4])));
        }
    }
}
