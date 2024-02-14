package com.arbinatesttask.arbina_test.repository;

import com.arbinatesttask.arbina_test.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {
    @Query(value = "SELECT p.id, p.name, p.address, p.date_of_construction, p.date_of_db_addition FROM plant p JOIN ( SELECT plant_id, COUNT(*) AS device_count FROM device WHERE assembling_date >= CURRENT_DATE - 7 GROUP BY plant_id ORDER BY device_count DESC LIMIT 5) AS counted_devices ON p.id = counted_devices.plant_id;", nativeQuery = true)
    List<Plant> getTop5PlantsAccordingMadeDevicesLast7Days();
}
