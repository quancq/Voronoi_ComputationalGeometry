/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.beachline;

import datastructure.event.CircleEvent;

/**
 *
 * @author quancq
 */
public class ArcNode {

    private BreakpointNode leftNode;
    private BreakpointNode rightNode;
    private CircleEvent circleEvent;

    public ArcNode(BreakpointNode leftNode, BreakpointNode rightNode, CircleEvent circleEvent) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.circleEvent = circleEvent;
    }

    public BreakpointNode getLeftNode() {
        return leftNode;
    }

    public BreakpointNode getRightNode() {
        return rightNode;
    }

    public CircleEvent getCircleEvent() {
        return circleEvent;
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

    @Override
    public String toString() {
        return "ArcNode{" + "leftNode=" + leftNode + ", rightNode=" + rightNode + ", circleEvent=" + circleEvent + '}';
    }

    
}
