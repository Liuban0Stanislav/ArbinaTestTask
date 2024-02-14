package com.arbinatesttask.arbina_test.service.implementation;

import com.arbinatesttask.arbina_test.dto.Last30DaysDTO;
import com.arbinatesttask.arbina_test.dto.Last5DavDTO;
import com.arbinatesttask.arbina_test.model.Plant;
import com.arbinatesttask.arbina_test.repository.DeviceRepository;
import com.arbinatesttask.arbina_test.repository.PlantRepository;
import com.arbinatesttask.arbina_test.service.AnalyticalOperationsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.arbinatesttask.arbina_test.service.implementation.MethodNameServiceImpl.getCurrentClassName;
import static com.arbinatesttask.arbina_test.service.implementation.MethodNameServiceImpl.getCurrentMethodName;

@Service
@Slf4j
public class AnalyticalOperationsServiceImpl implements AnalyticalOperationsService {
    private final DeviceRepository deviceRepository;
    private final PlantRepository plantRepository;

    public AnalyticalOperationsServiceImpl(DeviceRepository deviceRepository, PlantRepository plantRepository) {
        this.deviceRepository = deviceRepository;
        this.plantRepository = plantRepository;
    }

    @Override
    public List<Plant> getTop5PlantsAccordingMadeDevicesLast7Days() {
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        return plantRepository.getTop5PlantsAccordingMadeDevicesLast7Days();
    }

    @Override
    public List<Last5DavDTO> getLast5DevicesIncludingPlantsInformation() {
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        return deviceRepository.getLast5DevicesIncludingPlantsInformation();
    }

    @Override
    public List<Last30DaysDTO> getDevicesMadeLast30Days() {
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        return deviceRepository.getDevicesMadeLast30Days();
    }
}
