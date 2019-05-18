package com.Drinker.repository;

import com.Drinker.model.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlcoholRepo extends JpaRepository<Alcohol, Long> {
}
