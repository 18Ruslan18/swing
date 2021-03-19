package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import static sun.swing.MenuItemLayoutHelper.max;

public class DrawPanel extends JPanel {
    private int width;
    private int height;
    public static boolean tmp1 = true;
    public static boolean tmp2 = true;
    public static boolean tmp3 = false;
    public static int a_temp1;
    public static int a_temp2;
    public static  Point2d a;
    public  static  int b_temp1;
    public static Point2d b;
    public static int c_temp1;
    public static Point2d c;
    public static Point2d d;
    private java.util.List<Point2d> basePoints; // базисные точки
    public static List<line> lines = new ArrayList<>();
    public static int control=0;
    private boolean isBaseLineVisible = true;
    private boolean isCurvePointMarked = true;

    public DrawPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        this.width = width;
        this.height = height;
        if (tmp1) {
            a_temp1 = (int) Random(320);
            a_temp2 = (int) Random(320);
            a = new Point2d(a_temp1, a_temp2);
            b_temp1 = (int) Random(320);
            b = new Point2d(a_temp1, b_temp1);
            c_temp1 = (int) Random(320);
            c = new Point2d(c_temp1, a_temp2);
            d = new Point2d(c_temp1, b_temp1);
        }
        if (tmp2 && control==0) {

            for (int i=0;i<20;i++) {
               Point2d line_a = new Point2d((int) Random(320),(int) Random(320));
               Point2d line_b = new Point2d((int) Random(320),(int) Random(320));
               line line = new line(line_a,line_b);
               lines.add(line);
               control++;
            }

            }
        if (tmp2 && control!=0) {
            for (int i = 0; i < 20; i++) {
                try {

                lines.remove(i);}
            catch (IndexOutOfBoundsException e) {System.out.println("");}
            }
            for (int i = 0; i < 20; i++) {
                Point2d line_a = new Point2d((int) Random(320), (int) Random(320));
                Point2d line_b = new Point2d((int) Random(320), (int) Random(320));
                line line = new line(line_a, line_b);
                lines.add(line);
            }
        }
        basePoints = new ArrayList<Point2d>();
    }
    @Override
    public void paint(Graphics g) {

        // заливка фона
        g.setColor(Color.pink);
        g.fillRect(0, 0, width, height);

        // смещение цетра координатных осей на центр панели
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform offsetToCenter = new AffineTransform();
        offsetToCenter.translate(width / 2, height / 2);
        g2d.transform(offsetToCenter);
        Point2d s = new Point2d(350,350);
        Point2d t = new Point2d(400,400);
        //g.drawLine((int)Random(350),0,400,400);
        if (tmp1){
            g.setColor(Color.BLACK);
            repaint();
            Window(g);
        }
        else { g.setColor(Color.BLACK); Window(g); }
        if (tmp2){
            g.setColor(Color.magenta);
            repaint();
            drawline(g);
        } else {
            g.setColor(Color.magenta);
            drawline(g);
        }
        if (tmp3)  {
            repaint();
            LineControl(g);
        }
        //for (int i =0; i<100; i++) System.out.println((int)Random(350));
    }
    private void drawLine(Graphics g, Point2d p1, Point2d p2) {
        int x1 = (int) p1.getX();
        int y1 = (int) p1.getY();
        int x2 = (int) p2.getX();
        int y2 = (int) p2.getY();

        g.drawLine(x1, y1, x2, y2);
    }
    public void Window(Graphics g){

        drawLine(g,a,b);
        drawLine(g,a,c);
        drawLine(g,b,d);
        drawLine(g,c,d);
    }
    public void drawline(Graphics g){
        for (int i=0;i<20;i++)
        {
            int x1 = (int) lines.get(i).getA().getX();
            int y1 = (int) lines.get(i).getA().getY();
            int x2 = (int) lines.get(i).getB().getX();
            int y2 = (int) lines.get(i).getB().getY();
            g.drawLine(x1, y1, x2, y2);
    }}
    public void LineControl(Graphics g){
        int x1=Math.min(a_temp1,c_temp1);
        int x2 = Math.max(a_temp1,c_temp1);
        int y1 = Math.min(a_temp2,b_temp1);
        int y2 = Math.max(a_temp2,b_temp1);
        for (int i=0;i<20;i++)
        {
            int xn = (int) lines.get(i).getA().getX();
            int yn = (int) lines.get(i).getA().getY();
            int xk = (int) lines.get(i).getB().getX();
            int yk = (int) lines.get(i).getB().getY();
            if (((xn<x1 && xk<x1) || (xn>x2 && xk>x2) || (yn<y1 && yk<y1) || (yn>y2 && yk>y2))) {
                g.setColor(Color.RED);
                g.drawLine(xn, yn, xk, yk);
            }
            else if (((xn<=x1 || xn>=x2) || (xk<=x1 || xk>=x2) || (yn<=y1 || yn>=y2) || (yk<=y1 || yk>=y2))){
                g.setColor(Color.BLUE);
                g.drawLine(xn, yn, xk, yk);
            } else {
                g.setColor(Color.cyan);
                g.drawLine(xn, yn, xk, yk);
            }
        }
    }
    /*public void ReWindow(Graphics g){
        g.setColor(Color.pink);
        drawLine(g,a,b);
        drawLine(g,a,c);
        drawLine(g,b,d);
        drawLine(g,c,d);
        a_temp1 =(int)Random(320);
        a_temp2 =(int)Random(320);
        a = new Point2d(a_temp1, a_temp2);
        b_temp1 = (int)Random(320);
        b = new Point2d(a_temp1,b_temp1);
        c_temp1 = (int)Random(320);
        c = new Point2d(c_temp1, a_temp2);
        d = new Point2d(c_temp1,b_temp1);
        g.setColor(Color.BLACK);
        Window(g);
    }*/
    public static long Random(double max) {
        int sign = (Math.random() > 0.5) ? -1 : 1;
        return (long)(sign * (Math.random() * max));
    }
}
