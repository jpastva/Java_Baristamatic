import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class InventoryTest {
    String filename = "Ingredients.txt";

    @Test
    public void testLoadIngredients() {
        HashMap<String, Ingredient> ingredients = new HashMap<String, Ingredient>();
        ingredients = Inventory.loadIngredients(filename);
        assertNotNull(ingredients);
    }

}