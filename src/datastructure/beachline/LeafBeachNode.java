/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.beachline;

import datastructure.event.CircleEvent;
import datastructure.voronoi_diagram.Point;

/**
 * Class implement leaf node in tree map of beach line. Represent a piece of
 * parabola
 *
 * @author quancq
 */
public class LeafBeachNode extends BeachNode {

    private Point site;
    private CircleEvent circleEvent;

    public LeafBeachNode(Point site) {
        this.site = site;
        this.circleEvent = null;
    }

    public LeafBeachNode(Point site, CircleEvent circleEvent) {
        this.site = site;
        this.circleEvent = circleEvent;
    }

    public Point getSite() {
        return site;
    }

    public CircleEvent getCircleEvent() {
        return circleEvent;
    }

    public void setSite(Point site) {
        this.site = site;
    }

    public void setCircleEvent(CircleEvent circleEvent) {
        this.circleEvent = circleEvent;
    }

    public boolean hasCircleEvent() {
        return circleEvent != null;
    }

}
