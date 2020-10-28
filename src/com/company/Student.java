package com.company;

public class Student {
    private int roll;
    private String name;

    public Student(String name , int roll){
        this.name = name;
        this.roll = roll;
    }

    public String getName(){
        return name;
    }

    public int getRoll(){
        return roll;
    }
}
