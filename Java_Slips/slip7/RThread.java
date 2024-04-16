import java.util.Random;

class Generator extends Thread 
{
    public void run() 
    {
        Random random = new Random();
        while (true) {
            try {
                Thread.sleep(1000); // Wait for one second
                int n = random.nextInt(100); // Generate a random integer between 0 and 99
                System.out.println("Generated Number: " + n);
                if (n % 2 == 0) {
                    SquareThread squareThread = new SquareThread(n);
                    squareThread.start();
                } else {
                    CubeThread cubeThread = new CubeThread(n);
                    cubeThread.start();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SquareThread extends Thread 
{
    private int number;

    public SquareThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int square = number * number;
        System.out.println("Square of " + number + ": " + square);
    }
}

class CubeThread extends Thread 
{
    private int number;

    public CubeThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int cube = number * number * number;
        System.out.println("Cube of " + number + ": " + cube);
    }
}

public class RThread {
    public static void main(String[] args) {
        Generator gen = new Generator();
        gen.start();
    }
}
