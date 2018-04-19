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
public class SiteEvent extends Event {

    public SiteEvent(Point site) {
        super(site);
    }

    @Override
    public void handleEvent(Collection<Event> eventQueue, BeachLine beachLine, VoronoiDiagram voronoiDiagram) {

        // find arc above site event
        ArcNode arcNode = beachLine.getArcNode(point);
        if (arcNode == null) {
            // corner case happen when this site event with any previous sites event have same y-coordinate
            beachLine.insertFirstArc(point);
            return;
        }

        // if exist circle event corresponding with arc node then delete event from queue
        CircleEvent circleEvent = arcNode.getCircleEvent();
        if (circleEvent != null) {
            eventQueue.remove(circleEvent);
            arcNode.deleteCircleEvent();
        }
        
        // split arc node and replace arc node by sub-tree in beach line ...
        ArcNode newArc = beachLine.splitArc(arcNode, point);

    }

}
