import SpecificUnits.*;
import BattleSimulation.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.*;
public class GameHub {

    public static List<Unit> unitList = new ArrayList<>();
    public static List<Army> armyList = new ArrayList<>();

    public static void main(String[] args) {
            start();
        }

    public static boolean finished = true;

    public static void start() {
        List<Army> armyList = new ArrayList<>();
            while(finished){
                try {
                    String[] menuInput =
                            {
                                    "Register new Unit",
                                    "Register new Army",
                                    "Add all units",
                                    "Run simulation",
                                    "See all Units of a Army",
                                    "End Game",
                            };
                    final int REGISTER_NEW = 0;
                    final int REGISTER_ARMY = 1;
                    final int ADD_ALL = 2;
                    final int RUN_SIMULATION = 3;
                    final int SHOW_ALL_UNITS = 4;
                    final int EXIT = 5;

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

            }

        }


        private static void REGISTERARMY() {
            String newName = showInputDialog("Write the name of the army");
            Army army = new Army(newName);
            armyList.add(army);
        }

        private static void ADDALL() {
        }


        private static void RUNSIMULATION() {
            Battle battle = new Battle(army1, army2);
            System.out.println(battle.simulate());
        }


        private static void SHOWALLUNITS() {
        }
    }
