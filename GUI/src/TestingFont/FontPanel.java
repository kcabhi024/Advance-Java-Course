package TestingFont;

import  java.awt.Font;
import  java.awt.Color;
import  java.awt.Graphics;
import  javax.swing.JPanel;

// yo lab 2 hoo
public class FontPanel extends  JPanel {

        public  void paintComponent(Graphics g){
            super.paintComponent(g);

            g.setFont(new Font("Nirmala UI", Font.BOLD,12));
            g.drawString("रंग प्रदर्शन " ,20,30);

            // set font to monospaced

            g.setFont(new Font("Preeti", Font.ITALIC,24));
            g.drawString("d claz]s xf] .", 20,50);

            g.setFont(new Font("Serif", Font.PLAIN,24));
            g.drawString("Hi i am abhishek kc.", 20,70);

            g.setColor(Color.red);
            g.drawString("Its Aw_be", 20,90);


        }

}
