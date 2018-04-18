/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.beachline;

import datastructure.event.CircleEvent;
import datastructure.voronoi_diagram.Point;

/**
 *
 * @author quancq
 */
public class ArcNode {

    private BreakpointNode leftNode;
    private BreakpointNode rightNode;
    private CircleEvent circleEvent;
    private Point site;

    public ArcNode(BreakpointNode leftNode, BreakpointNode rightNode, CircleEvent circleEvent, Point site) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.circleEvent = circleEvent;
        this.site = site;
    }

    public BreakpointNode getLeftNode() {
        return leftNode;
    }

    public BreakpointNode getRightNode() {
        return rightNode;
    }

    public ArcNode getLeftArc() {
        return leftNode.getLeftNode();
    }

    public ArcNode getRightArc() {
        return rightNode.getRightNode();
    }

    public CircleEvent getCircleEvent() {
        return circleEvent;
    }

    public Point getSite() {
        return site;
    }

    public void setLeftNode(BreakpointNode leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(BreakpointNode rightNode) {
        this.rightNode = rightNode;
    }

    public void setCircleEvent(CircleEvent circleEvent) {
        this.circleEvent = circleEvent;
    }

    public void setSite(Point site) {
        this.site = site;
    }
    
    public void deleteCircleEvent(){
        this.circleEvent = null;
    }

    @Override
    public String toString() {
        return "ArcNode{" + "leftNode=" + leftNode + ", rightNode=" + rightNode + ", circleEvent=" + circleEvent + ", site=" + site + '}';
    }

}
