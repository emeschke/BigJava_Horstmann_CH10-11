package P10_26;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 10/29/13
 * Time: 11:09 PM
 * To change this template use File | Settings | File Templates.
 */

public class RingComponent extends JComponent {
    int x;
    int y;
    int diameter;
    Color color;

    public RingComponent(int x, int y, int diameter, Color color){
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.color = color;
    }

    public void paintComponent(Graphics g){
        //Paints everything in the paintComponent method.  Not a great implementation according to the instructions.
        g.setColor(Color.YELLOW);
        g.drawOval(1,0,40,40);
        g.setColor(Color.BLACK);
        g.drawOval(21,20,40,40);
        g.setColor(Color.GREEN);
        g.drawOval(41,0,40,40);
        g.setColor(Color.RED);
        g.drawOval(61,20,40,40);
        g.setColor(Color.BLUE);
        g.drawOval(81,0,40,40);

    }

}




