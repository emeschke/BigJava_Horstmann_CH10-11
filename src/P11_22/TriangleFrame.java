package P11_22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 10/31/13
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class TriangleFrame extends JFrame {
    //This class has a mouse listener that records each mouse click into an arrayList of points.  It then passes
    //the arrayList to a component function that draws.
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 400;
    ArrayList<Point> pointsAList = new ArrayList<Point>();
    private TriangleComponent scene;

    class MousePressListener implements MouseListener{

        public void mousePressed(MouseEvent event){
            Point onePoint = new Point(event.getX(),event.getY());
            pointsAList.add(onePoint);
            scene.moveRectangle(pointsAList);
            //for (int i = 0; i <pointsAList.size() ; i++) {
            //    System.out.println(pointsAList.get(i));
            //}
        }

        public void mouseClicked(MouseEvent e){};
        public void mouseReleased(MouseEvent e){};
        public void mouseEntered(MouseEvent e){};
        public void mouseExited(MouseEvent e){};
    }

    public TriangleFrame(){
        scene = new TriangleComponent();
        add(scene);

        MouseListener listener = new MousePressListener();
        scene.addMouseListener(listener);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

}
