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
        return u.getClass().getSimpleName() +","+ u.getName()+","+u.getHealth()+"\n";
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

        // puts all units in an army to a specific list
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
        UnitFactory unitFactory = new UnitFactory();
        // finds path to wanted file
        Path path = Path.of("src/main/resources/armyFiles/"+armyName);
        if(Path.of("src/main/resources/armyFiles/"+armyName).getFileName() == null) throw new NoSuchFileException("File not found");

        Army newArmy = new Army(armyName);
        ArrayList<Unit> newUnits = new ArrayList<>();
        Files.lines(path)
                .skip(1)
                .forEach(line -> {
                    String[] column = line.split(",");
                    if(column.length !=3 ) throw new IllegalArgumentException("File is not readable");
                    newUnits.add(unitFactory.newUnitFactory(column[0],column[1],Integer.parseInt(column[2])));
                });
        if (newUnits.size() == 0){
            throw new NullPointerException("This file doesnt contain any units");
        }
       newArmy.addAll(newUnits);
       return newArmy;
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
