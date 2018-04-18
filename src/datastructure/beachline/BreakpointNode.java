/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.beachline;

import datastructure.voronoi_diagram.HalfEdge;
import datastructure.voronoi_diagram.Point;
import static util.UtilManager.sq;
import static java.lang.Math.sqrt;

/**
 *
 * @author quancq
 */
public class BreakpointNode extends Node {

    private Point leftSite;
    private Point rightSite;
    private ArcNode leftNode;
    private ArcNode rightNode;
    private HalfEdge trackedHalfEdge;

    public BreakpointNode(Point leftSite, Point rightSite, ArcNode leftNode, ArcNode rightNode, HalfEdge trackedHalfEdge) {
        this.leftSite = leftSite;
        this.rightSite = rightSite;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.trackedHalfEdge = trackedHalfEdge;
    }

    public Point getLeftSite() {
        return leftSite;
    }

    public Point getRightSite() {
        return rightSite;
    }

    public ArcNode getLeftNode() {
        return leftNode;
    }

    public ArcNode getRightNode() {
        return rightNode;
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

    public void setLeftNode(ArcNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(ArcNode rightNode) {
        this.rightNode = rightNode;
    }

    public void setTrackedHalfEdge(HalfEdge trackedHalfEdge) {
        this.trackedHalfEdge = trackedHalfEdge;
    }

    @Override
    public String toString() {
        return "BreakpointNode{" + "leftSite=" + leftSite + ", rightSite=" + rightSite + '}';
    }

    @Override
    public double getComparableValue() {
        Point p = calcBreakpoint(leftSite, rightSite, BeachLine.coordinateOfSweepLine);
        return p.x;
    }

    public Point calcBreakpoint(Point leftSite, Point rightSite, double yCoordinateOfSweepLine) {
        // transform coordinate
        Point l = new Point(0, leftSite.y - yCoordinateOfSweepLine);
        Point r = new Point(rightSite.x - leftSite.x, rightSite.y - yCoordinateOfSweepLine);

        // compute intersection of parabolas
        // solve two equal distance equations
        // equation 1: sq(xTransform) + sq(l.y) = 2 * l.y * yTransform
        // equation 2: sq(xTransform - r.x) + sq(r.y) = 2 * r.y * yTransform;
        double xTransform, yTransform, x, y;
        if (l.y == r.y) {
            xTransform = r.x / 2.0;
            yTransform = (4 * sq(l.y) + sq(r.x)) / (8 * l.y);
        } else if (l.y == 0.0) {
            xTransform = l.x; // x = 0
            yTransform = (sq(r.x) + sq(r.y)) / (2 * r.y);
        } else if (r.y == 0.0) {
            xTransform = r.x;
            yTransform = (sq(l.y) + sq(r.x)) / (2 * l.y);
        } else {
            xTransform = (l.y * r.x - sqrt(l.y * r.y * (sq(l.y - r.y) + sq(r.x)))) / (l.y - r.y);
            yTransform = (sq(xTransform) + sq(l.y)) / (2 * l.y);
        }

        x = leftSite.x + xTransform;
        y = yCoordinateOfSweepLine + yTransform;

        Point breakpoint = new Point(x, y);
        return breakpoint;
    }

}
