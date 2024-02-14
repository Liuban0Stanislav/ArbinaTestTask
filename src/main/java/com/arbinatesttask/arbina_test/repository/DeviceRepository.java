package com.arbinatesttask.arbina_test.repository;

import com.arbinatesttask.arbina_test.dto.Last5DevDTO;
import com.arbinatesttask.arbina_test.model.Device;
import com.arbinatesttask.arbina_test.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    List<Device> getDevicesByFirstNameOfShiftHead(String firstNameOfShiftHead);
    List<Device> getDevicesByPlantId(Plant plantId);
    @Query(value = "SELECT d.name AS device_name, d.assembling_date, d.first_name_of_shift_head, d.last_name_of_shift_head, p.name AS plant_name FROM device d JOIN plant p ON d.plant_id = p.id ORDER BY d.assembling_date DESC LIMIT 5;", nativeQuery = true)
    List<Last5DevDTO> getLast5DevicesIncludingPlantsInformation();
}
