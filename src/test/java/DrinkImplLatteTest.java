import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkImplLatteTest {
    DrinkImplLatte latte;

    @Before
    public void setUp() throws Exception {
        latte = new DrinkImplLatte();
        Inventory.getInstance().refillIngredient();
    }

    @After
    public void tearDown() throws Exception {
        latte = null;
    }

    @Test
    public void testGetDrinkCost() {
        double cost = latte.getDrinkCost();
        assertEquals(2.55, cost, 0.01);
    }

    @Test
    public void testHaveInventory() {
        boolean stocked = latte.haveInventory();
        assertTrue(stocked);

        latte.dispenseDrink();
        latte.dispenseDrink();
        latte.dispenseDrink();
        latte.dispenseDrink();
        latte.dispenseDrink();
        stocked = latte.haveInventory();
        assertFalse(stocked);
    }

    @Test
    public void testDispenseDrink() {
        boolean stocked = true;
        latte.dispenseDrink();
        latte.dispenseDrink();
        latte.dispenseDrink();
        latte.dispenseDrink();
        latte.dispenseDrink();
        stocked = latte.haveInventory();

        assertFalse(stocked);
    }

    @Test
    public void testToString() {
        String latteString = null;
        latteString = latte.toString();
        assertNotNull(latteString);
    }
}