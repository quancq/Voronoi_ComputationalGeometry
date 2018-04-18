/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.beachline;

import datastructure.voronoi_diagram.Point;

/**
 *
 * @author quancq
 */
public class QuerySiteNode extends Node {

    private Point site;

    public QuerySiteNode(Point site) {
        this.site = site;
    }

    public Point getSite() {
        return site;
    }

    public void setSite(Point site) {
        this.site = site;
    }
    
    @Override
    public double getComparableValue(){
        return site.x;
    }

}
