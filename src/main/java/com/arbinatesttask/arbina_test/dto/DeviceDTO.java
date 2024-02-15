package com.arbinatesttask.arbina_test.dto;

import lombok.Data;

import java.util.Date;
@Data
public class DeviceDTO {
    private Integer id;
    private String name;
    private Date assemblingDate;
    private String firstNameOfShiftHead;
    private String lastNameOfShiftHead;
    private Integer plantId;
}
