package Java_Slips.slip3;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.ListIterator;

public class LinkedLists {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add element at the end of the list");
            System.out.println("2. Delete first element of the list");
            System.out.println("3. Display the contents of list in reverse order");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter element to add at the end: ");
                    String element = scanner.nextLine();
                    linkedList.add(element);
                    System.out.println("Element added successfully!");
                    break;
                case 2:
                    if (!linkedList.isEmpty()) {
                        linkedList.removeFirst();
                        System.out.println("First element deleted successfully!");
                    } else {
                        System.out.println("The list is empty. No element to delete.");
                    }
                    break;
                case 3:
                    if (!linkedList.isEmpty()) {
                        System.out.println("Contents of list in reverse order:");
                        displayReverseList(linkedList);
                    } else {
                        System.out.println("The list is empty.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void displayReverseList(LinkedList<String> list) {
        ListIterator<String> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}

