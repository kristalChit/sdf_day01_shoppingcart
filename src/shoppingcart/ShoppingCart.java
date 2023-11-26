package sdf.day01.shoppingcart;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class ShoppingCart {
    //entry point, it sets up the shopping cart program
    public static void main (String[] args) {
        //create an ArrayList named cart to store the items in the shopping cart.
        ArrayList<String> cart = new ArrayList<>();
        //initializes the scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to your shopping cart");

        while (true) {
            //this reads the user's input into the input variable after trimming white spaces.
            String input = scanner.nextLine().trim();

            //Command Handling
            //the code checks if the user's input is not empty.
            //it creates a lineScanner to process the input and checks if the input contains a valid command.
            //depending on the command ("list," "add," "delete," or "stop"), it calls the corresponding method or displays an error message for invalid commands.
            if (!input.isEmpty()) {
                String command;
                Scanner lineScanner = new Scanner(input);
                if (lineScanner.hasNext()) {
                    command = lineScanner.next();

                    if (command.equals("list")) {
                        listItems(cart);
                    } else if (command.equals("add")) {
                        addItems(cart, input);
                    } else if (command.equals("delete")) {
                        deleteItems(cart, lineScanner);
                    } else if (command.equals("stop")) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please try again.");
                    }
                }
            }
        }
    }
    // Listing items
    // this method list the items in the shopping cart.
    // if the cart is empty, it prints "Your cart is empty." Otherwise, it lists the items with numbers.
    public static void listItems(List<String> cart) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty");
        } else {
            int i = 1;
            for (String item : cart) {
                System.out.println(String.format("%d. %s%n", i, item));
                i++;
            }
        }
    }
    // Addding items
    // this method handles adding items to the shopping cart.
    // it splits the input into individual items (separated by commas), trims each item, and checks if it's already in the cart.
    // If not, it adds the item to the cart.
    public static void addItems(List<String> cart, String input){
                String[] itemsToAdd = input.split(",");
                for (String item : itemsToAdd) {
                    String trimmedItem = item.trim();
                    if (!cart.contains(trimmedItem)) {
                        cart.add(trimmedItem);
                        System.out.println(trimmedItem + " added to cart");
                    } else {
                        System.out.println(" You already have " + trimmedItem + " in your cart");
                    }
                }
            }
    
    // Deleting items
    // this method handles deleting items from the shopping cart based on an index.
    // it checks if the input contains an integer (index), and removes the item at that index if it's within a valid range.
    // it subtracts 1 from the user-provided index, to make it compatible with the 0-based indexing used in the ArrayList
    public static void deleteItems(List<String> cart, Scanner scanner) {
        if (scanner.hasNextInt()) {
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index < cart.size()) {
                String removedItem = cart.remove(index);
                System.out.println(removedItem + " removed from cart");
            } else {
                System.out.println("Incorrect item index");
            }
        }
    }
}