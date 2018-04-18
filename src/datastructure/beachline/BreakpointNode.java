/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.beachline;

import datastructure.voronoi_diagram.HalfEdge;
import datastructure.voronoi_diagram.Point;

/**
 *
 * @author quancq
 */
public class BreakpointNode extends Node{

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

    public Point calcBreakpoint(Point leftSite, Point rightSite, double yCoordinateOfSweepLine){
        throw new UnsupportedOperationException("unsupport method");
    }
    
}
