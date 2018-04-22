import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    Ingredient testIngredient;
    int testQuant = 10;
    double testCost = 1.50;

    @Before
    public void setUp() throws Exception {
        testIngredient = new Ingredient("testIngredient", testCost, testQuant);
    }

    @After
    public void tearDown() throws Exception {
        testIngredient = null;
    }

    @Test
    public void testGetName() {
        String name = testIngredient.getName();
        assertEquals("testIngredient", name);
    }

    @Test
    public void testGetCost() {
        double cost = testIngredient.getCost();
        assertEquals(testCost, cost, 0.01);
    }

    @Test (expected = InvalidDataException.class)
    public void testSetQuantityException() throws InvalidDataException {
        testIngredient.setQuantity(11);
        testIngredient.setQuantity(-1);
    }

    @Test
    public void testSetQuantityGood() throws InvalidDataException {
        testIngredient.setQuantity(0);
        int quant = testIngredient.getQuantity();
        assertEquals(0, quant);

        testIngredient.setQuantity(10);
        quant = testIngredient.getQuantity();
        assertEquals(10, quant);
    }

    @Test
    public void testGetQuantity() {
        int quant = testIngredient.getQuantity();
        assertEquals(testQuant, quant);
    }

    @Test (expected = InvalidDataException.class)
    public void testUseQuantityException() throws InvalidDataException {
        testIngredient.useQuantity(11);
        testIngredient.useQuantity(-1);
    }

    @Test
    public void testUseQuantityGood() throws InvalidDataException {
        testIngredient.useQuantity(5);
        assertNotEquals(testQuant, testIngredient.getQuantity());
    }
}