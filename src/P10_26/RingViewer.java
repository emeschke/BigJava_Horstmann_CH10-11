package P10_26;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 10/29/13
 * Time: 11:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class RingViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        //frame.setLayout(new FlowLayout());
        frame.setSize(4000,2000);
        frame.setTitle("Olympic Rings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        JComponent ring1 = drawRing(1,0,40,Color.BLACK);
        JComponent ring2 = drawRing(21,20,40,Color.BLACK);
        JComponent ring3 = drawRing(41,0,40,Color.GREEN);
        JComponent ring4 = drawRing(61,20,40,Color.RED);
        JComponent ring5 = drawRing(81,0,40,Color.BLUE);
        frame.add(ring1);
        frame.add(ring2);
        frame.add(ring3);
        frame.add(ring4);
        frame.add(ring5);



        frame.setVisible(true);

    }

    public static JComponent drawRing(int x, int y, int diam, Color color){
        JComponent component = new RingComponent(x,y,diam,color);
        return component;
    }
}
