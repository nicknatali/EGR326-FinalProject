package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YahtzeeGUI{
    /*
     Variables for GUI panel
     */
    private JFrame frame;
    protected static final int WIDTH = 500;
    protected static final int HEIGHT = 700;



    /*
    Variables for GUI panel
    */
    public YahtzeeGUI(){
        //Display GUI
        frame.setVisible(true);
    }


    // This class handles "action events", aka mouse clicks, in buttons.
    public class DiceAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello");
        }
    }
}
