/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.event;

import datastructure.beachline.ArcNode;
import datastructure.voronoi_diagram.Point;

/**
 *
 * @author quancq
 */
public class CircleEvent extends Event {

    private Point lowestPointOfCircle;              // lowest point where 2 breakpoints converge
    private ArcNode arcNode;                        // disappearing arc when circle event happen

    public CircleEvent(Point lowestPointOfCircle, ArcNode arcNode) {
        this.lowestPointOfCircle = lowestPointOfCircle;
        this.arcNode = arcNode;
    }

    public Point getLowestPointOfCircle() {
        return lowestPointOfCircle;
    }

    public ArcNode getArcNode() {
        return arcNode;
    }

    public void setLowestPointOfCircle(Point lowestPointOfCircle) {
        this.lowestPointOfCircle = lowestPointOfCircle;
    }

    public void setArcNode(ArcNode arcNode) {
        this.arcNode = arcNode;
    }

    @Override
    public String toString() {
        return "CircleEvent{" + "lowestPointOfCircle=" + lowestPointOfCircle + ", arcNode=" + arcNode + '}';
    }

}
