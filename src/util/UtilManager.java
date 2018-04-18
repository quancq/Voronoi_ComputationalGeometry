/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import datastructure.voronoi_diagram.Point;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Class implement static utility method
 * 
 * @author quancq
 */
public class UtilManager {
    public static double calcEuclidean(Point p1, Point p2){
        return sqrt(pow(p2.x - p1.x, 2) + pow(p2.y - p1.y, 2));
    }
}
