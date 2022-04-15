package BattleSimulation;

import SpecificUnits.InfantryUnit;
import SpecificUnits.RangedUnit;
import SpecificUnits.Unit;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import static org.junit.jupiter.api.Assertions.*;

public class armyFilesTest {

    @Test
    public void Test_if_createCSVString_creates_string_of_a_Unit(){
        Unit InfantryTest = new InfantryUnit("Footman", 10);
        assertEquals("InfantryUnit,Footman,10"+"\n", ArmyFiles.makeCSVString(InfantryTest));
    }

    //TODO: check for corrupt files

    @Nested
    public class Test_makeCVSFile_method_and_exceptions {

        @Test
        public void Test_if_makeCSVFile_makes_a_file_in_armyFile_in_CSV_format() throws IOException {
            Unit InfantryTest = new InfantryUnit("Footman", 10);
            Unit RangeTest = new RangedUnit("Bowman", 10);
            Army armyTest = new Army("Human Army");
            armyTest.add(InfantryTest);
            armyTest.add(RangeTest);

            File file = ArmyFiles.makeCSVFile(armyTest);
            assertNotNull(file);
            file.delete();
        }

        @Test
        public void Test_if_makeCVSFile_throws_IllegalArgumentException_when_a_file_already_exists(){
            Army armyFileExisting = new Army("ExsistingFiletest");
            assertThrows(IllegalArgumentException.class, () -> {
                ArmyFiles.makeCSVFile(armyFileExisting);
            });
        }
    }

    @Nested
    public class Test_readFromCVS_method_and_exceptions{

        @Test
        public void Test_if_readFromCSV_creates_a_army_of_a_wanted_file() throws IOException {
            ArmyFiles armyFiles = new ArmyFiles();
            Army armyFileTest = armyFiles.readFromCSV("src/main/resources/armyFiles/HumanArmyTest");
            assertEquals(2, armyFileTest.getUnits().size());
        }

        @Test
        public void Test_if_readFromCSV_throws_IO_exception(){
            ArmyFiles armyFiles = new ArmyFiles();
            assertThrows(IOException.class, () -> {
                armyFiles.readFromCSV("");
            });
        }

        @Test
        public void Test_if_readFromCSV_throws_NullPointerException_when_file_has_no_units(){
            ArmyFiles armyFiles = new ArmyFiles();
            assertThrows(NullPointerException.class, () -> {
                armyFiles.readFromCSV("src/main/resources/armyFiles/NullArmyTest");
            });
        }

        @Test
        public void Test_if_readFromCSV_throws_IllegalArgumentException_when_file_not_readable(){
            ArmyFiles armyFiles = new ArmyFiles();
            assertThrows(IllegalArgumentException.class, () -> {
                armyFiles.readFromCSV("src/main/resources/armyFiles/NotReadableFile");
            });
        }

        @Test
        public void Test_if_readFromCSV_throws_NoSuchFileException_when_a_file_doenst_exits(){
            ArmyFiles armyFiles = new ArmyFiles();
            assertThrows(NoSuchFileException.class, () -> {
                armyFiles.readFromCSV("NoFileExist");
            });
        }

        /*
        @Test
        public void Test_if_file_is_corrupt_or_has_illegal_characters_throw_IllegalArgumentException(){
            assertThrows(IllegalArgumentException.class, () -> {
                ArmyFiles.readFromCSV("IllegalCharacters");
            });
        }
         */
    }
}
