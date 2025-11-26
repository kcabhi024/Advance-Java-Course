package TestingTextField;
import java.awt.FlowLayout;
import  java.awt.event.ActionListener;
import  java.awt.event.ActionEvent;
import  javax.swing.JFrame;
import  javax.swing.JTextField;
import  javax.swing.JOptionPane;
import  javax.swing.JPasswordField;
public class TextFieldFrame  extends  JFrame{


    private  JTextField textField1;
    private  JTextField textField2;
    private  JTextField textField3;
    private  JPasswordField passwordField;

    public  TextFieldFrame(){
        super("Testing JTextField and jPassword");
        setLayout(new FlowLayout());

        // construct text field with 10 column
        textField1 = new JTextField(10);
        add(textField1);
        textField2 = new JTextField("Enter a Text Here :");
        add(textField2);
        textField3 = new JTextField("UnEditable text field", 12  );
        textField3.setEditable(false);
        add(textField3);

        // construct password field
        passwordField = new JPasswordField(10);
        add(passwordField);

        // register event handlers
        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        passwordField.addActionListener(handler);

    }  //end textFieldFrame Constructor
    // private inner class for event listener
    private  class TextFieldHandler implements ActionListener{

        // Process text field events
        public  void actionPerformed(ActionEvent event){
            String string = "";

            if(event.getSource()== textField1)
                string = String.format(" textField1 : %s ",event.getActionCommand());
            else if(event.getSource()== textField2)
                string = String.format(" textField2 : %s ",event.getActionCommand());

            else if(event.getSource()== textField3)
                string = String.format(" textField3 : %s ",event.getActionCommand());
            else if(event.getSource()== passwordField)
                string = String.format(" Password Field : %s ",event.getActionCommand());

            // display JTextField content
            JOptionPane.showMessageDialog(null,string);
        }
    }


}
