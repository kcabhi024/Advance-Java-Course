package TestingRadioButton;

import  javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import  java.awt.Font;
import java.awt.*;
import java.awt.event.ItemListener;
import  java.awt.event.ItemEvent;



import  javax.swing.ButtonGroup;
import javax.swing.plaf.SeparatorUI;


public class RadioButtonFrame  extends  JFrame{
    private  JTextField textField;
    private  Font plainFont;
     private Font boldFont;
     private Font italicFont;
     private  Font bolditalicFont;
     private  JRadioButton plainJRadioButton;
    private  JRadioButton boldJRadioButton;
    private  JRadioButton italicJRadioButton;
    private  JRadioButton bolditalicJRadioButton;
    private ButtonGroup radioGroup;



    public  RadioButtonFrame(){
        super("RadioButton Test");
        setLayout(new FlowLayout());
        textField = new JTextField("d claz]s xf] ." ,25);
        add(textField);


        // create radio buttons


        plainJRadioButton = new JRadioButton("Plain", true);

        italicJRadioButton = new JRadioButton("Italic", false);

        boldJRadioButton = new JRadioButton("Bold", false);
        bolditalicJRadioButton = new JRadioButton("Bold/Italic",false);
        add(plainJRadioButton);
        add(bolditalicJRadioButton);
        add(boldJRadioButton);
        add(italicJRadioButton);


        // create logical relationship between JRadioButton
        radioGroup = new ButtonGroup();
        radioGroup.add(plainJRadioButton);
        radioGroup.add(bolditalicJRadioButton);
        radioGroup.add(boldJRadioButton);
        radioGroup.add(italicJRadioButton);

        // create font objects

        plainFont = new Font("Preeti" ,Font.PLAIN,14);
        boldFont  = new Font("Preeti", Font.BOLD, 14);
        italicFont = new Font("Preeti", Font.ITALIC ,14);
        bolditalicFont = new Font("Preeti" , Font.BOLD+ Font.ITALIC , 14);



        plainJRadioButton.addItemListener(
                new RadioButtonHandler(plainFont));
        boldJRadioButton.addItemListener(
                new RadioButtonHandler(boldFont));
        italicJRadioButton.addItemListener(
                new RadioButtonHandler(italicFont));
        bolditalicJRadioButton.addItemListener(
                new RadioButtonHandler(bolditalicFont));
    }


    private class  RadioButtonHandler implements  ItemListener{
        private  Font font;
        public  RadioButtonHandler( Font f){
            font =f;

        }

        public  void  itemStateChanged(ItemEvent event){
            textField.setFont(font);
        }
    }

}
