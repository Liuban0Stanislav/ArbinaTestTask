package com.arbinatesttask.arbina_test.service.implementation;

import com.arbinatesttask.arbina_test.dto.DeviceDTO;
import com.arbinatesttask.arbina_test.dto.PlantDTO;
import com.arbinatesttask.arbina_test.model.Device;
import com.arbinatesttask.arbina_test.model.Plant;
import com.arbinatesttask.arbina_test.repository.PlantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.arbinatesttask.arbina_test.service.implementation.MethodNameServiceImpl.getCurrentClassName;
import static com.arbinatesttask.arbina_test.service.implementation.MethodNameServiceImpl.getCurrentMethodName;

/**
 * Класс-мапер для конвертации ДТО в сущности и наоборот.
 * @Версия: 1.0
 * @Дата: 15.02.2024
 * @Автор: Станислав Любань
 */
@Component
@Slf4j
public class MapperDTO{
    private static PlantRepository plantRepository;

    public MapperDTO(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    /**
     * Метод конвертирует список {@link PlantDTO} -> список {@link Plant}
     * @param listPlant - список сущностей {@link PlantDTO}
     * @return список сущностей {@link Plant}
     */
    public static List<PlantDTO> mapAllPlantsToAllPlantsDto(List<Plant> listPlant) {
        log.info("вызван метод мапера "+ getCurrentClassName() + ": " + getCurrentMethodName());

        List<PlantDTO> listPlantDto = new ArrayList<>();

        for (Plant plant: listPlant) {
            PlantDTO plantDto = new PlantDTO();

            plantDto.setId(plant.getId());
            plantDto.setName(plant.getName());
            plantDto.setAddress(plant.getAddress());
            plantDto.setDateOfConstruction(plant.getDateOfConstruction());
            plantDto.setDateOfDbAddition(plant.getDateOfDbAddition());

            listPlantDto.add(plantDto);
        }
        return listPlantDto;
    }
    /**
     * Метод конвертирует {@link PlantDTO} -> {@link Plant}
     * @param plantDto - сущность {@link PlantDTO}
     * @return - ДТО {@link Plant}
     */
    public static Plant mapPlantDtoToPlant(PlantDTO plantDto) {
        log.info("вызван метод мапера "+ getCurrentClassName() + ": " + getCurrentMethodName());
        Plant plant = new Plant();

        plant.setId(plantDto.getId());
        plant.setName(plantDto.getName());
        plant.setAddress(plantDto.getAddress());
        plant.setDateOfConstruction(plantDto.getDateOfConstruction());
        plant.setDateOfDbAddition(plantDto.getDateOfDbAddition());

        return plant;
    }


    /**
     * Метод конвертирует {@link Plant} -> {@link PlantDTO}
     * @param plant - сущность {@link Plant}
     * @return - ДТО {@link PlantDTO}
     */
    public static PlantDTO mapPlantToPlantDto(Plant plant) {
        log.info("вызван метод мапера "+ getCurrentClassName() + ": " + getCurrentMethodName());
        PlantDTO plantDTO = new PlantDTO();

        plantDTO.setId(plant.getId());
        plantDTO.setName(plant.getName());
        plantDTO.setAddress(plant.getAddress());
        plantDTO.setDateOfConstruction(plant.getDateOfConstruction());
        plantDTO.setDateOfDbAddition(plant.getDateOfDbAddition());

        return plantDTO;
    }

    /**
     * Метод конвертирует список {@link Device} -> {@link DeviceDTO}
     * @param listDevice - список {@link Device}
     * @return deviceDTOList - список {@link DeviceDTO}
     */
    public static List<DeviceDTO> mapAllDevicesToAllDevicesDto(List<Device> listDevice){
        log.info("вызван метод мапера "+ getCurrentClassName() + ": " + getCurrentMethodName());

        List<DeviceDTO> deviceDTOList = new ArrayList<>();

        for (Device device: listDevice) {
            deviceDTOList.add(mapDeviceToDeviceDto(device));
        }
        return deviceDTOList;
    }

    /**
     * Метод конвертирует сущность {@link Device} -> {@link DeviceDTO}
     * @param device - {@link Device}
     * @return - ДТО {@link DeviceDTO}
     */
    public static DeviceDTO mapDeviceToDeviceDto(Device device){
        log.info("вызван метод мапера "+ getCurrentClassName() + ": " + getCurrentMethodName());
        DeviceDTO deviceDto = new DeviceDTO();

        deviceDto.setId(device.getId());
        deviceDto.setName(device.getName());
        deviceDto.setAssemblingDate(device.getAssemblingDate());
        deviceDto.setFirstNameOfShiftHead(device.getFirstNameOfShiftHead());
        deviceDto.setLastNameOfShiftHead(device.getLastNameOfShiftHead());
        deviceDto.setPlantId(device.getPlantId().getId());

        return deviceDto;
    }

    /**
     * Метод конвертирует ДТО {@link DeviceDTO} -> {@link Device}
     * @param deviceDto - ДТО {@link DeviceDTO}
     * @return - сущность {@link Device}
     */
    public static Device mapDeviceDtoToDevice(DeviceDTO deviceDto){
        log.info("вызван метод мапера "+ getCurrentClassName() + ": " + getCurrentMethodName());
        Device device = new Device();

        device.setId(deviceDto.getId());
        device.setName(deviceDto.getName());
        device.setAssemblingDate(deviceDto.getAssemblingDate());
        device.setFirstNameOfShiftHead(deviceDto.getFirstNameOfShiftHead());
        device.setLastNameOfShiftHead(deviceDto.getLastNameOfShiftHead());

        Plant plant = getPlantInfo(deviceDto.getPlantId());
        device.setPlantId(plant);
        return device;
    }

    /**
     * Метод находит в репозитории сущность {@link Plant} по заданному id.
     * @param plantId - целое число, id нужного завода.
     * @return - сущность завода {@link Plant}
     */
    private static Plant getPlantInfo(int plantId){
        log.info("вызван метод мапера "+ getCurrentClassName() + ": " + getCurrentMethodName());
        return plantRepository.findById(plantId).get();
    }
}
