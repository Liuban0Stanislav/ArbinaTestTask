package com.arbinatesttask.arbina_test.controller;

import com.arbinatesttask.arbina_test.dto.Last30DaysDTO;
import com.arbinatesttask.arbina_test.dto.Last5DavDTO;
import com.arbinatesttask.arbina_test.model.Device;
import com.arbinatesttask.arbina_test.model.Plant;
import com.arbinatesttask.arbina_test.service.implementation.AnalyticalOperationsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Класс-контроллер содержит в себе конечные точки с аналитическими операциями для {@link Device} и {@link Plant}.
 * @Версия: 1.0
 * @Дата: 13.02.2024
 * @Автор: Станислав Любань
 */
@RestController
@RequestMapping("/analytic")
public class AnalyticalOperationsController {

    private AnalyticalOperationsServiceImpl operationsService;

    public AnalyticalOperationsController(AnalyticalOperationsServiceImpl operationsService) {
        this.operationsService = operationsService;
    }

    @GetMapping("/get_5_plants")
    public ResponseEntity<List<Plant>> getTop5PlantsAccordingMadeDevicesLast7Days(){
        if(operationsService.getTop5PlantsAccordingMadeDevicesLast7Days() != null){
           return ResponseEntity.ok(operationsService.getTop5PlantsAccordingMadeDevicesLast7Days());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/get_5_devices")
    public ResponseEntity<List<Last5DavDTO>> getLast5DevicesIncludingPlantsInformation(){
        if(operationsService.getLast5DevicesIncludingPlantsInformation() != null){
            return ResponseEntity.ok(operationsService.getLast5DevicesIncludingPlantsInformation());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @GetMapping("/get_devices_last_30_days")
    public ResponseEntity<List<Last30DaysDTO>> getDevicesMadeLast30Days(){
        if(operationsService.getDevicesMadeLast30Days() != null){
            return ResponseEntity.ok(operationsService.getDevicesMadeLast30Days());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
