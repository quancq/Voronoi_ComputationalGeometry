/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author tienn
 */
public class PointComponent extends JComponent{
private static class Point {
    final int x;
    final int y;
    final int r;
    final Color color;
    
    public Point(int x, int y, int r, Color color){
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
    }
}

private final LinkedList<Point> points = new LinkedList<Point>();

public void addPoint(int x, int y, int r) {
    addPoint(x,y,r, Color.black);
}

public void addPoint(int x, int y, int r,Color color) {
    points.add(new Point(x, y, r, color));
    setOpaque(true);
    setBackground(new Color(0,0, 255));
    //repaint();
}

public void clearPoint() {
    points.clear();
    repaint();
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Point point : points) {
        g.setColor(point.color);
        g.drawOval(point.x, point.y, point.r, point.r);
    }
}
public static void main(String[] args) {
    JFrame testFrame = new JFrame();
    testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    final LineComponent comp = new LineComponent();
    comp.setPreferredSize(new Dimension(320, 200));
    testFrame.getContentPane().add(comp, BorderLayout.CENTER);
    
    final PointComponent poiComp = new PointComponent();
    testFrame.getContentPane().add(poiComp, BorderLayout.CENTER);
    poiComp.setPreferredSize(new Dimension(320, 200));
   
    
    
    poiComp.addPoint(40,40, 10, Color.BLUE);
    poiComp.addPoint(40,40, 15, Color.BLUE);
    comp.addLine(34, 45, 78, 345, Color.BLACK);
    
    testFrame.repaint();
    testFrame.pack();
    testFrame.setVisible(true);
}
}
