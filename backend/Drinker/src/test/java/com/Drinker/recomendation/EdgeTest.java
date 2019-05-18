package com.Drinker.recomendation;

import org.junit.Test;

import static org.junit.Assert.*;

public class EdgeTest {

    @Test
    public void addMeetingTest() {
        Edge edge = new Edge();
        edge.setUser1(1);
        edge.setUser2(2);
        edge.setMeetingCount(5);
        edge.setRate(10);
        edge.addMeeting(4);
        assertEquals(edge.getRate(), 9, 0.01);
    }
}