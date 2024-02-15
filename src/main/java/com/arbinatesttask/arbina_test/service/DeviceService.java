package com.arbinatesttask.arbina_test.service;

import com.arbinatesttask.arbina_test.dto.DeviceDTO;
import com.arbinatesttask.arbina_test.model.Device;
import com.arbinatesttask.arbina_test.model.Plant;

import java.util.List;

public interface DeviceService {

    /**
     * метод получения всех устройств.
     * @return список устройств
     */
    List<DeviceDTO> getAllDevices();


    /**
     * метод получения списка устройств по имени начальника смены.
     * @param firstNameOfShiftHead - имя начальника смены
     * @return список устройств
     */
    List<DeviceDTO> getDevicesByFirstNameOfShiftHead(String firstNameOfShiftHead);

    /**
     * метод получения списка устройств по id завода изготовителя.
     * @param id - завода изготовителя
     * @return список устройств
     */
    List<DeviceDTO> getDeviceByPlantId(Integer id);

    /**
     * метод добавления устройства в БД.
     * @param device сущность устройства
     * @return сущность добаленного устройства
     */
    DeviceDTO addDevice(DeviceDTO device);

    /**
     * метод удаление устройства из БД по id устройства.
     * @param id - id устройства
     */
    void deleteDevice(int id);
}
