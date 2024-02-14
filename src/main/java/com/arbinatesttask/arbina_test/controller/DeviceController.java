package com.arbinatesttask.arbina_test.controller;

import com.arbinatesttask.arbina_test.model.Device;
import com.arbinatesttask.arbina_test.service.DeviceService;
import com.arbinatesttask.arbina_test.service.implementation.DeviceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс-контроллер содержит в себе конечные точки для манипуляций с сущностями устройства {@link Device}.
 * @Версия: 1.0
 * @Дата: 13.02.2024
 * @Автор: Станислав Любань
 */
@RestController
@RequestMapping("/device")
public class DeviceController {
    private final DeviceServiceImpl deviceService;

    public DeviceController(DeviceServiceImpl deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devicesList = deviceService.getAllDevices();
        if (devicesList != null) {
            return ResponseEntity.ok(devicesList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{firstNameOfShiftHead}")
    public ResponseEntity<List<Device>> getDevicesByFirstNameOfShiftHead(@PathVariable String firstNameOfShiftHead) {
        List<Device> devicesList = deviceService.getDevicesByFirstNameOfShiftHead(firstNameOfShiftHead);
        if (devicesList != null) {
            return ResponseEntity.ok(devicesList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/plant/{id}")
    public ResponseEntity<List<Device>> getDeviceByPlantId(@PathVariable Integer id) {
        List<Device> devicesList = deviceService.getDeviceByPlantId(id);
        if (devicesList != null) {
            return ResponseEntity.ok(devicesList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping
    public Device addDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDevice(@PathVariable int id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.ok().build();
    }
}
