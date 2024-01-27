package com.Computer_Engineer_2020_CE_39;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class CardLayoutTest {

    private final JPanel cardPanel;
    private final CardLayout cardLayout;

    public CardLayoutTest() {
        JPanel cp = new JPanel(new BorderLayout());
        cp.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        cardLayout = new CardLayout(5, 5);
        cardPanel = new JPanel(cardLayout);
        cp.add(cardPanel);
        for (int i = 0; i < 5; i++) {// Create random panels for testing.
            String name = "ImagePanel" + (i + 1);
            String image = (i & 1) == 0 ? "foo.gif" : "bar.gif";
            Color clr = (i & 1) == 0 ? Color.red : Color.blue;
            ImagePanel imgPanel = new ImagePanel(name, image, clr);
            cardPanel.add(imgPanel, name);
            cardLayout.addLayoutComponent(imgPanel, name);
        }
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));

        JButton prevButton = new JButton("< Previous");
        prevButton.setActionCommand("Previous");
        prevButton.addActionListener(e -> cardLayout.previous(cardPanel));
        buttonPanel.add(prevButton);

        JButton nextButton = new JButton("Next >");
        nextButton.setActionCommand("Next");
        nextButton.addActionListener(e -> cardLayout.next(cardPanel));
        buttonPanel.add(nextButton);

        JPanel temp = new JPanel(new BorderLayout());
        temp.add(buttonPanel, BorderLayout.LINE_END);

        cp.add(temp, BorderLayout.SOUTH);
        JFrame frame = new JFrame("Test");
        frame.add(cp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CardLayoutTest::new);
    }
}

class ImagePanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 1L;
    private final String imgString;
    private JLabel imgLabel;

    public ImagePanel(String name, String imgString, Color backGround) {
        setName(name);
        this.imgString = imgString;
        setLayout(new BorderLayout());
        setBackground((backGround));
        // Ensure size is correct even before any image is loaded.
        setPreferredSize(new Dimension(400, 300));
    }

    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            System.err.println(getName() + ": Loading and adding image");
            ImageIcon icon = new ImageIcon(imgString);
            imgLabel = new JLabel(icon);
            add(imgLabel);
        }
        super.setVisible(visible);
        if (!visible) { // Do after super.setVisible() so image doesn't "disappear".
            System.err.println(getName() + ": Removing image");
            if (imgLabel != null) { // Before display, this will be null
                remove(imgLabel);
                imgLabel = null; // Hint to GC that component/image can be collected.
            }
        }
    }
}