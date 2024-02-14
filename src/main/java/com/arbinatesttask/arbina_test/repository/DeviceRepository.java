package com.arbinatesttask.arbina_test.repository;

import com.arbinatesttask.arbina_test.dto.Last30DaysDTO;
import com.arbinatesttask.arbina_test.dto.Last5DavDTO;
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
    @Query(value = "SELECT d.name AS deviceName, d.assembling_date AS assemblingDate, d.first_name_of_shift_head AS firstNameOfShiftHead, d.last_name_of_shift_head AS lastNameOfShiftHead, p.name AS plantName FROM device d JOIN plant p ON d.plant_id = p.id ORDER BY d.assembling_date DESC LIMIT 5;", nativeQuery = true)
    List<Last5DavDTO> getLast5DevicesIncludingPlantsInformation();
    @Query(value = "SELECT d.name AS deviceName, d.assembling_date AS assemblingDate, d.first_name_of_shift_head AS firstNameOfShiftHead, d.last_name_of_shift_head AS lastNameOfShiftHead, p.name AS plantName FROM device d JOIN plant p ON d.plant_id = p.id WHERE d.assembling_date >= CURRENT_DATE - 30 ORDER BY d.assembling_date DESC;", nativeQuery = true)
    List<Last30DaysDTO> getDevicesMadeLast30Days();
}
