package BattleSimulation;

import Maintnance.WarGamesGUI;
import SpecificUnits.*;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArmyFiles {

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
        File armyFile = new File("src/main/resources/ArmyFiles/"+army.getName().trim());

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
     * @return the new Army created from the file
     * @throws IOException any mistakes with the file will throw an exception
     */
    public Army readFromCSV(String armyPath) throws IOException {
        UnitFactory unitFactory = new UnitFactory();

        Army newArmy = new Army(Files.readAllLines(Paths.get(armyPath)).get(0));
        ArrayList<Unit> newUnits = new ArrayList<>();
        Files.lines(Path.of(armyPath))
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

    public String getFilePath() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select army from file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv"));
        File file = fileChooser.showOpenDialog(WarGamesGUI.getStage());
        if (file != null)
            return file.getPath();
        return null;
    }
}
