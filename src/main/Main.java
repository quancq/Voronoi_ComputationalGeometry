/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import datastructure.voronoi_diagram.VoronoiDiagram;
import gui.MainGui;
import java.io.File;
import java.nio.file.Paths;
import util.DataIO;
import util.UtilManager;

/**
 *
 * @author quancq
 */
public class Main {

    public static void main(String[] args) {
        int numSite = 10;
        int numEdge = 18;
        double maxX = 30.5;
        double maxY = 50;

        VoronoiDiagram VD1 = UtilManager.randomVD(numSite, numEdge, maxX, maxY);
        System.out.println(" vd1\n " + VD1.getHsHalfEdges());
        String path1 = "src/dataset/input_site-" + numSite + "-edge-" + numEdge + ".txt";
        String path2 = "src/dataset/input_site-" + numSite + "-edge-" + numEdge + ".inp";
        File file1 = new File(path1);
        File file2 = new File(path2);

        // write text to file 1
//        DataIO.writeVoronoiDiagram(file1.getAbsolutePath(), VD1);
        
        // read text from file 1
//        VoronoiDiagram VD2 = DataIO.readVoronoiDiagram(file1.getAbsolutePath());
        
        // write oject to file 2
        DataIO.writeVoronoiDiagramObject(file2.getAbsolutePath(), VD1);
        
        // read object from file 2
        VoronoiDiagram VD3 = DataIO.readVoronoiDiagramObject(file2.getAbsolutePath());
        
        // print
        System.out.println(VD3);
        System.out.println(VD3.getHsHalfEdges());
        
        MainGui.showVoronoiDiagram(VD3);
    }
}
