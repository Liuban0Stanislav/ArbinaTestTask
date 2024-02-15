package com.arbinatesttask.arbina_test.controller;

import com.arbinatesttask.arbina_test.dto.PlantDTO;
import com.arbinatesttask.arbina_test.model.Plant;
import com.arbinatesttask.arbina_test.service.PlantService;
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
    private final PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public ResponseEntity<List<PlantDTO>> getAllPlants() {
        List<PlantDTO> plantsDtoList = plantService.getAllPlants();
        if (plantsDtoList != null) {
            return ResponseEntity.ok(plantsDtoList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public Plant addPlant(@RequestBody PlantDTO plantDto) {
        return plantService.addPlant(plantDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePlant(@PathVariable int id){
        plantService.deletePlant(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantDTO> getPlant(@PathVariable int id) {
        PlantDTO plantDto = plantService.getPlant(id);
        if (plantDto != null) {
            return ResponseEntity.ok(plantDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
