package com.Drinker.recomendation;

public class Edge {
    private int user1;
    private int user2;
    private int meetingCount;
    private double rate;

    public int getUser1() {
        return user1;
    }

    public void setUser1(int user1) {
        this.user1 = user1;
    }

    public int getUser2() {
        return user2;
    }

    public void setUser2(int user2) {
        this.user2 = user2;
    }

    public int getMeetingCount() {
        return meetingCount;
    }

    public void setMeetingCount(int meetingCount) {
        this.meetingCount = meetingCount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void addMeeting(double rate) {
        double oldSum = this.rate * this.meetingCount;
        double newSum = oldSum + rate;
        this.meetingCount++;
        this.rate = newSum / this.meetingCount;
    }
}
