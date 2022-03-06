import SpecificUnits.*;
import BattleSimulation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static javax.swing.JOptionPane.*;

/**
 * this is the client for my warGame
 */
public class GameHub {

    public static List<Unit> unitList = new ArrayList<>();
    public static List<Army> armyList = new ArrayList<>();

    /**
     * the main method that starts the game
     * @param args
     */
    public static void main(String[] args) {
            start();
        }

    public static boolean finished = true;

    /**
     * the start f the game, where you can choose what you want to do in the game
     */
    public static void start() {
        List<Army> armyList = new ArrayList<>();
            while(finished){
                try {
                    String[] menuInput =
                            {
                                    "Register new Unit",
                                    "Register new Army",
                                    "Add all units",
                                    "Multiply unit count",
                                    "Remove all units registered",
                                    "Run simulation",
                                    "See all Units",
                                    "End Game",
                            };
                    final int REGISTER_NEW = 0;
                    final int REGISTER_ARMY = 1;
                    final int ADD_ALL = 2;
                    final int MULTIPY_UNIT = 3;
                    final int REMOVE_ALL = 4;
                    final int RUN_SIMULATION = 5;
                    final int SHOW_ALL_UNITS = 6;
                    final int EXIT = 7;

                    int menuSelection = showOptionDialog(null, "****WarGames****" + "\n Choose function",
                            "Project Idatt2001", YES_NO_OPTION, INFORMATION_MESSAGE, null, menuInput, menuInput[0]);

                    switch (menuSelection) {
                        case REGISTER_NEW -> {
                            REGISTERNEW();
                        }
                        case REGISTER_ARMY -> {
                            REGISTERARMY();
                        }
                        case ADD_ALL -> {
                            ADDALL();
                        }
                        case MULTIPY_UNIT -> {
                            MULTIPYUNIT();
                        }
                        case REMOVE_ALL -> {
                            REMOVEALL();
                        }
                        case RUN_SIMULATION -> {
                            RUNSIMULATION();
                        }
                        case SHOW_ALL_UNITS -> {
                            SHOWALLUNITS();
                        }

                        case EXIT -> {
                            System.out.println("""
                                    Thanks of using this Game
                                    Bye
                                    """);
                            finished = false;
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    /**
     * method where you register new units
     */
    private static void REGISTERNEW() {
            String typeRead = showInputDialog("what type of unit is it\n" +
                    "1. Infantry" +
                    "\n2. Range" +
                    "\n3. Cavalry" +
                    "\n4. Commander");
            int type = Integer.parseInt(typeRead);
            String newName = showInputDialog("What is the name of the unit");
            String newDamageRead = showInputDialog("How much damage does it deal");
            int newDamage = Integer.parseInt(newDamageRead);
            String newArmorRead = showInputDialog("How much Armor does it have");
            int newArmor = Integer.parseInt(newArmorRead);
            String newHealthRead = showInputDialog("How much health does it have");
            int newHealth = Integer.parseInt(newHealthRead);
            String newMeleeRead = showInputDialog("How much melee damage does it deal");
            int newMelee = Integer.parseInt(newMeleeRead);

            if (type == 1){
                unitList.add(new InfantryUnit(newName, newHealth, newDamage, newArmor, newMelee));
            }
            else if(type == 2){
                unitList.add(new RangedUnit(newName, newHealth, newDamage, newArmor, newMelee));
            }
            else if(type == 3){
                unitList.add(new CavalryUnit(newName, newHealth, newDamage, newArmor, newMelee));
            }
            else if(type == 4){
                unitList.add(new CommanderUnit(newName, newHealth, newDamage, newArmor, newMelee));
            }

        }

        /**
         * method for registering new army
         */
        private static void REGISTERARMY() {
            String newName = showInputDialog("Write the name of the army");
            Army army = new Army(newName);
            armyList.add(army);
        }

        /**
         * method for adding all units to an army
         */
        private static void ADDALL() {
            String armyName = showInputDialog("what is the name of the army you want to add all these units to");
                for (Army a:armyList) {
                    if(Objects.equals(a.getName(), armyName)){
                        a.addAll(unitList);
                    }
                }
            }

        /**
         * method for multiplying a specific unit based on type
         */
        private static void MULTIPYUNIT() {
            String typeRead = showInputDialog("what type of unit is it\n" +
                    "1. Infantry" +
                    "\n2. Range" +
                    "\n3. Cavalry" +
                    "\n4. Commander");
            int type = Integer.parseInt(typeRead);

            String nameMultiple = showInputDialog("What is the name of unit you want to multiple");
            String howManyTimes = showInputDialog("How many do you want");
            int multipleNum = Integer.parseInt(howManyTimes);

            if (type == 1) {
                for (Unit inf : unitList) {
                    if (Objects.equals(inf.getName(), nameMultiple)) {
                        for (int i = 0; i <= multipleNum; i++) {
                            unitList.add(new InfantryUnit(inf.getName(), inf.getHealth(), inf.getAttack(), inf.getArmor(), inf.getMelee()));
                        }
                    }
                }
            }

            else if (type == 2){
                for (Unit rng: unitList) {
                    if (Objects.equals(rng.getName(), nameMultiple)){
                        for (int i = 0; i < multipleNum; i++) {
                            unitList.add(new RangedUnit(rng.getName(), rng.getHealth(), rng.getAttack(), rng.getArmor(), rng.getMelee()));
                        }
                    }
                }
            }

            else if (type == 3){
                for (Unit cav : unitList){
                    if (Objects.equals(cav.getName(), nameMultiple)){
                        for (int i = 0; i <= multipleNum; i++) {
                            unitList.add(new CavalryUnit(cav.getName(), cav.getHealth(), cav.getAttack(), cav.getArmor(), cav.getMelee()));
                        }
                    }
                }
            }

            else if (type == 4){
                for (Unit com : unitList){
                    if (Objects.equals(com.getName(), nameMultiple)){
                        for (int i = 0; i <= multipleNum; i++) {
                            unitList.add(new CommanderUnit(com.getName(), com.getHealth(), com.getAttack(), com.getArmor(), com.getMelee()));
                        }
                    }
                }
            }
        }

        /**
         * remove all units in the list, so you can make a new army
         */
        private static void REMOVEALL() {
            unitList.clear();
            }

        /**
         * mathod that runs the simulation of the battle
         */
        private static void RUNSIMULATION() {
                Battle battle = new Battle(armyList.get(0), armyList.get(1));
                System.out.println(battle.simulate());
            }


        /**
         * shows all units registered
         */
        private static void SHOWALLUNITS() {
                System.out.println(unitList);
            }
        }
