package com.example.presentationservice.ajax.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "math-micro")
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private double numberOne;
    private double numberTwo;
    private double numberThree;
    public  Number(double numberOne,double numberTwo,double numberThree){
        this.numberOne=numberOne;
        this.numberTwo=numberTwo;
        this.numberThree=numberThree;
    }
    @Override
    public String toString(){
        return "deger{"+
                "num1='"+numberOne+'\''+
                "num2='"+numberTwo+'\''+
                "num3='"+numberThree+'\''+
                '}';


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
}
