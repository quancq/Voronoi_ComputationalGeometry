/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.voronoi_diagram;

/**
 *
 * @author quancq
 */
public class Vertex {
    
    private Point location;               // location is a vertex of Voronoi diagram
    private Edge incidentEdge;
    

    public Vertex(Point location) {
        this.location = location;
    }

    public Vertex(Point location, Edge incidentEdge) {
        this.location = location;
        this.incidentEdge = incidentEdge;
    }
    
    public Point getLocation() {
        return location;
    }

    public Edge getIncidentEdge() {
        return incidentEdge;
    }
    

    @Override
    public String toString() {
        return location.toString();
    }

    @Override
    public int hashCode() {
        return location.hashCode();
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
        return location.equals(other.location);
    }
    
    
}
