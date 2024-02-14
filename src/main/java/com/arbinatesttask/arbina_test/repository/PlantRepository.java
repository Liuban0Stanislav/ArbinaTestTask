package com.arbinatesttask.arbina_test.repository;

import com.arbinatesttask.arbina_test.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {
//"SELECT p.id, p.name, COUNT(d.id) AS totalProduction FROM plant p JOIN device d ON p.id = d.plantId WHERE d.dateOfConstruction >= CURRENT_DATE - INTERVAL '7 days' GROUP BY p.id, p.name ORDER BY totalProduction DESC LIMIT 5;"
    @Query(name = "SELECT * FROM plant;", nativeQuery = true)
    List<Plant> getTop5PlantsAccordingMadeDevicesLast7Days();
}
