package BattleSimulation;

import SpecificUnits.InfantryUnit;
import SpecificUnits.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UnitFactoryTest {


    @Nested
    public class Tests_for_newUnitFactory_method {

        @Test
        public void Test_if_method_creates_a_unit() {
            Unit unit;
            UnitFactory uf = new UnitFactory();
            unit = uf.newUnitFactory("InfantryUnit", "name", 1);
            assertNotNull(unit);
        }

        @Test
        public void Test_if_method_throws_exception_when_Type_not_found() {
            UnitFactory uf = new UnitFactory();
            assertThrows(NullPointerException.class, () -> {
                uf.newUnitFactory("blabla", "name", 1);
            });
        }
    }

    @Nested
    public class  Tests_for_newNumberOfUnits_method {

        @Test
        public void Test_if_method_creates_n_number_of_a_unit(){
            UnitFactory uf = new UnitFactory();
            ArrayList<Unit> listTest = uf.newNumberOfUnits("InfantryUnit", "name", 1, 10);
            assertEquals(10, listTest.size());
        }
    }
}