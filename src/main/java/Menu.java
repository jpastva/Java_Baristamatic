import java.util.TreeMap;

public class Menu {

    private volatile static Menu instance;

    public TreeMap<String, Drink> drinks = new TreeMap<String, Drink>();
    DrinkImplAmericano americano = new DrinkImplAmericano();
    DrinkImplCappuccino cappuccino = new DrinkImplCappuccino();
    DrinkImplCoffee coffee = new DrinkImplCoffee();
    DrinkImplDecaf decaf = new DrinkImplDecaf();
    DrinkImplLatte latte = new DrinkImplLatte();
    DrinkImplMocha mocha = new DrinkImplMocha();

    private Menu() {
        drinks.put(americano.name, americano);
        drinks.put(cappuccino.name, cappuccino);
        drinks.put(coffee.name, coffee);
        drinks.put(decaf.name, decaf);
        drinks.put(latte.name, latte);
        drinks.put(mocha.name, mocha);
    }

    public static Menu getInstance() {
        if (instance == null) {
            synchronized (Inventory.class) {
                if (instance == null) {
                    instance = new Menu();
                }
            }
        }
        return instance;
    }

    public String displayMenu() {
        int drinkNum = 1;
        StringBuilder menu = new StringBuilder();
        menu.append("Menu:\n");
        for (Drink d : drinks.values()) {
            menu.append(drinkNum + ", ");
            menu.append(d.toString());
            menu.append("\n");
            drinkNum++;
        }
        return menu.toString();
    }
}
