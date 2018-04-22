/**
 * CIS-365 Assignment 2
 * Latte implements Drink interface, stores drink name and recipe,
 * dispenses drink, returns drink cost, checks if in stock.
 *
 * @author Joelen Pastva
 */

import java.text.DecimalFormat;

public class DrinkImplLatte implements Drink {
    String name = "Caffe Latte";
    String ingredient1 = "Espresso";
    private int ingr1Amt = 2;
    String ingredient2 = "Steamed Milk";
    private int ingr2Amt = 1;

    public DrinkImplLatte() {

    }

    @Override
    public double getDrinkCost() {
        double ingr1Cost = Inventory.getInstance().ingredientsList.get(ingredient1).getCost() * ingr1Amt;
        double ingr2Cost = Inventory.getInstance().ingredientsList.get(ingredient2).getCost() * ingr2Amt;
        double drinkCost = ingr1Cost + ingr2Cost;

        return drinkCost;
    }

    @Override
    public boolean haveInventory() {
        boolean stocked = true;
        int stock1 = Inventory.getInstance().ingredientsList.get(ingredient1).getQuantity();
        int stock2 = Inventory.getInstance().ingredientsList.get(ingredient2).getQuantity();

        if (stock1 < ingr1Amt || stock2 < ingr2Amt)
            stocked = false;

        return stocked;
    }

    @Override
    public void dispenseDrink() {
        try {
            Inventory.getInstance().useIngredient(ingredient1, ingr1Amt);
            Inventory.getInstance().useIngredient(ingredient2, ingr2Amt);
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

