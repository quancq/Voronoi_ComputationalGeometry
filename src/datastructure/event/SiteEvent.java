/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.event;

import datastructure.beachline.ArcNode;
import datastructure.beachline.BeachLine;
import datastructure.beachline.BreakpointNode;
import datastructure.voronoi_diagram.HalfEdge;
import datastructure.voronoi_diagram.Point;
import datastructure.voronoi_diagram.VoronoiDiagram;
import java.util.Collection;

/**
 *
 * @author quancq
 */
public class SiteEvent extends Event {

    public SiteEvent(Point site) {
        super(site);
    }

    @Override
    public String toString() {
        return "SiteEvent{" + point + '}';
    }
    
    @Override
    public void handleEvent(Collection<Event> eventQueue, BeachLine beachLine, VoronoiDiagram voronoiDiagram) {

        // find arc above site event
        ArcNode splitArc = beachLine.getArcNode(point);
        if (splitArc == null) {
            // corner case happen when this site event with any previous sites event have same y-coordinate
            beachLine.insertFirstArc(point);
            return;
        }

        // if exist circle event corresponding with arc node then delete event from queue
        CircleEvent circleEvent = splitArc.getCircleEvent();
        if (circleEvent != null) {
            eventQueue.remove(circleEvent);
            splitArc.deleteCircleEvent();
        }

        // split arc node and replace arc node by sub-tree in beach line ...
        ArcNode newArc = beachLine.splitArc(splitArc, point);

        // insert two new half-edge records into Voronoi diagram
        HalfEdge halfEdge1 = new HalfEdge();
        HalfEdge halfEdge2 = new HalfEdge();
        halfEdge1.setTwinEdge(halfEdge2);
        halfEdge2.setTwinEdge(halfEdge1);
        voronoiDiagram.insertHalfEdge(halfEdge1);
        voronoiDiagram.insertHalfEdge(halfEdge2);

        // mapping with two new breakpoints
        BreakpointNode breakpoint1 = newArc.getLeftNode();
        breakpoint1.setTrackedHalfEdge(halfEdge1);
        BreakpointNode breakpoint2 = newArc.getRightNode();
        breakpoint2.setTrackedHalfEdge(halfEdge2);

        // note: only 1 triple arc disappear which has middle arc is split arc
        // insert new circle events if new triple arc converge
        ArcNode leftArc = newArc.getLeftArc();
        if (beachLine.isConvergeTripleArcs(leftArc)) {
            Point lowestPoint1 = beachLine.getLowestPointOfCircle(leftArc);
            CircleEvent circleEvent1 = new CircleEvent(lowestPoint1, leftArc);
            leftArc.setCircleEvent(circleEvent1);
            eventQueue.add(circleEvent1);
        }
        ArcNode rightArc = newArc.getRightArc();
        if(beachLine.isConvergeTripleArcs(rightArc)){
            Point lowestPoint2 = beachLine.getLowestPointOfCircle(rightArc);
            CircleEvent circleEvent2 = new CircleEvent(lowestPoint2, rightArc);
            rightArc.setCircleEvent(circleEvent2);
            eventQueue.add(circleEvent2);
        }
        
        System.out.println("\nHandle Site event done. Event: " + toString());
    }

}
