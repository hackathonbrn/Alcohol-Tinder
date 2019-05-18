package com.Drinker.repository;

import com.Drinker.model.Match;
import com.Drinker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepo extends JpaRepository<Match, Long> {
    Match findByUser2AndUser1(User user2, User user1);
}
