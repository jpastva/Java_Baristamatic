import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkImplMochaTest {
    DrinkImplMocha mocha;

    @Before
    public void setUp() throws Exception {
        mocha = new DrinkImplMocha();
        Inventory.getInstance().refillIngredient();
    }

    @After
    public void tearDown() throws Exception {
        mocha = null;
    }

    @Test
    public void testGetDrinkCost() {
        double cost = mocha.getDrinkCost();
        assertEquals(3.35, cost, 0.01);
    }

    @Test
    public void testHaveInventory() {
        boolean stocked = mocha.haveInventory();
        assertTrue(stocked);

        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        stocked = mocha.haveInventory();
        assertFalse(stocked);
    }

    @Test
    public void testDispenseDrink() {
        boolean stocked = true;
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        mocha.dispenseDrink();
        stocked = mocha.haveInventory();

        assertFalse(stocked);
    }

    @Test
    public void testToString() {
        String mochaString = null;
        mochaString = mocha.toString();
        assertNotNull(mochaString);
    }
}