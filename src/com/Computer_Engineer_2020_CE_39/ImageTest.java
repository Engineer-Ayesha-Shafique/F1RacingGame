package com.Computer_Engineer_2020_CE_39;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JPanel;
public class ImageTest extends javax.swing.JFrame {
    Image img = Toolkit.getDefaultToolkit().getImage("images" +
            ".jpg");
    public ImageTest() throws IOException {
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        });
        pack();
        setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new ImageTest();
    }
}