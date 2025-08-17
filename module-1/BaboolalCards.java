/*
BaboolalCards.java
08/17/2025
This program displays four randomly selected playing cards from a virtual deck of 52 cards.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;

public class BaboolalCards {

    private static final String CARD_PATH = "cards"; // folder with card images
    private static final int CARD_DISPLAY_COUNT = 4;
    private static final int CARD_WIDTH = 100; // smaller width
    private static final int CARD_HEIGHT = 145; // approximate height

    private JFrame frame;
    private JPanel cardPanel;
    private List<File> cardFiles;

    public BaboolalCards() {
        // Load all card images from folder
        File folder = new File(CARD_PATH);
        cardFiles = new ArrayList<>();
        if (folder.exists() && folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".png")) {
                    cardFiles.add(file);
                }
            }
        }

        // Create UI
        frame = new JFrame("Random Card Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        cardPanel = new JPanel();
        cardPanel.setLayout(new FlowLayout());
        frame.add(cardPanel, BorderLayout.CENTER);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> showRandomCards()); // Lambda expression
        frame.add(refreshButton, BorderLayout.SOUTH);

        showRandomCards(); // display initial cards
        frame.setVisible(true);
    }

    private void showRandomCards() {
        cardPanel.removeAll();

        if (cardFiles.size() < CARD_DISPLAY_COUNT) return;

        Collections.shuffle(cardFiles);
        for (int i = 0; i < CARD_DISPLAY_COUNT; i++) {
            try {
                BufferedImage img = ImageIO.read(cardFiles.get(i));
                Image scaled = img.getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(scaled);
                JLabel label = new JLabel(icon);
                cardPanel.add(label);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        cardPanel.revalidate();
        cardPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BaboolalCards::new);
    }
}
