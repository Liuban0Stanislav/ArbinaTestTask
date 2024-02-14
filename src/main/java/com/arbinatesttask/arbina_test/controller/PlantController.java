package com.arbinatesttask.arbina_test.controller;

import com.arbinatesttask.arbina_test.model.Plant;
import com.arbinatesttask.arbina_test.service.implementation.PlantServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс-контроллер содержит в себе конечные точки для манипуляций с сущностями завода {@link Plant}.
 * @Версия: 1.0
 * @Дата: 13.02.2024
 * @Автор: Станислав Любань
 */
@RestController
@RequestMapping("/plant")
public class PlantController {
    private final PlantServiceImpl plantService;

    public PlantController(PlantServiceImpl plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public ResponseEntity<List<Plant>> getAllPlants() {
        List<Plant> plantsList = plantService.getAllPlants();
        if (plantsList != null) {
            return ResponseEntity.ok(plantsList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public Plant addPlant(@RequestBody Plant plant) {
        return plantService.addPlant(plant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePlant(@PathVariable int id){
        plantService.deletePlant(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plant> getPlant(@PathVariable int id) {
        Plant plant = plantService.getPlant(id);
        if (plant != null) {
            return ResponseEntity.ok(plant);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
