/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.event;

import datastructure.beachline.BeachLine;
import datastructure.voronoi_diagram.Point;
import datastructure.voronoi_diagram.VoronoiDiagram;
import java.util.Collection;

/**
 *
 * @author quancq
 */
public abstract class Event {
    private final Point point;

    public Event(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return "Event{" + "point=" + point + '}';
    }
    
    public abstract void handleEvent(Collection<Event> eventQueue, BeachLine beachLine, VoronoiDiagram voronoiDiagram);
}
