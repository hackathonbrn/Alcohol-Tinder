package com.Drinker.repository;

import com.Drinker.model.Match;
import com.Drinker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepo extends JpaRepository<Match, Integer> {
    Match findByUser2AndUser1(User user2, User user1);
    List<Match> findByUser1AndMutualIsTrue(User user1);
    List<Match> findByUser2AndMutualIsTrue(User user2);
}
