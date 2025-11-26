package DialogBox;

import javax.swing.*;
import java.awt.*;

public class Addition {

    public static void main(String[] args) {

        String firstNumber = JOptionPane.showInputDialog("Enter a First Number:");
        String secondNumber = JOptionPane.showInputDialog("Enter a second Number:");
        int num1 = Integer.parseInt(firstNumber);
        int num2 = Integer.parseInt(secondNumber);
        int sum = num1 + num2;
        JOptionPane optionPane = new JOptionPane(
                "The sum is " + sum,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.DEFAULT_OPTION);

        // creating a dialog box for this

        JDialog dialog = optionPane.createDialog("the sum of two integer");
        // pack for actual dialog box size

        dialog.pack();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dialogSize = dialog.getSize();

        int x = screenSize.width - dialogSize.width;
        int y = 0;
        dialog.setLocation(x, y);
        dialog.setVisible(true);


    }

    private static String showInputDialogTopRight(String message) {
        JOptionPane optionPane = new JOptionPane(
                message,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.DEFAULT_OPTION);
        JDialog dialog = optionPane.createDialog("input required");



    }
}
