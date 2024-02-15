package com.arbinatesttask.arbina_test.service.implementation;

import com.arbinatesttask.arbina_test.dto.DeviceDTO;
import com.arbinatesttask.arbina_test.dto.PlantDTO;
import com.arbinatesttask.arbina_test.model.Device;
import com.arbinatesttask.arbina_test.model.Plant;
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

    public static List<DeviceDTO> mapAllDevicesToAllDevicesDto(List<Device> listDevice){
        log.info("вызван метод мапера "+ getCurrentClassName() + ": " + getCurrentMethodName());

        List<DeviceDTO> deviceDTOList = new ArrayList<>();

        for (Device device: listDevice) {
            DeviceDTO deviceDTO = new DeviceDTO();

            deviceDTO.setId(device.getId());
            deviceDTO.setName(device.getName());
            deviceDTO.setAssemblingDate(device.getAssemblingDate());
            deviceDTO.setFirstNameOfShiftHead(device.getFirstNameOfShiftHead());
            deviceDTO.setLastNameOfShiftHead(device.getLastNameOfShiftHead());
            log.info("ID ЗАВОДА: {}", device.getPlantId());
            log.info("ID ЗАВОДА.getId(): {}", device.getPlantId().getId());
            deviceDTO.setPlantId(device.getPlantId().getId());

            deviceDTOList.add(deviceDTO);
        }
        return deviceDTOList;
    }
}
