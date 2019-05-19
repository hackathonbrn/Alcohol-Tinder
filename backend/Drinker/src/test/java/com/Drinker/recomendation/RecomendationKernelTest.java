package com.Drinker.recomendation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecomendationKernelTest {

    @Test
    public void getCountOfMatchesTest() {
        ArrayList<Integer> targetList = new ArrayList<>();
        targetList.add(1);
        targetList.add(2);
        targetList.add(7);
        targetList.add(18);
        targetList.add(6);

        ArrayList<Integer> concreteList = new ArrayList<>();
        concreteList.add(6);
        concreteList.add(3);
        concreteList.add(21);
        concreteList.add(7);
        concreteList.add(1);

        RecomendationKernel recomendationKernel = new RecomendationKernel();

        assertEquals(recomendationKernel.getCountOfMatches(targetList, concreteList), 3);
    }

    @Test
    public void transformToListTest() {
        HashMap<Integer, Integer> testMap = new HashMap<>();
        testMap.put(10, 10);
        testMap.put(9, 10);
        testMap.put(8, 10);

        RecomendationKernel recomendationKernel = new RecomendationKernel();
        List<Integer> testList = recomendationKernel.transformMapToList(testMap);

        List<Integer> actualList = new ArrayList<>();
        actualList.add(8);
        actualList.add(9);
        actualList.add(10);

        assertEquals(testList, actualList);
    }
}