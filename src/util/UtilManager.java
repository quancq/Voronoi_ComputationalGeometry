/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import datastructure.voronoi_diagram.HalfEdge;
import datastructure.voronoi_diagram.Point;
import datastructure.voronoi_diagram.Vertex;
import datastructure.voronoi_diagram.VoronoiDiagram;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Class implement static utility method
 *
 * @author quancq
 */
public class UtilManager {

    /**
     *
     * @param p1
     * @param p2
     * @return Euclidean distance between p1 and p2
     */
    public static double calcEuclidean(Point p1, Point p2) {
        return sqrt(pow(p2.x - p1.x, 2) + pow(p2.y - p1.y, 2));
    }

    /**
     *
     * @param x
     * @return square of x. This utility method order to code quickly and
     * briefly
     */
    public static double sq(double x) {
        return pow(x, 2);
    }

    /**
     *
     * @param p1 is first point
     * @param p2 is second point
     * @param p3 is third point
     * @return center of circle that through triple point
     */
    public static Point calcCenterOfCircle(Point p1, Point p2, Point p3) {
        double a1 = 2 * (p2.x - p1.x);
        double a2 = 2 * (p3.x - p1.x);
        double b1 = 2 * (p2.y - p1.y);
        double b2 = 2 * (p3.y - p1.y);
        double c1 = (p2.x - p1.x) * (p2.x + p1.x) + (p2.y - p1.y) * (p2.y + p1.y);
        double c2 = (p3.x - p1.x) * (p3.x + p1.x) + (p3.y - p1.y) * (p3.y + p1.y);

        // solve two equations
        // equation1: a1 * x + b1 * y = c1
        // equation2: a2 * x + b2 * y = c2
        double D = a1 * b2 - a2 * b1;
        if (D == 0) {
            // no solution or an infinite number of solutions
            return null;
        }
        // exsit only 1 solution
        double Dx = c1 * b2 - c2 * b1;
        double Dy = a1 * c2 - a2 * c1;

        double x = Dx / D;
        double y = Dy / D;
        Point center = new Point(x, y);

        return center;
    }

    public static VoronoiDiagram randomVD(int numSite, int numEdge, double maxX, double maxY) {
        Random R = new Random();
        VoronoiDiagram VD = new VoronoiDiagram();
        ArrayList<Point> siteList = new ArrayList<>();
        HashSet<HalfEdge> hs = new HashSet<>();
        
        for(int i = 0; i < numSite; ++i){
            siteList.add(randomPoint(maxX, maxY));
        }
        
        for(int i = 0; i < numEdge; ++i){
            HalfEdge halfEdge1 = new HalfEdge(new Vertex(randomPoint(maxX, maxY)));
            HalfEdge halfEdge2 = new HalfEdge(new Vertex(randomPoint(maxX, maxY)));
            halfEdge1.setTwinEdge(halfEdge2);
            halfEdge2.setTwinEdge(halfEdge1);
            
            hs.add(halfEdge1);
            hs.add(halfEdge2);
        }
        
        VD.setHsHalfEdges(hs);
        VD.setListSites(siteList);
        return VD;
    }
    
    public static Point randomPoint(double maxX, double maxY){
        Random R = new Random();
        double x = R.nextDouble() * maxX;
        double y = R.nextDouble() * maxY;
        return new Point(x, y);
    }
}
