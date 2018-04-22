import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkImplDecafTest {
    DrinkImplDecaf decaf;

    @Before
    public void setUp() throws Exception {
        decaf = new DrinkImplDecaf();
        Inventory.getInstance().refillIngredient();
    }

    @After
    public void tearDown() throws Exception {
        decaf = null;
    }

    @Test
    public void testGetDrinkCost() {
        double cost = decaf.getDrinkCost();
        assertEquals(2.75, cost, 0.01);
    }

    @Test
    public void testHaveInventory() {
        boolean stocked = decaf.haveInventory();
        assertTrue(stocked);

        decaf.dispenseDrink();
        decaf.dispenseDrink();
        decaf.dispenseDrink();
        stocked = decaf.haveInventory();
        assertFalse(stocked);
    }

    @Test
    public void testDispenseDrink() {
        boolean stocked = true;
        decaf.dispenseDrink();
        decaf.dispenseDrink();
        decaf.dispenseDrink();
        stocked = decaf.haveInventory();

        assertFalse(stocked);
    }

    @Test
    public void testToString() {
        String decafString = null;
        decafString = decaf.toString();
        assertNotNull(decafString);
    }
}