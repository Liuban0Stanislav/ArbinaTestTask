package com.arbinatesttask.arbina_test.service.implementation;

import com.arbinatesttask.arbina_test.dto.DeviceDTO;
import com.arbinatesttask.arbina_test.model.Device;
import com.arbinatesttask.arbina_test.model.Plant;
import com.arbinatesttask.arbina_test.repository.DeviceRepository;
import com.arbinatesttask.arbina_test.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.arbinatesttask.arbina_test.service.implementation.MethodNameServiceImpl.getCurrentClassName;
import static com.arbinatesttask.arbina_test.service.implementation.MethodNameServiceImpl.getCurrentMethodName;

/**
 * Класс реализует CRUD операции и бизнесс логику работы с сущностью изделия - {@link Device}.
 * @Версия: 1.0
 * @Дата: 14.02.2024
 * @Автор: Станислав Любань
 */
@Service
@Slf4j
public class DeviceServiceImpl implements DeviceService {
    private final DeviceRepository deviceRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }


    /**
     * Метод находит в БД все записи об устройствах, и возвращает их в виде списка.
     * @return - список ДТО {@link DeviceDTO}
     */
    @Override
    public List<DeviceDTO> getAllDevices() {
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        List<Device> deviceList = deviceRepository.findAll();
        return MapperDTO.mapAllDevicesToAllDevicesDto(deviceList);
    }

    /**
     * Метод находит в БД все записи об устройствах по имени начальника смены, и возвращает их в виде списка.
     * @return - список ДТО {@link DeviceDTO}
     */
    @Override
    public List<DeviceDTO> getDevicesByFirstNameOfShiftHead(String firstNameOfShiftHead){
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        List<Device> deviceList = deviceRepository.getDevicesByFirstNameOfShiftHead(firstNameOfShiftHead);
        return MapperDTO.mapAllDevicesToAllDevicesDto(deviceList);
    }

    /**
     * Метод находит в БД все записи об устройствах по id завода изготовителя, и возвращает их в виде списка.
     * @return - список DTO {@link DeviceDTO}
     */
    @Override
    public List<DeviceDTO> getDeviceByPlantId(Integer id){
        Plant plant = new Plant();
        plant.setId(id);
        List<Device> deviceList = deviceRepository.getDevicesByPlantId(plant);
        return MapperDTO.mapAllDevicesToAllDevicesDto(deviceList);
    }

    /**
     * Метод получает ДТО устройствва {@link DeviceDTO} из контроллера, мапит ее и сохраняет в репозитории,
     * вызывая соответствующий метод {@link DeviceRepository#save(Object)}
     * @param deviceDto - сущность {@link DeviceDTO}
     * @return - сущность {@link DeviceDTO}
     */
    @Override
    public DeviceDTO addDevice(DeviceDTO deviceDto) {
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        Device device = MapperDTO.mapDeviceDtoToDevice(deviceDto);
        device = deviceRepository.save(device);             //из БД возвращается сущность с id
        return MapperDTO.mapDeviceToDeviceDto(device);      //мапим сущность в ДТО и теперь с ID инфо более полное
    }

    /**
     * Метод обращается в репозиторий и удаляет из БД запись по ее id.
     * @param id
     */
    @Override
    public void deleteDevice(int id) {
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        deviceRepository.deleteById(id);
    }
}
