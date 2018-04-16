    public class DrinkImplAmericano implements Drink {
        String ingredient1 = "Espresso";
        int ingr1Amt = 3;

        public DrinkImplAmericano() {
            if (haveInventory()) {
                updateInventory();
                System.out.println("Caffe Americano has been dispensed.");
            }
            else
                System.out.println("Sorry, we're out of the ingredients to make that beverage.");
        }

        public double getDrinkCost() {
            double drinkCost = Inventory.getInstance().ingredientsList.get(ingredient1).getCost() * ingr1Amt;

            return drinkCost;
        }

        public boolean haveInventory() {
            boolean stocked = true;
            int stock1 = Inventory.getInstance().ingredientsList.get(ingredient1).getQuantity();

            if (stock1 < ingr1Amt)
                stocked = false;

            return stocked;
        }

        public void updateInventory() {
            try {
                Inventory.getInstance().useIngredient(ingredient1, ingr1Amt);
            } catch (InvalidDataException ex) {
                System.out.println(ex.getMessage());
            }
        }

}
