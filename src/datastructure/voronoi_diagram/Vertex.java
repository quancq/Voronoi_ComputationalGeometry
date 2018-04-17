/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.voronoi_diagram;

import java.util.Objects;

/**
 *
 * @author quancq
 */
public class Vertex {
    
    private Point location;                 // location is a vertex of Voronoi diagram
    private HalfEdge incidentEdge;          // incidentEdge is an arbitrary half-edge that has location as its origin
    

    public Vertex(Point location) {
        this.location = location;
    }

    public Vertex(Point location, HalfEdge incidentEdge) {
        this.location = location;
        this.incidentEdge = incidentEdge;
    }
    
    public Point getLocation() {
        return location;
    }

    public HalfEdge getIncidentEdge() {
        return incidentEdge;
    }

    public void setIncidentEdge(HalfEdge incidentEdge) {
        this.incidentEdge = incidentEdge;
    }

    @Override
    public String toString() {
        return "Vertex" + location;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + location.hashCode();
        hash = 37 * hash + Objects.hashCode(this.incidentEdge);
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
        return location.equals(other.location) && incidentEdge.equals(other.incidentEdge);
    }

}
