package com.arbinatesttask.arbina_test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Plant")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private Date dateOfConstruction;
    private Date dateOfDbAddition;
    @OneToMany
    @JsonIgnore
    private List<Device> deviceId;

    public Plant() {
    }

    public Plant(Integer id,
                 String name,
                 String address,
                 Date dateOfConstruction,
                 List<Device> deviceId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dateOfConstruction = dateOfConstruction;
        this.dateOfDbAddition = new Date(System.currentTimeMillis()); //дата добавления это текущая дата.
        this.deviceId = deviceId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfConstruction() {
        return dateOfConstruction;
    }

    public void setDateOfConstruction(Date dateOfConstruction) {
        this.dateOfConstruction = dateOfConstruction;
    }

    public Date getDateOfDbAddition() {
        return dateOfDbAddition;
    }

    public void setDateOfDbAddition(Date dateOfDbAddition) {
        this.dateOfDbAddition = dateOfDbAddition;
    }

    public List<Device> getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(List<Device> deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return
                Objects.equals(id, plant.id) &&
                Objects.equals(name, plant.name) &&
                Objects.equals(address, plant.address) &&
                Objects.equals(dateOfConstruction, plant.dateOfConstruction) &&
                Objects.equals(dateOfDbAddition, plant.dateOfDbAddition) &&
                Objects.equals(deviceId, plant.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, dateOfConstruction, dateOfDbAddition, deviceId);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", dateOfConstruction=" + dateOfConstruction +
                ", dateOfDbAddition=" + dateOfDbAddition +
                ", deviceId=" + deviceId +
                '}';
    }
}
