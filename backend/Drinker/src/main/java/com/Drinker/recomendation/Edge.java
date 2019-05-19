package com.Drinker.recomendation;

import com.Drinker.model.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Edge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid1")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private User user1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid2")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private User user2;

    private int meeting_count;

    public Edge() {

    }

    public Edge(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        this.meeting_count = 0;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public int getMeetingCount() {
        return meeting_count;
    }

    public void setMeetingCount(int meetingCount) {
        this.meeting_count = meetingCount;
    }

}
