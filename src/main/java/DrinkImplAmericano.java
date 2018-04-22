/**
 * CIS-365 Assignment 2
 * Americano implements Drink interface, stores drink name and recipe,
 * dispenses drink, returns drink cost, checks if in stock.
 *
 * @author Joelen Pastva
 */

import java.text.DecimalFormat;

public class DrinkImplAmericano implements Drink {
    String name = "Caffe Americano";
    String ingredient1 = "Espresso";
    int ingr1Amt = 3;

    public DrinkImplAmericano() {
    }

    @Override
    public double getDrinkCost() {
        double ingrCost = Inventory.getInstance().ingredientsList.get(ingredient1).getCost() * ingr1Amt;
        double drinkCost = ingrCost;

        return drinkCost;
    }

    @Override
    public boolean haveInventory() {
        boolean stocked = true;
        int stock1 = Inventory.getInstance().ingredientsList.get(ingredient1).getQuantity();

        if (stock1 < ingr1Amt)
            stocked = false;

        return stocked;
    }

    @Override
    public void dispenseDrink() {
        try {
            Inventory.getInstance().useIngredient(ingredient1, ingr1Amt);
        } catch (InvalidDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder drink = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.00");
        drink.append(name + ", $");
        drink.append(df.format(getDrinkCost()));
        drink.append(", " + haveInventory());

        return drink.toString();
    }

}
