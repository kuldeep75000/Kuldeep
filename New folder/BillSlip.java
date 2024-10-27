import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Cart {
    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
        System.out.println(item.getName() + " added to the cart.");
    }

    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void printBill(String username, double gstRate) {
        double total = calculateTotal();
        double gstAmount = total * gstRate / 100;
        double finalAmount = total + gstAmount;

        System.out.println("\n--- Bill for " + username + " ---");
        System.out.println("Itemized Bill:");
        for (Item item : items) {
            System.out.printf("%s: $%.2f%n", item.getName(), item.getPrice());
        }
        System.out.printf("Subtotal: $%.2f%n", total);
        System.out.printf("GST (%.2f%%): $%.2f%n", gstRate, gstAmount);
        System.out.printf("Total Amount: $%.2f%n", finalAmount);
    }
}

public class BillSlip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        // Get username
        System.out.print("Enter your name: ");
        String username = scanner.nextLine();

        // Set GST rate (example: 18%)
        double gstRate = 18.0;

        String command;
        System.out.println("Welcome to the Amazon Billing System, " + username + "!");
        do {
            System.out.println("Enter command (add/view/checkout/exit):");
            command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    Item item = new Item(name, price);
                    cart.addItem(item);
                    break;
                case "view":
                    cart.printBill(username, gstRate);
                    break;
                case "checkout":
                    cart.printBill(username, gstRate);
                    System.out.println("Thank you for your purchase!");
                    command = "exit"; // Exit after checkout
                    break;
                case "exit":
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        } while (!command.equals("exit"));

        scanner.close();
    }
}
