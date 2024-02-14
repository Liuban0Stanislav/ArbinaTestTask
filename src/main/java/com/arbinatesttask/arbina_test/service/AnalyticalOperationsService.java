package com.arbinatesttask.arbina_test.service;

import com.arbinatesttask.arbina_test.dto.Last30DaysDTO;
import com.arbinatesttask.arbina_test.dto.Last5DavDTO;
import com.arbinatesttask.arbina_test.model.Plant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnalyticalOperationsService {
    /**
     * метод возвращает топ-5 заводов производителей упорядоченных по количеству
     * выпущенной продукции за последние 7 дней.
     * @return список заводов.
     */
    List<Plant> getTop5PlantsAccordingMadeDevicesLast7Days();

    /**
     * метод возвращает 5 последних выпущенных устройств с информацией о заводе изготовителе.
     * @return список устройств
     */
    List<Last5DavDTO> getLast5DevicesIncludingPlantsInformation();

    /**
     * метод формирует ежедневную статистику по количеству выпущенных устройств за последние 30 дней.
     * @return список устройств
     */
    List<Last30DaysDTO> getDevicesMadeLast30Days();
}
