package P10_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 10/29/13
 * Time: 10:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class ButtonFrame1 extends JFrame {
    //Create a button and a label, set constants for the frame size.
    private JButton button;
    private JLabel label;

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 100;

    //Constructor
    public ButtonFrame1()
    {
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

    }

    //Create an inside class that implements ActionListener.  Have a variable that counts the number of times the
    //action is called and prints it out in the label.
    class ClickListener implements ActionListener{
        int intClick = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
            intClick++;
            label.setText(intClick + " clicks.");
        }
    }

    private void createComponents()
    //Method creates components of the frame with a button and associated clickListener, a label, and a panel with
    //those things added to it.
    {
        button = new JButton("Click me!");
        ActionListener listener = new ClickListener();
        button.addActionListener(listener);


        label = new JLabel("0 clicks.");

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(label);
        add(panel);
    }



}
