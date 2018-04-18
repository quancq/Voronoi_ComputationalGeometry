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
                tripleArcs.add(queryArc.getLeftNode().getLeftNode());
                tripleArcs.add(queryArc);
                tripleArcs.add(queryArc.getRightNode().getRightNode());
                break;
            }
            case "left": {
                ArcNode middleArc = queryArc.getRightNode().getRightNode();
                tripleArcs.add(queryArc);
                tripleArcs.add(middleArc);
                tripleArcs.add(middleArc.getRightNode().getRightNode());
                break;
            }
            case "right": {
                ArcNode middleArc = queryArc.getLeftNode().getLeftNode();
                tripleArcs.add(queryArc);
                tripleArcs.add(middleArc);
                tripleArcs.add(middleArc.getLeftNode().getLeftNode());
                break;
            }
            default:
                return getTripleArcs(queryArc, "middle");
        }
        return tripleArcs;
    }

}
