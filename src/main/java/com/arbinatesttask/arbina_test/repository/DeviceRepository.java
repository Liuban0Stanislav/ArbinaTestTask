package com.arbinatesttask.arbina_test.repository;

import com.arbinatesttask.arbina_test.model.Device;
import com.arbinatesttask.arbina_test.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
    List<Device> getDevicesByFirstNameOfShiftHead(String firstNameOfShiftHead);
    List<Device> getDevicesByPlantId(Plant plantId);
}
