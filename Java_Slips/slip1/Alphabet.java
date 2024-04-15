public class Alphabet {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            char currentChar = 'A';
            try {
                while (currentChar <= 'Z') {
                    System.out.print(currentChar + " ");
                    currentChar++;
                    Thread.sleep(2000); // Pause for 2 seconds
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        thread.start();
    }
}
