public class DrinkImplDecaf implements Drink {

    String ingredient1 = "Decaf Coffee";
    private int ingr1Amt = 3;
    String ingredient2 = "Sugar";
    private int ingr2Amt = 1;
    String ingredient3 = "Cream";
    private int ingr3Amt = 1;

    public DrinkImplDecaf() {
        if (haveInventory()) {
            updateInventory();
            System.out.println("Decaf coffee has been dispensed.");
        }
        else
            System.out.println("Sorry, we're out of the ingredients to make that beverage.");
    }

    public double getDrinkCost() {
        double ingr1Cost = Inventory.getInstance().ingredientsList.get(ingredient1).getCost() * ingr1Amt;
        double ingr2Cost = Inventory.getInstance().ingredientsList.get(ingredient2).getCost() * ingr2Amt;
        double ingr3Cost = Inventory.getInstance().ingredientsList.get(ingredient3).getCost() * ingr3Amt;
        double drinkCost = ingr1Cost + ingr2Cost + ingr3Cost;

        return drinkCost;
    }

    public boolean haveInventory() {
        boolean stocked = true;
        int stock1 = Inventory.getInstance().ingredientsList.get(ingredient1).getQuantity();
        int stock2 = Inventory.getInstance().ingredientsList.get(ingredient2).getQuantity();
        int stock3 = Inventory.getInstance().ingredientsList.get(ingredient3).getQuantity();

        if (stock1 < ingr1Amt || stock2 < ingr2Amt || stock3 < ingr3Amt)
            stocked = false;

        return stocked;
    }

    public void updateInventory() {
        try {
            Inventory.getInstance().useIngredient(ingredient1, ingr1Amt);
            Inventory.getInstance().useIngredient(ingredient2, ingr2Amt);
            Inventory.getInstance().useIngredient(ingredient3, ingr3Amt);
        } catch (InvalidDataException ex) {
            System.out.println(ex.getMessage());
        }
    }
}