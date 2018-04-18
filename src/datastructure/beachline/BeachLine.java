/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.beachline;

import datastructure.voronoi_diagram.Point;
import java.util.ArrayList;
import java.util.TreeSet;
import util.ComparatorCollection;

/**
 * Class represent beach line binary search tree structure
 *
 * @author quancq
 */
public class BeachLine {

    public static double coordinateOfSweepLine = Double.MAX_VALUE;

    private TreeSet<Node> breakpointBST;
    private ArrayList<ArcNode> arcList;

    public BeachLine() {
        breakpointBST = new TreeSet<>(ComparatorCollection.BEACH_LINE_ASCENDING_X_COMPARATOR);
        arcList = new ArrayList<>();
    }

    public TreeSet<Node> getBreakpointBST() {
        return breakpointBST;
    }

    public ArrayList<ArcNode> getArcList() {
        return arcList;
    }

    /**
     *
     * @param site is query site
     * @return arc node which above query site
     */
    public ArcNode getArcNode(Point site) {
        QuerySiteNode querySite = new QuerySiteNode(site);
        Node resultNode = breakpointBST.floor(querySite);

        ArcNode arc = null;
        if (resultNode != null) {
            arc = ((BreakpointNode) resultNode).getRightNode();
        }

        return arc;
    }

    public ArrayList<ArcNode> getTripleArcs(ArcNode queryArc, String queryPosition) {
        ArrayList<ArcNode> tripleArcs = new ArrayList<>();
        switch (queryPosition) {
            case "middle": {
                tripleArcs.add(queryArc.getLeftArc());
                tripleArcs.add(queryArc);
                tripleArcs.add(queryArc.getRightArc());
                break;
            }
            case "left": {
                ArcNode middleArc = queryArc.getRightArc();
                tripleArcs.add(queryArc);
                tripleArcs.add(middleArc);
                tripleArcs.add(middleArc.getRightArc());
                break;
            }
            case "right": {
                ArcNode middleArc = queryArc.getLeftArc();
                tripleArcs.add(middleArc.getLeftArc());
                tripleArcs.add(middleArc);
                tripleArcs.add(queryArc);
                break;
            }
            default:
                return getTripleArcs(queryArc, "middle");
        }
        return tripleArcs;
    }

    /**
     * 
     * @param middleArc is middle arc in triple arc which need check exist potential circle event
     * @return true if exist potential circle event, else return false
     */
    public boolean isConvergeTripleArcs(ArcNode middleArc){
        BreakpointNode leftBreakPoint = middleArc.getLeftNode();
        BreakpointNode rightBreakPoint = middleArc.getRightNode();
        if(leftBreakPoint == null || rightBreakPoint == null){
            return false;
        }
        Point leftSite = leftBreakPoint.getLeftSite();
        Point middleSite = middleArc.getSite();
        Point rightSite = leftBreakPoint.getRightSite();
        
        // return True if orentation of left-middle-right arcs is positive
        return Point.calcOrentationOfTriplePoints(leftSite, middleSite, rightSite) > 0;
    }
}
