/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import datastructure.voronoi_diagram.Point;
import java.util.List;
import util.UtilManager;

/**
 * Class manage all algorithms of application
 *
 * @author quancq
 */
public class AlgorithmManager {

    // define name of algorithms
    public static final String Triangulation_DAC = "Triangulation_DivdeAndConquer";
    public static final String Fortune_Voronoi = "Fortune Voronoi";
    public static final String Euclidean = "Euclidean";

    public static double calcAcreageOfConvexPolygon(List<? extends Point> listVertices, String nameAlgo) {
        switch (nameAlgo) {
            case Triangulation_DAC:
                return CalculateAcreageOfConvexPolygonAlgorithm.triangulationDivideAndConquer(listVertices);
            default:
                return CalculateAcreageOfConvexPolygonAlgorithm.triangulationDivideAndConquer(listVertices);
        }
    }

    public static double calcDistance(Point p1, Point p2, String metric) {
        switch (metric) {
            case Euclidean:
                return UtilManager.calcEuclidean(p1, p2);
            default:
                return UtilManager.calcEuclidean(p1, p2);
        }
    }
}
