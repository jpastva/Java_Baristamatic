/**
 * CIS-365 Assignment 2
 * Receives input from main method and determines whether to refill ingredients,
 * dispense a drink, or exit the program. Drink selection made based on number
 * of drink selected in alphabetical order. Only dispenses when drink in stock.
 *
 * @author Joelen Pastva
 */
public class Machine {

    public static void takeInput(char choice) {
        if (choice == 'r' || choice == 'R') {
            Inventory.getInstance().refillIngredient();
        } else if (Character.isDigit(choice)) {
            int choiceNum = Character.getNumericValue(choice);
            dispenseDrink(choiceNum);
            System.out.println(Menu.getInstance().displayMenu());
            System.out.println(Inventory.getInstance().toString());
        } else if (choice != 'q' && choice != 'Q') {
            System.out.println("Invalid selection: " + choice);
        }
    }

    public static void dispenseDrink(int choice) {
        if (choice < 1 || choice > 6) {
            System.out.println("Invalid selection: " + choice);
        }
        switch (choice) {
            case 1:
                if (Menu.getInstance().drinks.get("Caffe Americano").haveInventory()) {
                    System.out.println("Dispensing: Caffe Americano");
                    Menu.getInstance().drinks.get("Caffe Americano").dispenseDrink();
                } else
                    System.out.println("Out of stock: Caffe Americano");
                break;
            case 2:
                if (Menu.getInstance().drinks.get("Caffe Latte").haveInventory()) {
                    System.out.println("Dispensing: Caffe Latte");
                    Menu.getInstance().drinks.get("Caffe Latte").dispenseDrink();
                } else System.out.println("Out of stock: Caffe Latte");
                break;
            case 3:
                if (Menu.getInstance().drinks.get("Caffe Mocha").haveInventory()) {
                    System.out.println("Dispensing: Caffe Mocha");
                    Menu.getInstance().drinks.get("Caffe Mocha").dispenseDrink();
                } else System.out.println("Out of stock: Caffe Mocha");
                break;
            case 4:
                if (Menu.getInstance().drinks.get("Cappuccino").haveInventory()) {
                    System.out.println("Dispensing: Cappuccino");
                    Menu.getInstance().drinks.get("Cappuccino").dispenseDrink();
                } else System.out.println("Out of stock: Cappuccino");
                break;
            case 5:
                if (Menu.getInstance().drinks.get("Coffee").haveInventory()) {
                    System.out.println("Dispensing: Coffee");
                    Menu.getInstance().drinks.get("Coffee").dispenseDrink();
                } else System.out.println("Out of stock: Coffee");
                break;
            case 6:
                if (Menu.getInstance().drinks.get("Decaf Coffee").haveInventory()) {
                    System.out.println("Dispensing: Decaf Coffee");
                    Menu.getInstance().drinks.get("Decaf Coffee").dispenseDrink();
                } else System.out.println("Out of stock: Decaf Coffee");
                break;
        }
    }
}

