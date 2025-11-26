package TestingLabel;
import java.awt.FlowLayout;
import  javax.swing.JFrame;
import javax.swing.JLabel;
import  javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class LabelFrame extends JFrame{
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    public  LabelFrame(){
        super("Testing Lable");
        setLayout(new FlowLayout());
        label1 =new JLabel("Label with text");
        label1.setToolTipText("this is label 1");
        add(label1);
        // JLabel constructor with string , icon and alignment
        Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
        label2 = new JLabel("lable with text and icon", bug, SwingConstants.LEFT);
        label2.setToolTipText(("this is label 2"));
        add(label2);   // add label to the JFrame
        label3 = new JLabel();
        label3.setText("label with icon and text at bottom");
        label3.setIcon(bug);
        label3.setHorizontalTextPosition(SwingConstants.CENTER);
        label3.setVerticalTextPosition(SwingConstants.BOTTOM);
        label3.setToolTipText("this is label 3");
        add(label3);

    }



}
