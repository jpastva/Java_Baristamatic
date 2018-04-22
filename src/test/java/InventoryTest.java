import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.*;

public class InventoryTest {
    String filename = "Ingredients.txt";

    @Test
    public void testLoadIngredients() {
        TreeMap<String, Ingredient> ingredients = new TreeMap<>();
        ingredients = Inventory.getInstance().loadIngredients(filename);
        assertNotNull(ingredients);
    }

    @Test
    public void testGetInstance() {
        Inventory instance = null;
        instance = Inventory.getInstance();

        assertNotNull(instance);
    }

    @Test
    public void testUseIngredient() {
        int useAmt = 2;
        int ingrAmt1 = Inventory.getInstance().ingredientsList.get("Coffee").getQuantity();
        try {
            Inventory.getInstance().useIngredient("Coffee", useAmt);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
        int ingrAmt2 = Inventory.getInstance().ingredientsList.get("Coffee").getQuantity();
        assertEquals(ingrAmt1 - ingrAmt2, useAmt);
    }

    @Test (expected = InvalidDataException.class)
    public void testUseIngredientException() throws InvalidDataException {
        Inventory.getInstance().useIngredient("Coffee", 11);
    }

    @Test
    public void testRefillIngredient() {
        int ingrAmt1 = Inventory.getInstance().ingredientsList.get("Coffee").getQuantity();
        try {
            Inventory.getInstance().useIngredient("Coffee", 4);
        } catch (InvalidDataException e) {
            e.getMessage();
        }
        Inventory.getInstance().refillIngredient();
        int ingrAmt2 = Inventory.getInstance().ingredientsList.get("Coffee").getQuantity();

        assertEquals(ingrAmt1, ingrAmt2);
    }

    @Test
    public void testToString() {
        String stringOut = Inventory.getInstance().toString();
        assertNotNull(stringOut);
    }

}