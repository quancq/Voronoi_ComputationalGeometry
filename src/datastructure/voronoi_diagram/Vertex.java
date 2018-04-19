/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.voronoi_diagram;

import java.util.Objects;

/**
 * Class implement vertex of DCEL
 *
 * @author quancq
 */
public class Vertex extends Point {

    private HalfEdge incidentEdge;          // incidentEdge is an arbitrary half-edge that has vertex as its origin

    public Vertex(double x, double y) {
        super(x, y);
    }
    
    public Vertex(Point p){
        super(p);
    }

    public Vertex(double x, double y, HalfEdge incidentEdge) {
        super(x, y);
        this.incidentEdge = incidentEdge;
    }

    public HalfEdge getIncidentEdge() {
        return incidentEdge;
    }

    public void setIncidentEdge(HalfEdge incidentEdge) {
        this.incidentEdge = incidentEdge;
    }

    @Override
    public String toString() {
        return "V" + super.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + super.hashCode();
//        hash = 37 * hash + Objects.hashCode(this.incidentEdge);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vertex other = (Vertex) obj;
        return super.x == other.x
                && super.y == other.y
                && incidentEdge.equals(other.incidentEdge);
    }

}
