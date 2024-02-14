package com.arbinatesttask.arbina_test.service.implementation;

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
 * @Дата: 13.02.2024
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
     * @return - список сущностей {@link Device}
     */
    @Override
    public List<Device> getAllDevices() {
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        return deviceRepository.findAll();
    }

    /**
     * Метод находит в БД все записи об устройствах по имени начальника смены, и возвращает их в виде списка.
     * @return - список сущностей {@link Device}
     */
    @Override
    public List<Device> getDevicesByFirstNameOfShiftHead(String firstNameOfShiftHead){
        return deviceRepository.getDevicesByFirstNameOfShiftHead(firstNameOfShiftHead);
    }

    /**
     * Метод находит в БД все записи об устройствах по id завода изготовителя, и возвращает их в виде списка.
     * @return - список сущностей {@link Device}
     */
    @Override
    public List<Device> getDeviceByPlantId(Integer id){
        Plant plant = new Plant();
        plant.setId(id);
        return deviceRepository.getDevicesByPlantId(plant);
    }

    /**
     * Метод получает сущность устройствва {@link Device} из контроллера, и сохраняет ее в репозитории,
     * вызывая соответствующий метод {@link DeviceRepository#save(Object)}
     * @param device - сущность {@link Device}
     * @return - сущность {@link Device}
     */
    @Override
    public Device addDevice(Device device) {
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        return deviceRepository.save(device);
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
