/**
 * CIS-365 Assignment 2
 * Main method
 *
 * @author Joelen Pastva
 */

import java.util.Scanner;

public class BaristaDriver {
    public static void main(String[] args) {
        char choice;

        System.out.println(Inventory.getInstance().toString());
        System.out.println(Menu.getInstance().displayMenu());
        do {
            Scanner kb = new Scanner(System.in);
            choice = kb.next().charAt(0);
            Machine.takeInput(choice);
        } while (choice != 'q' && choice != 'Q');
    }
}
