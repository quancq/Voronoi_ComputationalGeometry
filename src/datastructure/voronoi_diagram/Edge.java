/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.voronoi_diagram;

import java.io.Serializable;

/**
 *
 * @author quancq
 */
public class Edge implements Serializable {

    private static final long serialVersionUID = 1L;

    private Point v1;
    private Point v2;

    public Edge(Point v1, Point v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Point getV1() {
        return v1;
    }

    public Point getV2() {
        return v2;
    }

    public void setV1(Point v1) {
        this.v1 = v1;
    }

    public void setV2(Point v2) {
        this.v2 = v2;
    }

    @Override
    public String toString() {
        return "E(" + v1 + ", " + v2 + ")";
    }

}
