package DrawingShapes;

import  javax.swing.JFrame;
import java.awt.*;

public class ShapeTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing Graphics ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ShapesJPanel shapejpanel = new ShapesJPanel();
        shapejpanel.setBackground(Color.WHITE);
        frame.add(shapejpanel);
        frame.setSize(400,200);
        frame.setVisible(true);



    }
}
