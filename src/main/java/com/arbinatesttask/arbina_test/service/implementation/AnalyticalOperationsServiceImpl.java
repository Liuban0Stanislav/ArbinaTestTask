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

/**
 * Класс реализует логику работы аналитических операций задания.
 * @Версия: 1.0
 * @Дата: 15.02.2024
 * @Автор: Станислав Любань
 */
@Service
@Slf4j
public class AnalyticalOperationsServiceImpl implements AnalyticalOperationsService {
    private final DeviceRepository deviceRepository;
    private final PlantRepository plantRepository;

    public AnalyticalOperationsServiceImpl(DeviceRepository deviceRepository, PlantRepository plantRepository) {
        this.deviceRepository = deviceRepository;
        this.plantRepository = plantRepository;
    }

    /**
     * метод возвращает топ-5 заводов производителей упорядоченных по количеству
     * выпущенной продукции за последние 7 дней.
     * @return список заводов.
     */
    @Override
    public List<Plant> getTop5PlantsAccordingMadeDevicesLast7Days() {
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        return plantRepository.getTop5PlantsAccordingMadeDevicesLast7Days();
    }

    /**
     * метод возвращает 5 последних выпущенных устройств с информацией о заводе изготовителе.
     * @return список устройств
     */
    @Override
    public List<Last5DavDTO> getLast5DevicesIncludingPlantsInformation() {
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        return deviceRepository.getLast5DevicesIncludingPlantsInformation();
    }

    /**
     * метод формирует ежедневную статистику по количеству выпущенных устройств за последние 30 дней.
     * @return список устройств
     */
    @Override
    public List<Last30DaysDTO> getDevicesMadeLast30Days() {
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        return deviceRepository.getDevicesMadeLast30Days();
    }
}
