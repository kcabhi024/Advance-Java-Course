package DrawingColors;

import javax.swing.*;

public class ShowColor {
    public static void main(String[] args) {
        JFrame jframe = new JFrame("Using Color");
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        ColorJPanel panel = new ColorJPanel();
        jframe.add(panel);
        jframe.setSize(400,200);
        jframe.setVisible(true);

    }
}
