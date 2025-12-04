package ASSG;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseAdapterExample extends JFrame {

    private JLabel statusLabel;

    public MouseAdapterExample() {
        super("Mouse Adapter Example");

        statusLabel = new JLabel("Move or click the mouse...");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(statusLabel, BorderLayout.SOUTH);

        // Panel where mouse actions happen
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        add(panel, BorderLayout.CENTER);

        // MouseAdapter implementation
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                statusLabel.setText("Mouse Clicked at: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                statusLabel.setText("Mouse Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                statusLabel.setText("Mouse Released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                statusLabel.setText("Mouse Entered the panel");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                statusLabel.setText("Mouse Exited the panel");
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                statusLabel.setText("Mouse Moved at: (" + e.getX() + ", " + e.getY() + ")");
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                statusLabel.setText("Mouse Dragged at: (" + e.getX() + ", " + e.getY() + ")");
            }
        });

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MouseAdapterExample();
    }
}

