import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkImplAmericanoTest {

    DrinkImplAmericano americano;

    @Before
    public void setUp() throws Exception {
        americano = new DrinkImplAmericano();
        Inventory.getInstance().refillIngredient();
    }

    @After
    public void tearDown() throws Exception {
        americano = null;
    }

    @Test
    public void testGetDrinkCost() {
        double cost = americano.getDrinkCost();
        assertEquals(3.30, cost, 0.01);
    }

    @Test
    public void testHaveInventory() {
        boolean stocked = americano.haveInventory();
        assertTrue(stocked);

        americano.dispenseDrink();
        americano.dispenseDrink();
        americano.dispenseDrink();
        stocked = americano.haveInventory();
        assertFalse(stocked);
    }

    @Test
    public void testDispenseDrink() {
        boolean stocked = true;
        americano.dispenseDrink();
        americano.dispenseDrink();
        americano.dispenseDrink();
        stocked = americano.haveInventory();

        assertFalse(stocked);
    }

    @Test
    public void testToString() {
        String americanoString = null;
        americanoString = americano.toString();
        assertNotNull(americanoString);
    }
}