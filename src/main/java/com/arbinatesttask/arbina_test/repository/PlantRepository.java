package com.arbinatesttask.arbina_test.repository;

import com.arbinatesttask.arbina_test.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {
}
