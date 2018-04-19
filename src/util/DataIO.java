/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import datastructure.voronoi_diagram.Edge;
import datastructure.voronoi_diagram.HalfEdge;
import datastructure.voronoi_diagram.Point;
import datastructure.voronoi_diagram.Vertex;
import datastructure.voronoi_diagram.VoronoiDiagram;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author quancq
 */
public class DataIO {

    public static void writeVoronoiDiagram(String path, VoronoiDiagram VD) {
        ArrayList<Point> siteList = VD.getListSites();
        ArrayList<Edge> edgeList = VD.getListEdges();

        try (FileWriter file = new FileWriter(path)) {
            file.write(String.valueOf(siteList.size()));
            for (Point site : siteList) {
                file.write(String.format("\n%.4f %.4f", site.x, site.y));
            }
            file.write("\n" + String.valueOf(edgeList.size()));
            for (Edge edge : edgeList) {
                Point v1 = edge.getV1();
                Point v2 = edge.getV2();
                file.write(String.format("\n%.4f %.4f %.4f %.4f", v1.x, v1.y, v2.x, v2.y));
            }
            System.out.println("\n Write Voronoi diagram to " + path + " done");
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static VoronoiDiagram readVornoiDiagram(String path) {
        VoronoiDiagram VD = new VoronoiDiagram();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int numSite = Integer.parseInt(br.readLine());
            ArrayList<Point> siteList = new ArrayList<>();
            for (int i = 0; i < numSite; ++i) {
                String[] arr = br.readLine().split(" ");
                double x = Double.parseDouble(arr[0]);
                double y = Double.parseDouble(arr[1]);
                siteList.add(new Point(x, y));
            }
            int numEdge = Integer.parseInt(br.readLine());
            HashSet<HalfEdge> hs = new HashSet<>();
            for (int i = 0; i < numEdge; ++i) {
                String[] arr = br.readLine().split(" ");
                double x1 = Double.parseDouble(arr[0]);
                double y1 = Double.parseDouble(arr[1]);
                double x2 = Double.parseDouble(arr[2]);
                double y2 = Double.parseDouble(arr[3]);
                
                Vertex v1 = new Vertex(x1, y1);
                Vertex v2 = new Vertex(x2, y2);
                HalfEdge halfEdge1 = new HalfEdge(v1);
                HalfEdge halfEdge2 = new HalfEdge(v2);
                halfEdge1.setTwinEdge(halfEdge2);
                halfEdge2.setTwinEdge(halfEdge1);
                v1.setIncidentEdge(halfEdge1);
                v2.setIncidentEdge(halfEdge2);
                
                hs.add(halfEdge1);
                hs.add(halfEdge2);
            }

            br.close();
            VD.setListSites(siteList);
            VD.setHsHalfEdges(hs);
            System.out.println("\nRead file " + path + " done");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return VD;
    }
}
