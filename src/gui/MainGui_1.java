/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import datastructure.voronoi_diagram.Edge;
import datastructure.voronoi_diagram.Point;
import datastructure.voronoi_diagram.VoronoiDiagram;
import java.util.ArrayList;

/**
 *
 * @author quancq
 */
public class MainGui_1 {
    public static void showVoronoiDiagram(VoronoiDiagram VD){
        System.out.println("\n============= Show GUI =============");
        ArrayList<Point> siteList = VD.getListSites();
        ArrayList<Edge> edgeList = VD.getListEdges();
        
        // loop through two above list to show GUI
        
        System.out.println(siteList);
        System.out.println(edgeList);
        
    }
    
    public void drawPoint(float x, float y)
    {
        
    }
}
