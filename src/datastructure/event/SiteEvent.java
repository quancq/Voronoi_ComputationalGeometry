/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.event;

import datastructure.voronoi_diagram.Point;

/**
 *
 * @author quancq
 */
public class SiteEvent extends Event {

    private Point site;

    public SiteEvent(Point site) {
        this.site = site;
    }

    public Point getSite() {
        return site;
    }

    public void setSite(Point site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return "SiteEvent{" + "site=" + site + '}';
    }

}
