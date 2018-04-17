/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.beachline;

import datastructure.voronoi_diagram.HalfEdge;
import datastructure.voronoi_diagram.Point;

/**
 * Class implement inner node in tree map of beach line. Represent breakpoint in
 * beach line
 *
 * @author quancq
 */
public class InnerBeachNode extends BeachNode {

    private Point leftSite;                     // left and right sites whose parabols
    private Point rightSite;                    // intersect at this breakpoint
    private HalfEdge trackedHalfEdge;           // half edge which tracked by this breakpoint

    public InnerBeachNode() {
    }

    public InnerBeachNode(Point leftSite, Point rightSite, HalfEdge trackedHalfEdge) {
        this.leftSite = leftSite;
        this.rightSite = rightSite;
        this.trackedHalfEdge = trackedHalfEdge;
    }

    public Point getLeftSite() {
        return leftSite;
    }

    public Point getRightSite() {
        return rightSite;
    }

    public HalfEdge getTrackedHalfEdge() {
        return trackedHalfEdge;
    }

    public void setLeftSite(Point leftSite) {
        this.leftSite = leftSite;
    }

    public void setRightSite(Point rightSite) {
        this.rightSite = rightSite;
    }

    public void setTrackedHalfEdge(HalfEdge trackedHalfEdge) {
        this.trackedHalfEdge = trackedHalfEdge;
    }

}
