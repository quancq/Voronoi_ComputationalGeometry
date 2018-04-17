/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.voronoi_diagram;

import algorithm.AlgorithmManager;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class extend DCEL class with additional list of sites, mapping between sites
 * and faces
 *
 * @author quancq
 */
public class VoronoiDiagram extends DCEL {

    private ArrayList<Point> listSites;
    private HashMap<Face, Point> hmFaceToPoint;             // mapping face to site
    private HashMap<Point, Face> hmPointToFace;             // mapping site to face

    public VoronoiDiagram() {
        super();
        listSites = new ArrayList<>();
        hmFaceToPoint = new HashMap<>();
        hmPointToFace = new HashMap<>();
    }

    @Override
    public String toString() {
        String strDCEL = super.toString();
        String strSites = new String(strDCEL);
        strSites += "\n============= Voronoi =============";
        strSites += "\nList of sites:\n";

        for (Point p : listSites) {
            strSites += p.toString();
        }
        strSites += "\n============= Voronoi =============";

        return strSites;
    }

    /**
     * @return site whose region is a largest acreage region
     */
    public Point getSiteOfLargestAcreageRegion() {
        double largestAcreage = Double.MIN_VALUE;
        Point resultSite = null;
        for (Point site : listSites) {
            Face face = hmPointToFace.get(site);
            ArrayList<Vertex> listVerticesOnBoundary = getBoundaryOfFace(face);
            double acreage = AlgorithmManager.calAcreageOfConvexPolygon(
                    listVerticesOnBoundary,
                    AlgorithmManager.Triangulation_DAC
            );
            if (acreage > largestAcreage) {
                largestAcreage = acreage;
                resultSite = site;
            }
        }

        return resultSite;
    }

    /**
     * @return furthest vertex from any other sites in DCEL
     */
    public Vertex getFurthestVertex() {
        Vertex furthestVertex = null;
        double minDistance = Double.MAX_VALUE;

        for (Vertex v : getListVertices()) {
            Face face = v.getIncidentEdge().getIncidentFace();
            Point site = hmFaceToPoint.get(face);
            double distance = AlgorithmManager.calDistance(v, site, AlgorithmManager.Euclidean);
            if (distance < minDistance) {
                minDistance = distance;
                furthestVertex = v;
            }

        }

        return furthestVertex;
    }

}
