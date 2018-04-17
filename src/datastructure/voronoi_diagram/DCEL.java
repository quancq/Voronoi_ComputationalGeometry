/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure.voronoi_diagram;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * DCEL (doubly connected edge list) is a popular data structure for
 * representation of planar subdivision problem
 *
 * @author quancq
 */
public class DCEL {

    protected HashSet<Vertex> hsVertices;
    protected HashSet<HalfEdge> hsHalfEdges;
    protected HashSet<Face> hsFaces;

    public DCEL() {
        this.hsVertices = new HashSet<>();
        this.hsHalfEdges = new HashSet<>();
        this.hsFaces = new HashSet<>();
    }

    public DCEL(HashSet<Vertex> hsVertices, HashSet<HalfEdge> hsHalfEdges, HashSet<Face> hsFaces) {
        this.hsVertices = hsVertices;
        this.hsHalfEdges = hsHalfEdges;
        this.hsFaces = hsFaces;
    }

    public HashSet<Vertex> getHsVertices() {
        return hsVertices;
    }

    public ArrayList<Vertex> getListVertices() {
        return new ArrayList<>(hsVertices);
    }

    public HashSet<HalfEdge> getHsHalfEdges() {
        return hsHalfEdges;
    }

    public ArrayList<HalfEdge> getListHalfEdges() {
        return new ArrayList<>(hsHalfEdges);
    }

    public HashSet<Face> getHsFaces() {
        return hsFaces;
    }

    public ArrayList<Face> getListFaces() {
        return new ArrayList<>(hsFaces);
    }

    public void setHsVertices(HashSet<Vertex> hsVertices) {
        this.hsVertices = hsVertices;
    }

    public void setHsHalfEdges(HashSet<HalfEdge> hsHalfEdges) {
        this.hsHalfEdges = hsHalfEdges;
    }

    public void setHsFaces(HashSet<Face> hsFaces) {
        this.hsFaces = hsFaces;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("\n============= DCEL =============");

        strBuilder.append("\nList Vertex:\n");
        hsVertices.forEach((v) -> {
            strBuilder.append(v);
        });

        strBuilder.append("\nList Edge:\n");
        hsHalfEdges.forEach((e) -> {
            strBuilder.append(e);
        });

        strBuilder.append("\nList Face:\n");
        hsFaces.forEach((f) -> {
            strBuilder.append(f);
        });

        strBuilder.append("\n============= DCEL =============");
        return strBuilder.toString();
    }

    /**
     * @param face which needed to find boundary
     * @return list of vertices counter clockwise on boundary of face
     */
    public ArrayList<Vertex> getBoundaryOfFace(Face face) {
        HalfEdge halfEdge = face.getOuterComponent();
        Vertex startVertex = halfEdge.getOriginVertex();
        Vertex currVertex = startVertex;

        ArrayList<Vertex> listVerticesOnBoundary = new ArrayList<>();

        do {
            listVerticesOnBoundary.add(currVertex);
            halfEdge = halfEdge.getNextEdge();
            currVertex = halfEdge.getOriginVertex();

        } while (!currVertex.equals(startVertex));

        return listVerticesOnBoundary;
    }

}
