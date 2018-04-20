/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.voronoi_diagram;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Face is a region on planar subdivision
 *
 * @author quancq
 */
public class Face implements Serializable {

    private static final long serialVersionUID = 1L;

    // outerComponent is an arbitrary half-edge on outer boundary of this face
    private HalfEdge outerComponent;
    // innerComponents is a list of half-edges which each is an arbitrary half-edge on one hole of this face
    private ArrayList<HalfEdge> innerComponents;

    public Face(HalfEdge outerComponent) {
        this.outerComponent = outerComponent;
        this.innerComponents = new ArrayList<>();
    }

    public Face(HalfEdge outerComponent, ArrayList<HalfEdge> innerComponents) {
        this.outerComponent = outerComponent;
        this.innerComponents = innerComponents;
    }

    public HalfEdge getOuterComponent() {
        return outerComponent;
    }

    public ArrayList<HalfEdge> getInnerComponents() {
        return innerComponents;
    }

    public void setOuterComponent(HalfEdge outerComponent) {
        this.outerComponent = outerComponent;
    }

    public void setInnerComponents(ArrayList<HalfEdge> innerComponents) {
        this.innerComponents = innerComponents;
    }

    @Override
    public String toString() {
        return "Face{" + "outerComponent=" + outerComponent + ", innerComponents=" + innerComponents + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + outerComponent.hashCode();
//        for(HalfEdge halfEdge : innerComponents){
//            hash = 23 * hash + halfEdge.hashCode();
//        }

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
        final Face other = (Face) obj;
        if (!outerComponent.equals(other.outerComponent)) {
            return false;
        }
        if (!innerComponents.equals(other.innerComponents)) {
            return false;
        }
        return true;
    }

}
