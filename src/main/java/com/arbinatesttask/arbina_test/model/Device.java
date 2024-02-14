package com.arbinatesttask.arbina_test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date assemblingDate;
    @Column(nullable = false)
    private String firstNameOfShiftHead;
    @Column(nullable = false)
    private String lastNameOfShiftHead;
    @ManyToOne
    @JoinColumn
    private Plant plantId;

    public Device() {
    }

    public Device(Integer id,
                  String name,
                  Date assemblingDate,
                  String firstNameOfShiftHead,
                  String lastNameOfShiftHead,
                  Plant plantId) {
        this.id = id;
        this.name = name;
        this.assemblingDate = assemblingDate;
        this.firstNameOfShiftHead = firstNameOfShiftHead;
        this.lastNameOfShiftHead = lastNameOfShiftHead;
        this.plantId = plantId;
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

    public Date getAssemblingDate() {
        return assemblingDate;
    }

    public void setAssemblingDate(Date assemblingDate) {
        this.assemblingDate = assemblingDate;
    }

    public String getFirstNameOfShiftHead() {
        return firstNameOfShiftHead;
    }

    public void setFirstNameOfShiftHead(String firstNameOfShiftHead) {
        this.firstNameOfShiftHead = firstNameOfShiftHead;
    }

    public String getLastNameOfShiftHead() {
        return lastNameOfShiftHead;
    }

    public void setLastNameOfShiftHead(String lastNameOfShiftHead) {
        this.lastNameOfShiftHead = lastNameOfShiftHead;
    }

    public Plant getPlantId() {
        return plantId;
    }

    public void setPlantId(Plant plantId) {
        this.plantId = plantId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return
                        Objects.equals(id, device.id) &&
                        Objects.equals(name, device.name) &&
                        Objects.equals(assemblingDate, device.assemblingDate) &&
                        Objects.equals(firstNameOfShiftHead, device.firstNameOfShiftHead) &&
                        Objects.equals(lastNameOfShiftHead, device.lastNameOfShiftHead) &&
                        Objects.equals(plantId, device.plantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, assemblingDate, firstNameOfShiftHead, lastNameOfShiftHead, plantId);
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", assemblingDate=" + assemblingDate +
                ", firstNameOfShiftHead='" + firstNameOfShiftHead + '\'' +
                ", lastNameOfShiftHead='" + lastNameOfShiftHead + '\'' +
                ", plantId=" + plantId +
                '}';
    }
}
