public class DrinkImplLatte implements Drink {
    String ingredient1 = "Espresso";
    private int ingr1Amt = 2;
    String ingredient2 = "Steamed Milk";
    private int ingr2Amt = 1;

    public DrinkImplLatte() {
        if (haveInventory()) {
            updateInventory();
            System.out.println("Caffe latte has been dispensed.");
        } else
            System.out.println("Sorry, we're out of the ingredients to make that beverage.");
    }

    public double getDrinkCost() {
        double ingr1Cost = Inventory.getInstance().ingredientsList.get(ingredient1).getCost() * ingr1Amt;
        double ingr2Cost = Inventory.getInstance().ingredientsList.get(ingredient2).getCost() * ingr2Amt;
        double drinkCost = ingr1Cost + ingr2Cost;

        return drinkCost;
    }

    public boolean haveInventory() {
        boolean stocked = true;
        int stock1 = Inventory.getInstance().ingredientsList.get(ingredient1).getQuantity();
        int stock2 = Inventory.getInstance().ingredientsList.get(ingredient2).getQuantity();

        if (stock1 < ingr1Amt || stock2 < ingr2Amt)
            stocked = false;

        return stocked;
    }

    public void updateInventory() {
        try {
            Inventory.getInstance().useIngredient(ingredient1, ingr1Amt);
            Inventory.getInstance().useIngredient(ingredient2, ingr2Amt);
        } catch (InvalidDataException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

