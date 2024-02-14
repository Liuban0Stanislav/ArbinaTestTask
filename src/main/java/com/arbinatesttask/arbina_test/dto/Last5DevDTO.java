package com.arbinatesttask.arbina_test.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class Last5DevDTO {
    @Column(name = "device_name")
    private String deviceName;
    @Column(name = "assembling_date")
    private String assemblingDate;
    @Column(name = "first_name_of_shift_head")
    private String firstNameOfShiftHead;
    @Column(name = "last_name_of_shift_head")
    private String lastNameOfShiftHead;
    @Column(name = "plant_name")
    private String plantName;
}
