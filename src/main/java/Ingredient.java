/**
 * CIS-365 Assignment 2
 * Stores and returns ingredient name, cost, and quantity.
 * Allows setting of quantity and use of ingredient based on
 * input quantity.
 *
 * @author Joelen Pastva
 */
public class Ingredient {
    private String name;
    private double cost;
    private int quantity;

    public Ingredient(String name, double cost, int quantity) throws InvalidDataException {
        setName(name);
        setCost(cost);
        setQuantity(quantity);
    }

    public String getName() {
        return name;
    }

    private void setName(String ingr) throws InvalidDataException {
        if (ingr == null || ingr.equals("")) {
            throw new InvalidDataException("Invalid input. Null or empty name entered.");
        }
        name = ingr;
    }

    public double getCost() {
        return cost;
    }

    private void setCost(double price) throws InvalidDataException {
        if (price < 0) {
            throw new InvalidDataException("Invalid price passed to cost.");
        }
        cost = price;
    }

    public void setQuantity(int quant) throws InvalidDataException {
        if (quant < 0 || quant > 10) {
            throw new InvalidDataException("Invalid quantity passed.");
        }
        quantity = quant;
    }

    public int getQuantity() {

        return quantity;
    }

    public void useQuantity (int amt) throws InvalidDataException {
        if (quantity - amt < 0) {
            throw new InvalidDataException("Out of stock.");
        }
        quantity -= amt;
    }
}
