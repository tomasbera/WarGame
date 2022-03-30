package BattleSimulation;

import SpecificUnits.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class armyFiles {

    /**
     * method that takes a unit and converts it to a string of csv type
     * @param u the unit you want to convert
     * @return string of csv type of the specific unit
     */
    public static String makeCSVString(Unit u){
        return u.getClass().getSimpleName() +","+ u.getName()+","+u.getHealth()+","+u.getAttack()+","+u.getArmor()
                +","+u.getMelee()+"\n";
    }

    /**
     * method that creates a file from an army with the armys name
     * @param army the army you want to create a file of
     * @return File with the new army
     * @throws IOException if file not found, or file is wrong throws exception
     */
    public static File makeCSVFile(Army army) throws IOException{
        //makes a new file in the armyFile folder with the army name
        File armyFile = new File("src/main/resources/armyFiles/"+army.getName().trim());

        //checks if file is already in registry
        if(armyFile.exists() && !armyFile.isDirectory()) {
            throw new IllegalArgumentException("This ArmyFile is already in the registry");
        }

        Writer writer = new FileWriter(armyFile.getAbsolutePath());
        writer.write(armyFile.getName()+"\n");

        // puts all units in a army to a specific list
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

    /**
     * method that takes a file and creates an army form its context
     * @param armyName the file you are looking for also the name of the army
     * @return the new Army created from the file
     * @throws IOException any mistakes with the file will throw an exception
     */
    public static Army readFromCSV(String armyName) throws IOException {
        // finds path to wanted file
        Path path = Path.of("src/main/resources/armyFiles/"+armyName);
        if(Path.of("src/main/resources/armyFiles/"+armyName).getFileName() == null) throw new NoSuchFileException("File not found");

        Army newArmy = new Army(armyName);
        ArrayList<Unit> newUnits = new ArrayList<>();
        Files.lines(path)
                .skip(1)
                .forEach(line -> {
                    //checkForCharacters(line);
                    checkForUnit(line, newUnits);
                });
        if (newUnits.size() == 0){
            throw new NullPointerException("This file doesnt contain any units");
        }
       newArmy.addAll(newUnits);
       return newArmy;
    }

    /**
     * method that checks which unitType a line from a file is
     * @param line line from a file
     * @param newUnits arrayList with the new Units created
     */
    public static void checkForUnit(String line, ArrayList<Unit> newUnits){
        String[] column = line.split(",");
        if(column.length < 6) throw new IllegalArgumentException("File is not readable");

        // all 4 different unit types passed to an arraylist of units
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

    /*
    public static void checkForCharacters(String lines) throws IllegalArgumentException{
        String removeCharacters = "[\\d]";
        Pattern pt = Pattern.compile(removeCharacters);
        Matcher mt = pt.matcher(lines);
        boolean result = mt.matches();
        if (result) throw new IllegalArgumentException("Illegal characters found in file");
    }
    */
}
