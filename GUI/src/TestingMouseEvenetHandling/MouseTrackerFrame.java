package TestingMouseEvenetHandling;

import  java.awt.Color;
import  java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import javax.swing.JFrame;
import  javax.swing.JLabel;
import  javax.swing.JPanel;
public class MouseTrackerFrame extends  JFrame {
    private  JPanel mousePanel;
    private  JLabel statusBar;

    public  MouseTrackerFrame() {
        super("Demonestrating Mouse event");
        mousePanel = new JPanel();
        mousePanel.setBackground(Color.WHITE);
        add(mousePanel, BorderLayout.CENTER);
        statusBar = new JLabel("Mouse outside Jpanel");
        add(statusBar, BorderLayout.SOUTH);
        MouseHandler handler = new MouseHandler();
        mousePanel.addMouseListener(handler);
        mousePanel.addMouseMotionListener(handler);
    }
     private  class MouseHandler extends MouseAdapter{
        public  void  MouseClicked(MouseEvent e){
            statusBar.setText(String.format("clicked at [%d ,%d]",e.getX(),e.getY()));
        }
         public  void  MousePressed(MouseEvent event){
             statusBar.setText(String.format("Pressed at [%d ,%d]",event.getX(),event.getY()));
         }
         public  void  MouseReleased(MouseEvent event){
             statusBar.setText(String.format("Released at [%d ,%d]",event.getX(),event.getY()));
         }

         public  void  MouseEntered(MouseEvent event){
             statusBar.setText(String.format("Entered at [%d ,%d]",event.getX(),event.getY()));
             mousePanel.setBackground(Color.GREEN);
         }
         public  void  MouseExited(MouseEvent event){
             statusBar.setText(String.format("Exited at [%d ,%d]",event.getX(),event.getY()));
             mousePanel.setBackground(Color.WHITE);
         }
         public  void  MouseDragged(MouseEvent event){
             statusBar.setText(String.format("Dragged at [%d ,%d]",event.getX(),event.getY()));
         }
         public  void  MouseMoved(MouseEvent event){
             statusBar.setText(String.format("Moved at [%d ,%d]",event.getX(),event.getY()));
         }
    }

}
