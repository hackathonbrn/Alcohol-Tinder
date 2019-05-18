package com.Drinker.recomendation;

import java.util.ArrayList;
import java.util.HashMap;

public class RecomendationKernel {
    private Graph graph;

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public RecomendationKernel(Graph graph) {
        this.graph = graph;
    }

    public boolean checkFirstStageInclude(ArrayList<Integer> firstStage, int targetNeighbour) {
        for (int neighbour: firstStage) {
            if (neighbour == targetNeighbour) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> getFirstStageNeighbour(int target) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Edge edge: graph.getEdgeList()) {
            if (edge.getUser1() == target) {
                result.add(edge.getUser2());
            }
        }
        return result;
    }

    public HashMap<Integer, Integer> getRecomendation(int target) {
        ArrayList<Integer> fiirstNeighbours = getFirstStageNeighbour(target);
        // получен список первых соседей, теперь требуется выявить среди них кандидатов

        // мутим мапу для фиксирования количества дринкеров у друзей
        HashMap<Integer, Integer> candidate = new HashMap<Integer, Integer>();
        for (int mainNeighbour: fiirstNeighbours) {
            ArrayList<Integer> secondStage = getFirstStageNeighbour(mainNeighbour);
            for (int secondNeighbour: secondStage) {
                if (secondNeighbour == target || checkFirstStageInclude(fiirstNeighbours, secondNeighbour)) {
                    continue;
                }
                if (candidate.get(secondNeighbour) == null) {
                    candidate.put(secondNeighbour, 1);
                } else {
                    candidate.put(secondNeighbour, candidate.get(secondNeighbour) + 1);
                }
            }
        }
        return candidate;
    }
}
