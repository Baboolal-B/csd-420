/*
BaboolalThreeThreads.java
09/20/2025
This program creates a Swing window that displays a continuous 
stream of 30,000 random characters. Three separate threads each 
generate 10,000 random letters, digits, or special symbols and 
append them concurrently to the text area.
******NOTICE*****
When you first run this program the full output would take a while to display 
due to how Swing updates the screen. Wait time would be no longer than 15 seconds to finish.
*/

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BaboolalThreeThreads extends JFrame {
    private final JTextArea textArea = new JTextArea(30, 80);
    private final Random random = new Random();

    public BaboolalThreeThreads() {
        super("ThreeThreads Output");

        // GUI setup
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Start three threads
        Thread lettersThread = new Thread(new LettersTask());
        Thread digitsThread = new Thread(new DigitsTask());
        Thread specialsThread = new Thread(new SpecialsTask());

        lettersThread.start();
        digitsThread.start();
        specialsThread.start();
    }

    // --- Thread tasks ---
    private class LettersTask implements Runnable {
        public void run() {
            for (int i = 0; i < 10000; i++) {
                char c = (char) ('a' + random.nextInt(26));
                appendChar(c);
            }
        }
    }

    private class DigitsTask implements Runnable {
        public void run() {
            for (int i = 0; i < 10000; i++) {
                char c = (char) ('0' + random.nextInt(10));
                appendChar(c);
            }
        }
    }

    private class SpecialsTask implements Runnable {
        private final char[] specials = {'!', '@', '#', '$', '%', '&', '*'};

        public void run() {
            for (int i = 0; i < 10000; i++) {
                char c = specials[random.nextInt(specials.length)];
                appendChar(c);
            }
        }
    }

    /** Safely append a single character to the text area on the Swing UI thread. */
    private void appendChar(char c) {
        SwingUtilities.invokeLater(() -> textArea.append(String.valueOf(c)));
    }

    // --- MAIN: Launch the program ---
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BaboolalThreeThreads::new);
    }
}
