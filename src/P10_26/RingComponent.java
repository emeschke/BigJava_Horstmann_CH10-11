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
        g.setColor(color);
        g.drawOval(x,y,diameter,diameter);


    }

}




