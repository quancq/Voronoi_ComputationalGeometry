/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.event;

import datastructure.beachline.ArcNode;
import datastructure.beachline.BeachLine;
import datastructure.voronoi_diagram.Point;
import datastructure.voronoi_diagram.VoronoiDiagram;
import java.util.Collection;

/**
 *
 * @author quancq
 */
public class CircleEvent extends Event {

//    private Point lowestPointOfCircle;              // lowest point where 2 breakpoints converge
    private ArcNode arcNode;                        // disappearing arc when circle event happen

    public CircleEvent(Point lowestPointOfCircle, ArcNode arcNode) {
        super(lowestPointOfCircle);
//        this.lowestPointOfCircle = lowestPointOfCircle;
        this.arcNode = arcNode;
    }

    public ArcNode getArcNode() {
        return arcNode;
    }

    public void setArcNode(ArcNode arcNode) {
        this.arcNode = arcNode;
    }

    @Override
    public String toString() {
        return "CircleEvent{Point=" + point + ", arcNode=" + arcNode + '}';
    }

    @Override
    public void handleEvent(Collection<Event> eventQueue, BeachLine beachLine, VoronoiDiagram voronoiDiagram) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
