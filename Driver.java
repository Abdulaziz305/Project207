import java.util.LinkedList;
import java.util.Scanner;

public class Driver {

    public static void printMenu() {
        System.out.println("\nPlease select one of the options: ");
        System.out.println("1. Print list of all items in inventory.");
        System.out.println("2. Sort By Manufacturing Year.");
        System.out.println("3. Sort By Price.");
        System.out.println("4. Sort by Model.");
        System.out.println("0. Quit the program.");
    }

    public static Ledger populateInventory() {
        Ledger inventory = new Ledger();

        inventory.addItem(new Device("HP Note Book G750", "Electronics", "HP", 2020, 229));
        inventory.addItem(new Device("HP Note Book G800", "Electronics", "HP", 2019, 250));
        inventory.addItem(new Device("MacBook Pro", "Electronics", "Apple", 2021, 300));
        inventory.addItem(new Device("iPad Air", "Electronics", "Apple", 2018, 210));
        inventory.addItem(new Device("Air Purifier", "Electronics", "MI", 2018, 225));
        inventory.addItem(new Device("Note 9s", "Electronics", "MI", 2019, 257));
        inventory.addItem(new Device("10T pro plus", "Electronics", "MI", 2019, 196));

        return inventory;
    }

    public static void main(String[] args) {

        Ledger inventory = populateInventory();
        Scanner scanner = new Scanner(System.in);
        int choice = 100;

        while (choice != 0) {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print(inventory.toString());
                    break;
                case 2:
                    LinkedList<Device> inventoryListItems = inventory.getSortedByYear(inventory.getItems());
                    if (inventoryListItems.size() > 0) {
                        System.out.println("Items sorted by Manufacturing Year: ");
                        inventoryListItems.forEach(item -> {
                            System.out.println(item.toString());
                            System.out.println("----------------------");
                        });
                    }
                    break;

                case 3:
                    LinkedList<Device> items = inventory.getSortedByPrice(inventory.getItems());
                    if (items.size() > 0) {
                        System.out.println("Items sorted by price: ");
                        items.forEach(item -> {
                            System.out.println(item.toString());
                            System.out.println("----------------------");
                        });
                    }
                    break;

                case 4:
                    LinkedList<Device> inv = inventory.getSortedByName(inventory.getItems());
                    if (inv.size() > 0) {
                        System.out.println("Items sorted by Model: ");
                        inv.forEach(item -> {
                            System.out.println(item.toString());
                            System.out.println("----------------------");
                        });
                    }
                    break;
                default:
                    break;
            }

        }
    }
}
