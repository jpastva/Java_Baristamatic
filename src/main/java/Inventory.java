import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Inventory {

    private volatile static Inventory instance;
    private final int REFILL_INV = 10;
    public HashMap<String, Ingredient> ingredientsList = null;

    private Inventory() {
        ingredientsList = loadIngredients("Ingredients.txt");
    }

    public static Inventory getInstance() {
        if (instance == null) {
            synchronized (Inventory.class) {
                if (instance == null) {
                    instance = new Inventory();
                }
            }
        }
        return instance;
    }

    public HashMap<String, Ingredient> loadIngredients(String filename) {
        HashMap<String, Ingredient> ingredientData = new HashMap<String, Ingredient>();
        Ingredient ingr = null;

        try {
            Scanner input = new Scanner(new File("Ingredients.txt"));

            while (input.hasNext()) {
                String line = input.nextLine();
                String[] values = line.split(";");
                String item = values[0];
                double price = Double.parseDouble(values[1]);

                try {
                    ingr = new Ingredient(item, price, REFILL_INV);
                } catch (InvalidDataException i) {
                    System.out.println(i.getMessage());
                }
                if (ingr != null)
                    ingredientData.put(item, ingr);
            }

            input.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
        return ingredientData;
    }

    public void useIngredient(String ingredient, int amt) throws InvalidDataException {
        ingredientsList.get(ingredient).useQuantity(amt);
    }


}
