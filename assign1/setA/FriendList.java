import java.util.LinkedList;
import java.util.Scanner;

public class FriendList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of friends: ");
        int n = scanner.nextInt();

        LinkedList<String> friends = new LinkedList<>();

        System.out.println("Enter the names of your " + n + " friends:");
        for (int i = 0; i < n; i++) {
            friends.add(scanner.next());
        }

        // Display the contents of the linked list
        System.out.println("\nFriends in the linked list:");
        for (String friend : friends) {
            System.out.println(friend);
        }
    }
}
