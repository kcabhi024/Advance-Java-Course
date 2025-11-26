package TestingDialogBox;
import javax.swing.JOptionPane;
public class Addition {
    public static void main(String[] args) {
        String firstNumber = JOptionPane.showInputDialog("Enter a First Number:");
        String secondNumber = JOptionPane.showInputDialog("Enter a second Number:");
        int num1 = Integer.parseInt(firstNumber);
        int num2 =Integer.parseInt(secondNumber);
         int sum = num1 +num2;
         JOptionPane.showMessageDialog(null,



                 "The sum is "+sum ,"sum of two integers",JOptionPane.PLAIN_MESSAGE);

    }

}
