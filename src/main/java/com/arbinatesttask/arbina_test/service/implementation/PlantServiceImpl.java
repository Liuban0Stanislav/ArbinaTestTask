package com.arbinatesttask.arbina_test.service.implementation;

import com.arbinatesttask.arbina_test.model.Plant;
import com.arbinatesttask.arbina_test.repository.PlantRepository;
import com.arbinatesttask.arbina_test.service.PlantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.arbinatesttask.arbina_test.service.implementation.MethodNameServiceImpl.*;

/**
 * Класс реализует CRUD операции и бизнесс логику работы с сущностью завода - {@link Plant}.
 * @Версия: 1.0
 * @Дата: 13.02.2024
 * @Автор: Станислав Любань
 */
@Service
@Slf4j
public class PlantServiceImpl implements PlantService {
    private final PlantRepository plantRepository;

    public PlantServiceImpl(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    /**
     * Метод находит в БД все записи о заводах и возвращает их в виде списка.
     * @return - список сущностей {@link Plant}
     */
    @Override
    public List<Plant> getAllPlants(){
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        return plantRepository.findAll();
    }

    /**
     * Метод получает сущность завода {@link Plant} из контроллера и сохраняет ее в репозитории,
     * вызывая соответствующий метод {@link PlantRepository#save(Object)}
     * @param plant - сущность {@link Plant}
     * @return - сущность {@link Plant}
     */
    @Override
    public Plant addPlant(Plant plant){
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        return plantRepository.save(plant);
    }

    /**
     * Метод обращается в репозиторий и удаляет из БД запись по ее id.
     * @param id
     */
    @Override
    public void deletePlant(int id){
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        plantRepository.deleteById(id);
    }

    @Override
    public Plant getPlant(int id){
        log.info("вызван метод сервиса "+ getCurrentClassName() + ": " + getCurrentMethodName());
        return plantRepository.findById(id).get();
    }
}
