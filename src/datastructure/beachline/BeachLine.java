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
import util.UtilManager;

/**
 * Class represent beach line binary search tree structure
 *
 * @author quancq
 */
public class BeachLine {

    public static double coordinateOfSweepLine = Double.MAX_VALUE;

    private TreeSet<Node> breakpointBST;
    private ArrayList<ArcNode> arcList;
    private Double coordinateOfFirstSite;

    public BeachLine() {
        breakpointBST = new TreeSet<>(ComparatorCollection.BEACH_LINE_ASCENDING_X_COMPARATOR);
        arcList = new ArrayList<>();
        coordinateOfFirstSite = null;
    }

    public TreeSet<Node> getBreakpointBST() {
        return breakpointBST;
    }

    public ArrayList<ArcNode> getArcList() {
        return arcList;
    }

    public double getCoordinateOfFirstSite() {
        return coordinateOfFirstSite;
    }

    public void setCoordinateOfFirstSite(double coordinateOfFirstSite) {
        if (this.coordinateOfFirstSite == null) {
            this.coordinateOfFirstSite = coordinateOfFirstSite;
        }
    }

    /**
     *
     * @param site is query site
     * @return arc node which above query site. Return null if none arc node
     */
    public ArcNode getArcNode(Point site) {
        ArcNode arc = null;
        if (arcList.isEmpty()) {
            // this site is first site
            return null;
        }

        if (coordinateOfFirstSite == site.y) {
            // this site with previous sites have same coordinate
            return null;
        }

        QuerySiteNode querySite = new QuerySiteNode(site);
        Node leftCloserestNode = breakpointBST.floor(querySite);

        if (leftCloserestNode != null) {
            arc = ((BreakpointNode) leftCloserestNode).getRightNode();
        } else {
            Node rightCloserestNode = breakpointBST.higher(querySite);
            if (rightCloserestNode != null) {
                arc = ((BreakpointNode) rightCloserestNode).getLeftNode();
            }
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
     * @param middleArc is middle arc in triple arc which need check exist
     * potential circle event
     * @return true if exist potential circle event, else return false
     */
    public boolean isConvergeTripleArcs(ArcNode middleArc) {
        BreakpointNode leftBreakPoint = middleArc.getLeftNode();
        BreakpointNode rightBreakPoint = middleArc.getRightNode();
        if (leftBreakPoint == null || rightBreakPoint == null) {
            return false;
        }
        Point leftSite = leftBreakPoint.getLeftSite();
        Point middleSite = middleArc.getSite();
        Point rightSite = leftBreakPoint.getRightSite();

        // return True if orentation of left-middle-right arcs is positive
        return Point.calcOrentationOfTriplePoints(leftSite, middleSite, rightSite) > 0;
    }

    /**
     *
     * @return True if beach line have no arc nor breakpoint
     */
    public boolean isEmpty() {
        return arcList.isEmpty() && breakpointBST.isEmpty();
    }

    /**
     *
     * @param site is first site or has same y-coordinate with any previous
     * sites
     */
    public void insertFirstArc(Point site) {
        ArcNode arcNode = new ArcNode(site);
        arcList.add(arcNode);
    }

    /**
     *
     * @param splitArc is arc which split by new site
     * @param newSite is site that split arc and create new arcs
     * @return new arc just created corresponding with new site
     */
    public ArcNode splitArc(ArcNode splitArc, Point newSite) {
        // seven node below form seven node from left to right in beach line
        BreakpointNode breakpoint1 = splitArc.getLeftNode();
        ArcNode arc2 = splitArc;
        BreakpointNode breakpoint3 = new BreakpointNode();
        ArcNode arc4 = new ArcNode(newSite);
        BreakpointNode breakpoint5 = new BreakpointNode();
        ArcNode arc6 = new ArcNode(splitArc.getSite());
        BreakpointNode breakpoint7 = splitArc.getRightNode();
        // Note: breakpoint 1 and 7 might not exist

        // update neighbors node of seven node
        // update neighbors of node 1
        // no change about neighbor of node 1
        // update neighbors of node 2
        arc2.setRightNode(breakpoint3);
        arc2.deleteCircleEvent();

        // update neighbors of node 3
        breakpoint3.setLeftNode(arc2);
        breakpoint3.setLeftSite(arc2.getSite());
        breakpoint3.setRightNode(arc4);
        breakpoint3.setRightSite(newSite);

        // update neighbors of node 4
        arc4.setLeftNode(breakpoint3);
        arc4.setRightNode(breakpoint5);

        // update neighbors of node 5
        breakpoint5.setLeftNode(arc4);
        breakpoint5.setLeftSite(newSite);
        breakpoint5.setRightNode(arc6);
        breakpoint5.setRightSite(arc2.getSite());

        // update neighbors of node 6
        arc6.setLeftNode(breakpoint5);
        arc6.setRightNode(breakpoint7);

        // update neighbors of node 7
        if (breakpoint7 != null) {
            breakpoint7.setLeftNode(arc6);
        }

        // insert new nodes into beach line
        breakpointBST.add(breakpoint3);
        breakpointBST.add(breakpoint5);
        arcList.add(arc4);
        arcList.add(arc6);

        return arc4;
    }

    /**
     *
     * @param middleArc is middle arc of triple arc and this arc has circle
     * event
     * @return lowest point of circle through triple site corresponding with
     * triple arc where circle event happen
     */
    public Point getLowestPointOfCircle(ArcNode middleArc) {
        Point p1 = middleArc.getLeftArc().getSite();
        Point p2 = middleArc.getSite();
        Point p3 = middleArc.getRightArc().getSite();

        return UtilManager.calcCenterOfCircle(p1, p2, p3);
    }
}
