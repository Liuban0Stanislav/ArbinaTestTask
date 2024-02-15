package com.arbinatesttask.arbina_test.dto;

import lombok.Data;

import java.util.Date;
@Data
public class PlantDTO {
    private Integer id;
    private String name;
    private String address;
    private Date dateOfConstruction;
    private Date dateOfDbAddition;
}
