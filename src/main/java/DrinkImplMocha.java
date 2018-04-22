/**
 * CIS-365 Assignment 2
 * Mocha implements Drink interface, stores drink name and recipe,
 * dispenses drink, returns drink cost, checks if in stock.
 *
 * @author Joelen Pastva
 */

import java.text.DecimalFormat;

public class DrinkImplMocha implements Drink {
    String name = "Caffe Mocha";
    String ingredient1 = "Espresso";
    private int ingr1Amt = 1;
    String ingredient2 = "Cocoa";
    private int ingr2Amt = 1;
    String ingredient3 = "Steamed Milk";
    private int ingr3Amt = 1;
    String ingredient4 = "Whipped Cream";
    private int ingr4Amt = 1;

    public DrinkImplMocha() {

    }

    @Override
    public double getDrinkCost() {
        double ingr1Cost = Inventory.getInstance().ingredientsList.get(ingredient1).getCost() * ingr1Amt;
        double ingr2Cost = Inventory.getInstance().ingredientsList.get(ingredient2).getCost() * ingr2Amt;
        double ingr3Cost = Inventory.getInstance().ingredientsList.get(ingredient3).getCost() * ingr3Amt;
        double ingr4Cost = Inventory.getInstance().ingredientsList.get(ingredient4).getCost() * ingr4Amt;
        double drinkCost = ingr1Cost + ingr2Cost + ingr3Cost + ingr4Cost;

        return drinkCost;
    }

    @Override
    public boolean haveInventory() {
        boolean stocked = true;
        int stock1 = Inventory.getInstance().ingredientsList.get(ingredient1).getQuantity();
        int stock2 = Inventory.getInstance().ingredientsList.get(ingredient2).getQuantity();
        int stock3 = Inventory.getInstance().ingredientsList.get(ingredient3).getQuantity();
        int stock4 = Inventory.getInstance().ingredientsList.get(ingredient4).getQuantity();

        if (stock1 < ingr1Amt || stock2 < ingr2Amt || stock3 < ingr3Amt || stock4 < ingr4Amt)
            stocked = false;

        return stocked;
    }

    @Override
    public void dispenseDrink() {
        try {
            Inventory.getInstance().useIngredient(ingredient1, ingr1Amt);
            Inventory.getInstance().useIngredient(ingredient2, ingr2Amt);
            Inventory.getInstance().useIngredient(ingredient3, ingr3Amt);
            Inventory.getInstance().useIngredient(ingredient4, ingr4Amt);
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
