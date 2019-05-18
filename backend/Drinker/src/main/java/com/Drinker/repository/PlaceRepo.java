package com.Drinker.repository;

import com.Drinker.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepo extends JpaRepository<Place, Long> {
}
