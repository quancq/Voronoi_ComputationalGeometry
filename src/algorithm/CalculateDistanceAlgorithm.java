/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import datastructure.voronoi_diagram.Point;

/**
 *
 * @author quancq
 */
public class CalculateDistanceAlgorithm {
    public static double calcEuclidean(Point p1, Point p2){
        return sqrt(pow(p2.x - p1.x, 2) + pow(p2.y - p1.y, 2));
    }
}
