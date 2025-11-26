package TestingFont;

import javax.swing.*;

public class FontTest {


    public static void main(String[] args) {
        JFrame frame = new JFrame("Testing Font");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        FontPanel panel = new FontPanel();
        frame.add(panel);
        frame.setSize(430,250);
        frame.setVisible(true);

    }
}
