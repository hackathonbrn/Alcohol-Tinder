package com.Drinker.recomendation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RecomendationTest {
    @Test
    public void getFirstCircleTest() {
        Graph graph = new Graph();
    }

    @Test
    public void testAdding() {
        Graph graph = new Graph();
        graph.addPare(2, 3);
        graph.addPare(2, 4);
        graph.addPare(2, 1);
        graph.addPare(2, 5);
        ArrayList<Integer> expected = graph.getFirstStageNeighbour(2);
        ArrayList<Integer> actual = new ArrayList<>();
        actual.add(3);
        actual.add(4);
        actual.add(1);
        actual.add(5);
        assertArrayEquals(actual.toArray(), expected.toArray());
    }
}
