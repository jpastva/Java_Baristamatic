import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkImplCappuccinoTest {
    DrinkImplCappuccino cappuccino;

    @Before
    public void setUp() throws Exception {
        cappuccino = new DrinkImplCappuccino();
        Inventory.getInstance().refillIngredient();
    }

    @After
    public void tearDown() throws Exception {
        cappuccino = null;
    }

    @Test
    public void testGetDrinkCost() {
        double cost = cappuccino.getDrinkCost();
        assertEquals(2.90, cost, 0.01);
    }

    @Test
    public void testHaveInventory() {
        boolean stocked = cappuccino.haveInventory();
        assertTrue(stocked);

        cappuccino.dispenseDrink();
        cappuccino.dispenseDrink();
        cappuccino.dispenseDrink();
        cappuccino.dispenseDrink();
        cappuccino.dispenseDrink();
        stocked = cappuccino.haveInventory();
        assertFalse(stocked);
    }

    @Test
    public void testDispenseDrink() {
        boolean stocked = true;
        cappuccino.dispenseDrink();
        cappuccino.dispenseDrink();
        cappuccino.dispenseDrink();
        cappuccino.dispenseDrink();
        cappuccino.dispenseDrink();
        stocked = cappuccino.haveInventory();

        assertFalse(stocked);
    }

    @Test
    public void testToString() {
        String cappuccinoString = null;
        cappuccinoString = cappuccino.toString();
        assertNotNull(cappuccinoString);
    }
}