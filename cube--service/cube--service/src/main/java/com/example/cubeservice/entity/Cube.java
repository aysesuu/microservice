package com.example.cubeservice.entity;


import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name="presentation_service")
@NoArgsConstructor

public class Cube {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "value")
    private double value;
    @Column(name = "number_one")
    @Nullable
    private double numberOne;
    @Column(name = "number_two")
    @Nullable
    private double numberTwo;

    @Column(name = "number_three")
    @Nullable
    private double numberThree;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(double numberOne) {
        this.numberOne = numberOne;
    }

    public double getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(double numberTwo) {
        this.numberTwo = numberTwo;
    }

    public double getNumberThree() {
        return numberThree;
    }

    public void setNumberThree(double numberThree) {
        this.numberThree = numberThree;
    }

    public Cube(double numberOne, double numberTwo, double numberThree, double value) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.numberThree = numberThree;
        this.value=value;

    }

}
