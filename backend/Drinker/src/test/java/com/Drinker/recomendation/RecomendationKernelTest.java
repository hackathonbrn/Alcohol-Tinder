package com.Drinker.recomendation;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

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
}