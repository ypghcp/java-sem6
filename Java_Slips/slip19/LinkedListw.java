import java.util.*;

public class LinkedListw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept the value of N
        System.out.print("Enter the number of integers (N): ");
        int N = scanner.nextInt();

        // Create a LinkedList to store integers
        LinkedList<Integer> list = new LinkedList<>();

        // Accept N integers from the user and add them to the list
        System.out.println("Enter " + N + " integers:");
        for (int i = 0; i < N; i++) {
            int num = scanner.nextInt();
            list.add(num);
        }

        // Display only the negative integers
        System.out.println("Negative Integers:");
        for (int num : list) {
            if (num < 0) {
                System.out.println(num);
            }
        }

        scanner.close();
    }
}

