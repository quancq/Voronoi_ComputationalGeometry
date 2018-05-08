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
import javax.swing.JPanel;

/**
 *
 * @author tienn
 */
public class LineAndPointComponent extends JComponent{
private static class Line{
    final int x1; 
    final int y1;
    final int x2;
    final int y2;   
    final Color color;

    public Line(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }               
}
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
private final LinkedList<Line> lines = new LinkedList<Line>();

public void addLine(int x1, int x2, int x3, int x4) {
    addLine(x1, x2, x3, x4, Color.black);
}
public void addPoint(int x, int y, int r) {
    addPoint(x,y,r, Color.black);
}

public void addLine(int x1, int x2, int x3, int x4, Color color) {
    lines.add(new Line(x1,x2,x3,x4, color));
    //repaint();
}
public void addPoint(int x, int y, int r,Color color) {
    points.add(new Point(x, y, r, color));
    setOpaque(true);
    setBackground(new Color(0,0, 255));
    //repaint();
}
public void clearLines() {
    lines.clear();
    repaint();
}
public void clearPoint() {
    points.clear();
    repaint();
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Line line : lines) {
        g.setColor(line.color);
        g.drawLine(line.x1, line.y1, line.x2, line.y2);
    }
    for (Point point : points) {
        g.setColor(point.color);
        g.drawOval(point.x, point.y, point.r, point.r);
    }
}

public static void main(String[] args) {
    JFrame testFrame = new JFrame();
    testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    final LineAndPointComponent comp = new LineAndPointComponent();
    comp.setPreferredSize(new Dimension(1000, 700));
    testFrame.getContentPane().add(comp, BorderLayout.CENTER);
    JPanel buttonsPanel = new JPanel();
    comp.addLine(34, 45, 78, 345, Color.BLACK);
    comp.addPoint(30, 30, 20,Color.BLUE);
    testFrame.pack();
    testFrame.setVisible(true);
}
}
