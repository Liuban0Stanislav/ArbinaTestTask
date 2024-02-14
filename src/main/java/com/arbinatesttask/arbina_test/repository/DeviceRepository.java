package com.arbinatesttask.arbina_test.repository;

import com.arbinatesttask.arbina_test.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
