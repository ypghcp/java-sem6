import java.util.LinkedList;
import java.util.Scanner;

public class Linked {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add element at first position");
            System.out.println("2. Delete last element");
            System.out.println("3. Display the size of linked list");
            System.out.println("4. Exit");
            System.out.println("Linked List: "+linkedList);
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
          

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to add at first position: ");
                    int elementToAdd = scanner.nextInt();
                    linkedList.addFirst(elementToAdd);
                    System.out.println("Element added at first position.");
                    break;
                case 2:
                    if (!linkedList.isEmpty()) {
                        linkedList.removeLast();
                        System.out.println("Last element deleted.");
                    } else {
                        System.out.println("LinkedList is empty. Nothing to delete.");
                    }
                    break;
                case 3:
                    System.out.println("Size of the LinkedList: " + linkedList.size());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

