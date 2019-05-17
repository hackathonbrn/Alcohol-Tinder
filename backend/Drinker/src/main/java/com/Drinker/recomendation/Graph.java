package com.Drinker.recomendation;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Edge> edgeList;

    public Graph() {
        edgeList = new ArrayList<>();
    }

    public void addPare(int vertex1, int vertex2) {
        edgeList.add(new Edge(vertex1, vertex2));
    }

    public List<Edge> getEdgeList() {
        return this.edgeList;
    }

    public ArrayList<Integer> getFirstStageNeighbour(int target) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Edge edge: edgeList) {
            if (edge.getUser1() == target) {
                result.add(edge.getUser2());
            }
        }
        return result;
    }
}
