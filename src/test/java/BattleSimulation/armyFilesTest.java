package BattleSimulation;

import SpecificUnits.InfantryUnit;
import SpecificUnits.RangedUnit;
import SpecificUnits.Unit;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class armyFilesTest {

    @Test
    public void Test_if_createCSVString_creates_string_of_a_Unit(){
        Unit InfantryTest = new InfantryUnit("Footman", 10);
        assertEquals("InfantryUnit,Footman,10,15,10,2"+"\n", armyFiles.makeCSVString(InfantryTest));
    }

    @Nested
    public class Test_makeCVSFile_method_and_exceptions {

        @Test
        public void Test_if_makeCSVFile_makes_a_file_in_armyFile_in_CSV_format() throws IOException {
            Unit InfantryTest = new InfantryUnit("Footman", 10);
            Unit RangeTest = new RangedUnit("Bowman", 10);
            Army armyTest = new Army("Human Army");
            armyTest.add(InfantryTest);
            armyTest.add(RangeTest);

            File file = armyFiles.makeCSVFile(armyTest);
            assertNotNull(file);
            file.delete();
        }

        @Test
        public void Test_if_makeCVSFile_throws_IllegalArgumentException(){
            Army armyFileExisting = new Army("ExsistingFiletest");
            assertThrows(IllegalArgumentException.class, () -> {
                armyFiles.makeCSVFile(armyFileExisting);
            });
        }
    }

    @Nested
    public class Test_readFromCVS_method_and_exceptions{

        @Test
        public void Test_if_readFromCSV_creates_a_army_of_a_wanted_file() throws IOException {
            Army armyFileTest = armyFiles.readFromCSV("HumanArmyTest");
            assertEquals(2, armyFileTest.getUnits().size());
        }

        @Test
        public void Test_if_readFromCSV_throws_IO_exception(){
            assertThrows(IOException.class, () -> {
                armyFiles.readFromCSV("");
            });
        }

        @Test
        public void Test_if_readFromCSV_throws_NullPointerException(){
            assertThrows(NullPointerException.class, () -> {
                armyFiles.readFromCSV("NullArmyTest");
            });
        }

    }

}