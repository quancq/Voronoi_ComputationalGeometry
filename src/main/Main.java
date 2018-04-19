/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import datastructure.voronoi_diagram.VoronoiDiagram;
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
        int numEdge = 15;
        double maxX = 30.5;
        double maxY = 50;

        VoronoiDiagram VD = UtilManager.randomVD(numSite, numEdge, maxX, maxY);
        File file = new File("src/dataset/input_site-" + numSite + "-edge-" + numEdge + ".txt");

        DataIO.writeVoronoiDiagram(file.getAbsolutePath(), VD);
    }
}
