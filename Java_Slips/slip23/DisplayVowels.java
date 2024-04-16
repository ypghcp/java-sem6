import java.util.Scanner;

public class DisplayVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept a string from the user
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();

        // Display vowels from the string after every 3 seconds
        for (int i = 0; i < s.length(); i++) 
        {
            char ch = Character.toLowerCase(s.charAt(i));
            if (isVowel(ch)) 
            {
                System.out.println(ch);
                try {
                    Thread.sleep(3000); // Sleep for 3 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        scanner.close();
    }

    // Method to check if a character is a vowel
    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

