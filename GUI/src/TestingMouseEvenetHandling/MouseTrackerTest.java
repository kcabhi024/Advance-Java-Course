package TestingMouseEvenetHandling;


import javax.swing.*;
import java.awt.event.MouseEvent;

public class MouseTrackerTest {
    public static void main(String[] args) {
        MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame();
        mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mouseTrackerFrame.setSize(300,100);
        mouseTrackerFrame.setVisible(true);
    }

}
