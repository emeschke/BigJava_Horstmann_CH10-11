package test;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: E
 * Date: 10/29/13
 * Time: 11:51 PM
 * To change this template use File | Settings | File Templates.
 */
class test
    {
        public static void main(String[] args)
        {
            JFrame frame = new JFrame("test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.getContentPane().add(new MyPanel());
            frame.pack();
            frame.setVisible(true);
        }
    }
    class MyPanel extends JPanel
    {

        MyPanel()
        {
            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(250,250));
        }

        public void paintComponent(Graphics page)
        {
            super.paintComponent(page);
            drawCircle(page,50,50,20);
        }

        private void drawCircle(Graphics g, int x, int y, int radius) {
            g.fillOval(x-radius, y-radius, radius*2, radius*2);
        }
    }

