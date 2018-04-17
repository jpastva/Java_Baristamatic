import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class Inventory {

    private volatile static Inventory instance;
    private final int REFILL_INV = 10;
    public TreeMap<String, Ingredient> ingredientsList = null;

    private Inventory()
    {
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

    public TreeMap<String, Ingredient> loadIngredients(String filename) {
        TreeMap<String, Ingredient> ingredientData = new TreeMap<String, Ingredient>();
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

    public void refillIngredient() {
        try {
            for (Ingredient i : ingredientsList.values()) {
                i.setQuantity(REFILL_INV);
            }
        } catch (InvalidDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String toString() {
        StringBuilder inventory = new StringBuilder();
        inventory.append("Inventory:\n");
        for (Ingredient i : ingredientsList.values()) {
            inventory.append(i.getName() + ", " + i.getQuantity() + "\n");
        }
        return inventory.toString();
    }
}