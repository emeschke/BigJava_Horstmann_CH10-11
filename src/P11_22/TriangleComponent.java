package P11_22;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 10/31/13
 * Time: 6:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class TriangleComponent extends JComponent {
    private static final int RECTANGLE_WIDTH = 2;
    private static final int RECTANGLE_HEIGHT = 2;

    private int xLeft;
    private int yTop;
    ArrayList<Point> dotList = new ArrayList<Point>();

    public TriangleComponent(){
        xLeft = 0;
        yTop = 0;

    }
    //This one is complicated.  The idea is to pass to this component drawer an arrayList of points.  The method will
    //then draw a dot, two dots and a line, or three dots and three lines as the problem dictates.  The startPrint
    //variable finds the first dot in the arrayList to print.  This is very complicated because it is trying to count
    //back from the end of the array and also convert from 1 based to 0 based indexing.  Formatting is bit of a pain,
    //but it works.
    public void paintComponent(Graphics g){
        int startPrint = dotList.size()-(dotList.size()-1)%3 -1;
        //int modThree = (dotList.size()-1)%3;
        //System.out.println("***" + startPrint + "***" + modThree);
        //to do if there is one click
        if ((dotList.size()-1)%3  == 0){
            g.drawRect((int)dotList.get(startPrint).getX(),(int)dotList.get(startPrint).getY(),
                        RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
        }
        //to do if there are two clicks
        else if ((dotList.size()-1)%3 == 1){
            g.drawRect((int)dotList.get(startPrint).getX(),(int)dotList.get(startPrint).getY(),
                       RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
            g.drawRect((int)dotList.get(startPrint+1).getX(),(int)dotList.get(startPrint+1).getY(),
                       RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
            g.drawLine((int)dotList.get(startPrint).getX(), (int)dotList.get(startPrint).getY(),
                       (int)dotList.get(startPrint+1).getX(), (int)dotList.get(startPrint+1).getY());

        }
        //to do if there are three clicks
        else if ((dotList.size()-1)%3 == 2){
            g.drawRect((int)dotList.get(startPrint).getX(),(int)dotList.get(startPrint).getY(),
                       RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
            g.drawRect((int)dotList.get(startPrint+1).getX(),(int)dotList.get(startPrint+1).getY(),
                       RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
            g.drawRect((int)dotList.get(startPrint+2).getX(),(int)dotList.get(startPrint+2).getY(),
                       RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
            g.drawLine((int) dotList.get(startPrint).getX(), (int) dotList.get(startPrint).getY(),
                       (int) dotList.get(startPrint+1).getX(), (int) dotList.get(startPrint+1).getY());
            g.drawLine((int) dotList.get(startPrint+1).getX(), (int) dotList.get(startPrint+1).getY(),
                       (int) dotList.get(startPrint + 2).getX(), (int) dotList.get(startPrint + 2).getY());
            g.drawLine((int)dotList.get(startPrint+2).getX(), (int)dotList.get(startPrint+2).getY(),
                       (int)dotList.get(startPrint).getX(), (int)dotList.get(startPrint).getY());
        }


    }

    public void moveRectangle(ArrayList<Point> points ){
        dotList = points;
        repaint();
    }

}
