package P10_2;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 10/29/13
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class ButtonViewer1 {

    public static void main(String[] args) {
        //Create a new ButtonFrame1 objects, make it Exit on Close and make it visible.
        JFrame frame = new ButtonFrame1();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
