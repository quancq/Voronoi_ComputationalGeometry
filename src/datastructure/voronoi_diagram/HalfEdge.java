/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.voronoi_diagram;

import java.io.Serializable;
import java.util.Objects;

/**
 * Half edge is type of record in DCEL
 *
 * @author quancq
 */
public class HalfEdge implements Serializable {

    private static final long serialVersionUID = 1L;

    private Vertex originVertex;                // is origin vertex of this half-edge
    private Face incidentFace;                  // is face which bounded by this half-edge
    private HalfEdge twinEdge;                  // is twin edge of this half-edge
    private HalfEdge nextEdge;                  // is next half-edge of this half-edge on boundary of incidentFace
    private HalfEdge prevEdge;                  // is prev half-edge of this half-edge on boundary of incidentFace

    public HalfEdge() {
    }

    public HalfEdge(Vertex originVertex) {
        this.originVertex = originVertex;
    }

    public Vertex getOriginVertex() {
        return originVertex;
    }

    public Face getIncidentFace() {
        return incidentFace;
    }

    public HalfEdge getTwinEdge() {
        return twinEdge;
    }

    public HalfEdge getNextEdge() {
        return nextEdge;
    }

    public HalfEdge getPrevEdge() {
        return prevEdge;
    }

    public Vertex getDestVertex() {
        // return destination vertex of this half-edge
        return twinEdge.getOriginVertex();
    }

    public void setOriginVertex(Vertex originVertex) {
        this.originVertex = originVertex;
    }

    public void setIncidentFace(Face incidentFace) {
        this.incidentFace = incidentFace;
    }

    public void setTwinEdge(HalfEdge twinEdge) {
        this.twinEdge = twinEdge;
    }

    public void setNextEdge(HalfEdge nextEdge) {
        this.nextEdge = nextEdge;
    }

    public void setPrevEdge(HalfEdge prevEdge) {
        this.prevEdge = prevEdge;
    }

    @Override
    public String toString() {
        return "HE(" + originVertex + ", " + getDestVertex() + ")";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + originVertex.hashCode();
        hash = 19 * hash + getDestVertex().hashCode();
//        hash = 19 * hash + incidentFace.hashCode();
//        hash = 19 * hash + twinEdge.hashCode();
//        hash = 19 * hash + nextEdge.hashCode();
//        hash = 19 * hash + prevEdge.hashCode();
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
        final HalfEdge other = (HalfEdge) obj;
        if (!originVertex.equals(other.originVertex)) {
            return false;
        }
        if (!incidentFace.equals(other.incidentFace)) {
            return false;
        }
        if (!twinEdge.equals(other.twinEdge)) {
            return false;
        }
        if (!nextEdge.equals(other.nextEdge)) {
            return false;
        }
        if (!prevEdge.equals(other.prevEdge)) {
            return false;
        }
        return true;
    }

}
