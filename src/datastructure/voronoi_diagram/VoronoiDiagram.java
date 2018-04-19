/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.voronoi_diagram;

import algorithm.AlgorithmManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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

    public ArrayList<Point> getListSites() {
        return listSites;
    }

    public HashMap<Face, Point> getHmFaceToPoint() {
        return hmFaceToPoint;
    }

    public HashMap<Point, Face> getHmPointToFace() {
        return hmPointToFace;
    }

    public void setListSites(ArrayList<Point> listSites) {
        this.listSites = listSites;
    }

    public void setHmFaceToPoint(HashMap<Face, Point> hmFaceToPoint) {
        this.hmFaceToPoint = hmFaceToPoint;
    }

    public void setHmPointToFace(HashMap<Point, Face> hmPointToFace) {
        this.hmPointToFace = hmPointToFace;
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
            double acreage = AlgorithmManager.calcAcreageOfConvexPolygon(
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
            double distance = AlgorithmManager.calcDistance(v, site, AlgorithmManager.Euclidean);
            if (distance < minDistance) {
                minDistance = distance;
                furthestVertex = v;
            }

        }

        return furthestVertex;
    }

    public void insertHalfEdge(HalfEdge halfEdge){
        hsHalfEdges.add(halfEdge);
    }
    
    public ArrayList<Edge> getListEdges(){
        ArrayList<Edge> edgeList = new ArrayList<>();
        HashSet<HalfEdge> hs = new HashSet<>();
        
        for(HalfEdge halfEdge : hsHalfEdges){
            if(hs.contains(halfEdge) || hs.contains(halfEdge.getTwinEdge())){
                continue;
            }
            hs.add(halfEdge);
            edgeList.add(new Edge(halfEdge.getOriginVertex(), halfEdge.getDestVertex()));
        }
        return edgeList;
    }
}
