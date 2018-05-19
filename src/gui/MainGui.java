/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import datastructure.voronoi_diagram.Edge;
import datastructure.voronoi_diagram.Point;
import datastructure.voronoi_diagram.VoronoiDiagram;
import java.io.File;
import java.util.ArrayList;
import util.DataIO;
import util.UtilManager;

/**
 *
 * @author quancq
 */
public class MainGui {
	public static final int RADIUSPOINT = 3;  //bán kinh của điểm cần vẽ
    public static final int MAGNIFY = 10;//Mức độ phóng đại của hình ảnh được vẽ
    
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
    
    public static void showVoronoiDiagram(VoronoiDiagram VD){
        System.out.println("\n============= Show GUI =============");
        ArrayList<Point> siteList = VD.getListSites();
        ArrayList<Edge> edgeList = VD.getListEdges();
        
        // loop through two above list to show GUI
        JFrame testFrame = new JFrame();
        testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        final LineAndPointComponent comp = new LineAndPointComponent();
        comp.setPreferredSize(new Dimension(500, 500));
        testFrame.getContentPane().add(comp, BorderLayout.CENTER);
        JPanel buttonsPanel = new JPanel();
        for(Point pnt : siteList){
            comp.addPoint(MAGNIFY * (int)pnt.x, MAGNIFY * (int)pnt.y, RADIUSPOINT);
        }
        
        for(Edge edg: edgeList){
            comp.addLine(MAGNIFY*(int)edg.getV1().x,MAGNIFY * (int)edg.getV1().y,
                    MAGNIFY * (int)edg.getV2().x, MAGNIFY *(int)edg.getV2().y);
        }
        testFrame.pack();
        testFrame.setVisible(true);
    
        System.out.println(siteList);
        System.out.println(edgeList);
        
    }
	
}
