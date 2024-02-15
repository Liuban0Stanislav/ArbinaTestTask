package com.arbinatesttask.arbina_test.service;

import com.arbinatesttask.arbina_test.dto.PlantDTO;
import com.arbinatesttask.arbina_test.model.Plant;

import java.util.List;

/**
 * Интерфейс предписывает реализовывать CRUD методы и методы бизнесс логики для работы с сущностью
 * завода - {@link Plant}.
 * @Версия: 1.0
 * @Дата: 13.02.2024
 * @Автор: Станислав Любань
 */
public interface PlantService {

    List<PlantDTO> getAllPlants();

    Plant addPlant(PlantDTO plantDto);

    void deletePlant(int id);

    PlantDTO getPlant(int id);
}
