package Java_Slips.slip4;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class BlinkingText implements Runnable {
    private JLabel label;

    public BlinkingText(JLabel label) {
        this.label = label;
    }

    @Override
    public void run() {
        try {
            while (true) {
                label.setVisible(true);
                TimeUnit.MILLISECONDS.sleep(500); // Text visible for 500 milliseconds
                label.setVisible(false);
                TimeUnit.MILLISECONDS.sleep(500); // Text invisible for 500 milliseconds
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Blinking Text");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Blinking Text");
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label, BorderLayout.CENTER);

        BlinkingText blinkingText = new BlinkingText(label);
        Thread thread = new Thread(blinkingText);
        thread.start();

        frame.setVisible(true);
    }
}
