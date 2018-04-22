import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkImplCoffeeTest {
    DrinkImplCoffee coffee;

    @Before
    public void setUp() throws Exception {
        coffee = new DrinkImplCoffee();
        Inventory.getInstance().refillIngredient();
    }

    @After
    public void tearDown() throws Exception {
        coffee = null;
    }

    @Test
    public void testGetDrinkCost() {
        double cost = coffee.getDrinkCost();
        assertEquals(2.75, cost, 0.01);
    }

    @Test
    public void testHaveInventory() {
        boolean stocked = coffee.haveInventory();
        assertTrue(stocked);

        coffee.dispenseDrink();
        coffee.dispenseDrink();
        coffee.dispenseDrink();
        stocked = coffee.haveInventory();
        assertFalse(stocked);
    }

    @Test
    public void testDispenseDrink() {
        boolean stocked = true;
        coffee.dispenseDrink();
        coffee.dispenseDrink();
        coffee.dispenseDrink();
        stocked = coffee.haveInventory();

        assertFalse(stocked);
    }

    @Test
    public void testToString() {
        String coffeeString = null;
        coffeeString = coffee.toString();
        assertNotNull(coffeeString);
    }
}