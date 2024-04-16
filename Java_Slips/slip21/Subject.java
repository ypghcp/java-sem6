import java.util.*;

public class Subject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept the value of N
        System.out.print("Enter the number of subjects (N): ");
        int N = scanner.nextInt();

        // Create a LinkedList to store subject names
        LinkedList<String> subjectsList = new LinkedList<>();

        // Accept N subject names from the user and add them to the list
        System.out.println("Enter " + N + " subject names:");
        for (int i = 0; i < N; i++) {
            String subject = scanner.next();
            subjectsList.add(subject);
        }

        // Display subject names using Iterator interface
        System.out.println("Subject Names:");
        Iterator<String> iterator = subjectsList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        scanner.close();
    }
}

