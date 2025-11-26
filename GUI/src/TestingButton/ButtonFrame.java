package TestingButton;
import java.awt.FlowLayout;
import  java.awt.event.ActionListener;
import  java.awt.event.ActionEvent;
import javax.swing.*;

public class ButtonFrame  extends  JFrame{
    private JButton button1;
    private  JButton button2;
    public  ButtonFrame(){
        super("Here is a Testing button field ");
        setLayout(new FlowLayout());
        button1 = new JButton("plain Text");
        add(button1);
        Icon bug =new ImageIcon(getClass().getResource("bug1.png"));

        button2 = new JButton("fancy button" ,bug);
        add(button2);
        ButtonHandler handler = new ButtonHandler();
        button1.addActionListener(handler);
        button2.addActionListener(handler);
    }
    public  class ButtonHandler implements  ActionListener{
        public  void  actionPerformed(ActionEvent event){
            String string = "";
            if(event.getSource()== button1)
                string = String.format("Plain Button is Pressed ",event.getActionCommand());
            else if(event.getSource()== button2)
                string = String.format("Fancy Button is Pressed",event.getActionCommand());
            JOptionPane.showMessageDialog(null,string);

        }
    }

}

