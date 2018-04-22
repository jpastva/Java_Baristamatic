import org.junit.Test;

import static org.junit.Assert.*;

public class MachineTest {

    @Test
    public void testTakeInputGood() {
        final int BASE_QUANT = 10;

        Machine.takeInput('1');
        Machine.takeInput('5');
        int quant1 = Inventory.getInstance().ingredientsList.get("Espresso").getQuantity();
        int quant2 = Inventory.getInstance().ingredientsList.get("Coffee").getQuantity();

        assertNotEquals(quant1, BASE_QUANT);
        assertNotEquals(quant2, BASE_QUANT);

        Machine.takeInput('r');
        Machine.takeInput('7');
        quant1 = Inventory.getInstance().ingredientsList.get("Espresso").getQuantity();

        assertEquals(quant1, BASE_QUANT);
    }

    @Test
    public void testDispenseDrink() {
        final int BASE_QUANT = 10;

        Machine.dispenseDrink(1);
        int quant1 = Inventory.getInstance().ingredientsList.get("Espresso").getQuantity();
        Machine.dispenseDrink(1);
        int quant2 = Inventory.getInstance().ingredientsList.get("Espresso").getQuantity();
        Machine.dispenseDrink(0);
        int quant3 = Inventory.getInstance().ingredientsList.get("Espresso").getQuantity();

        assertNotEquals(quant1, quant2);
        assertEquals(quant2, quant3);
    }
}