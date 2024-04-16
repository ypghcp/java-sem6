import java.util.*;

public class Friend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of friends (N): ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        HashSet<String> friendSet = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of friend " + (i+1) + ": ");
            String name = scanner.nextLine();
            friendSet.add(name);
        }
        
        ArrayList<String> sortedNames = new ArrayList<>(friendSet);
        Collections.sort(sortedNames);
        
        System.out.println("\nFriend names in ascending order:");
        for (String name : sortedNames) {
            System.out.println(name);
        }
        
        scanner.close();
    }
}

