package com.example.squareservice.entity;

import jakarta.annotation.Nullable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="presentation_service")
@Entity
public class Square {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "value")
    private double value;
    @Column(name = "number_one")
    @Nullable
    private double numberOne;
    @Column(name = "number_two")
    @Nullable
    private double numberTwo;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Square(double numberOne, double numberTwo,double value){
        this.numberOne=numberOne;
        this.numberTwo=numberTwo;
        this.value=value;
    }
}
